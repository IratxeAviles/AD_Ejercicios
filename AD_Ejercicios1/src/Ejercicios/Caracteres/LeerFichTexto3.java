package Ejercicios.Caracteres;

import java.io.*;

public class LeerFichTexto3 {
    public static void main(String[] args) {
        try {
            File fichero = new File(args[0]);
            FileReader fic = new FileReader(fichero);
            BufferedReader br = new BufferedReader(fic);

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.print(linea);
            }
            br.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Fichero no encontrado");
        } catch (IOException ioException) {
            System.out.println("Error al leer el fichero");
        }
    }
}
