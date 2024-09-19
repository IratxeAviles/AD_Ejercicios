package Ejercicios.RandomAccessFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFichAleatorio {
    public static void main(String[] args) throws IOException {
        RandomAccessFile raf = new RandomAccessFile("RandomAccessFile.dat", "r");
        // raf.seek(50*(4-1));
        byte[] bytes = new byte[32];
        System.out.println(raf.readInt());
        System.out.print(raf.readChar());
        System.out.println(raf.readInt());
        System.out.println(raf.readDouble());

        raf.close();

        // CORREGIR
    }
}
