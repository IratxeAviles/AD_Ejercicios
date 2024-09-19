package Ejercicios.RandomAccessFile;

import java.io.*;

public class AccionesElementoAleatorio {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("src/Ficheros/RandomAccessFile.dat", "rw");

        int id = 5;
        int departamento = 10;
        double salario = 2100.0;
        String apellido = "Ruiz";
        char[] apellido_array = new char[10];

        while (apellido.length() < 10) {
            apellido = apellido.concat(".");
        }

        //LeerElementoAleatorio(raf, id);
        EscribirElementoAleatorio(raf, id, apellido, departamento, salario);
        //ModificarElementoAleatorio(raf, id, apellido, departamento, salario);

        raf.close(); //Cerramos fichero
    }

    static void LeerElementoAleatorio(RandomAccessFile raf, int id_empleado) throws IOException {
        //Variables a declarar: datos del empleado
        int id, departamento, posicion;
        double salario;
        char[] apellido = new char[10];

        posicion = (id_empleado - 1) * 36; //Porque cada empleado ocupa 36 bytes

        if (posicion >= raf.length()) { //Si nos pasamos de largo, es que no existe el empleado
            System.out.println("NO EXISTE EL EMPLEADO");
        } else {
            raf.seek(posicion); //Nos posicionamos donde indique "posicion"
            id = raf.readInt();
            for (int i = 0; i < apellido.length; i++) { //Recorremos uno a uno los caracteres del apellido
                apellido[i] = raf.readChar();
            }
            String apellidos = new String(apellido); //Se convierte el array a string
            departamento = raf.readInt();
            salario = raf.readDouble();

            if (id > 0) { //Eso es que devuelve un id
                System.out.println("Empleado: " + id + " Apellido: " + apellidos + " Departamento: " + departamento + " Salario: " + salario);
            }
        }
    }

    static void EscribirElementoAleatorio(RandomAccessFile raf, int id_empleado, String apellido, int departamento, double salario) throws IOException {
        int posicion;
        posicion = (id_empleado - 1) * 36; //Porque cada empleado ocupa 36 bytes

        if (posicion >= raf.length()) { //Si nos pasamos de largo, es que no existe el empleado y podemos crearlo
            raf.seek(posicion);
            raf.writeInt(id_empleado);
            raf.writeChars(apellido);
            raf.writeInt(departamento);
            raf.writeDouble(salario);
        } else { //Sí que existe o puede existir
            System.out.println("El empleado ya existe");
        }
        LeerElementoAleatorio(raf, id_empleado);
    }

    static void ModificarElementoAleatorio(RandomAccessFile raf, int id_empleado, String apellido, int departamento, double salario) throws IOException {
        LeerElementoAleatorio(raf, id_empleado);
        int posicion;
        posicion = (id_empleado - 1) * 36; //Porque cada empleado ocupa 36 bytes

        if (posicion >= raf.length()) { //Si nos pasamos de largo, es que no existe el empleado
            System.out.println("NO EXISTE EL EMPLEADO");
        } else { //Sí que existe o puede existir
            raf.seek(posicion + 4); // +4 porque ese es el id_empleado
            raf.writeChars(apellido);
            raf.writeInt(departamento);
            raf.writeDouble(salario);
        }
        LeerElementoAleatorio(raf, id_empleado);
    }
}

