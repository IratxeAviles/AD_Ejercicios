package Ejercicios;

import java.io.File;
import java.io.IOException;

public class CrearDir {
    public static void main(String[] args) {
        File d = new File("NUEVODIR");
        if (d.mkdir()) {
            System.out.println("Directorio creado");
        } else {
            System.out.println("Directorio no pudo crearse");
        }

        File f1 = new File(d, "fichero1.txt");
        File f2 = new File(d, "fichero2.txt");
        try {
            if (f1.createNewFile()) {
                System.out.println("Fichero fichero1 creado");
            } else {
                System.out.println("Fichero fichero1 no pudo crearse");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            if (f2.createNewFile()) {
                System.out.println("Fichero fichero2 creado");
            } else {
                System.out.println("Fichero fichero2 no pudo crearse");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (f2.delete()) {
            System.out.println("Fichero fichero2 borrado");
        } else {
            System.out.println("Fichero fichero2 no pudo borrarse");
        }
        if (d.delete()) { // No puede borrarse porque delete() en un directorio necesita no tener archivos dentro
            System.out.println("Directorio borrado");
        } else {
            System.out.println("Directorio no pudo borrarse");
        }
    }
}
