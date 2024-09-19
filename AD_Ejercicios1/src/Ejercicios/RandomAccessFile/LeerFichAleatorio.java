package Ejercicios.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("src/Ficheros/RandomAccessFile.dat", "r");

        int id, departamento, posicion;
        double salario;
        char[] apellido = new char[10];

        posicion = 0;

        while (true) {
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

            //Nos posicionamos para el siguiente empleando, teniendo en cuenta que cada uno ocupa 36 bytes
            posicion = posicion + 36;

            if (raf.getFilePointer() == raf.length()) {
                break;
            }

        }

        raf.close();
    }
}
