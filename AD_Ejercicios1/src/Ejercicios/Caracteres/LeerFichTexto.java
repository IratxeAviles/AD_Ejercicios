package Ejercicios.Caracteres;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto {
    public static void main(String[] args) {
        File fichero = new File("hula.txt");
        FileReader fic;
        try {
            fic = new FileReader(fichero);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        int i;
        while (true) {
            try {
                if ((i = fic.read()) == -1) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            System.out.print((char) i);
        }
        try {
            fic.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}