package Ejemplos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Offset {
    public static void main(String[] args) {
        File fis = new File("hula.txt");
        FileReader isr;
        try {
            isr = new FileReader(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        char[] cbuf = new char[10];

        try { // lee los datos en el buffer
            int i = isr.read(cbuf, 2, 5);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (char c : cbuf) { // caracteres vacios
            if (((int) c) == 0)
                c = '-';
            System.out.print(c);
        }
    }
}
