package Ejercicios;

import java.io.File;

public class VerInf {
    public static void main(String[] args) {
        String fichero;
        boolean valido = false;
        File f;

        if (args.length > 0) {
            f = new File(args[0]);
        } else {
            System.out.println("Introduce el nombre del archivo:");
            fichero = System.console().readLine();
            f = new File(fichero);
        }

        while (!valido) {
            if (f.exists()) {
                System.out.println("Nombre: " + f.getName() + "\n"
                        + "Ruta: " + f.getPath() + "\n"
                        + "Ruta absoluta: " + f.getAbsolutePath() + "\n"
                        + "Tamaño: " + f.length() + "\n"
                        + "¿Lectura?: " + f.canRead() + "\n"
                        + "¿Escritura?: " + f.canWrite() + "\n"
                        + "¿Es directorio?: " + f.isDirectory() + "\n"
                        + "¿Es fichero?: " + f.isFile() + "\n");
                valido = true;
            } else {
                System.out.println("No existe el archivo");
                System.out.println("Introduce otra vez el nombre del archivo:");
                fichero = System.console().readLine();
                f = new File(fichero);
            }
        }
    }
}