package Ejercicios.Caracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto2 { // SIN CORREGIR
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("HAY QUE INTRODUCIR UN ARGUMENTO....");
        } else {
            try {
                String entrada = args[0];
                File fichero = new File(entrada);//"ejemplofichtexto.txt";
                FileReader fic = new FileReader(fichero);
                int i = 20;
                //pinta uno a uno los caracteres
                while ((i = fic.read()) != -1)
                    System.out.println((char) i);
            } catch (FileNotFoundException e) {
                System.out.println("Fichero no encontrado");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
