package Ejercicios.RandomAccessFile;

import java.io.*;

public class EscribirFichAleatorio {
    public static void main(String[] args) throws IOException {
        Empleado[] empleados = new Empleado[4];
        empleados[0] = new Empleado("Aviles", 1, 2000.0);
        empleados[1] = new Empleado("Guinea", 2, 1500.0);
        empleados[2] = new Empleado("Garcia", 3, 1700.0);
        empleados[3] = new Empleado("Lopez", 4, 2200.0);

        for (int i = 0; i < empleados.length; i++) {
            for (int j = 0; j < 10 - empleados[i].getApellido().length(); j++) {
                empleados[i].getApellido().concat(".");
            }
        }

        RandomAccessFile raf = new RandomAccessFile("RandomAccessFile.dat", "rw");

        for (int i = 0; i < empleados.length; i++) {
            empleados[i].setCodigo(i + 1);
            raf.writeInt(empleados[i].getCodigo());
            raf.writeChars(empleados[i].getApellido());
            raf.writeInt(empleados[i].getDepartamento());
            raf.writeDouble(empleados[i].getSalario());
        }
        raf.close();
    }
}
