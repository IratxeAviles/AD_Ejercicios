package Ejercicios.RandomAccessFile;

import java.io.*;

public class EscribirFichAleatorio {
    public static void main(String[] args) throws IOException {
        Empleado[] empleados = new Empleado[4];
        empleados[0] = new Empleado(1, "Aviles", 10, 2000.0);
        empleados[1] = new Empleado(2, "Guinea", 20, 1500.0);
        empleados[2] = new Empleado(3, "Garcia", 30, 1700.0);
        empleados[3] = new Empleado(4, "Lopez", 40, 2200.0);

        for (int i = 0; i < empleados.length; i++) {
            String apellido = empleados[i].getApellido();
            while (apellido.length() < 10) {
                apellido = apellido.concat(".");
            }
            empleados[i].setApellido(apellido);
        }

        RandomAccessFile raf = new RandomAccessFile("src/Ficheros/RandomAccessFile.dat", "rw");

        for (int i = 0; i < empleados.length; i++) {
            raf.writeInt(empleados[i].getIdEmpleado());
            raf.writeChars(empleados[i].getApellido());
            raf.writeInt(empleados[i].getDepartamento());
            raf.writeDouble(empleados[i].getSalario());
        }
        raf.close();
    }
}
