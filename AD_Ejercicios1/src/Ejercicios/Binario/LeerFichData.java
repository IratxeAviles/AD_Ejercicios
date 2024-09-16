package Ejercicios.Binario;

import java.io.*;

public class LeerFichData {
    public static void main(String[] args) throws IOException {
        File fichero = new File("FichData.dat");
        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream dataIS = new DataInputStream(filein);

        while (dataIS.available() > 0) {
            //Si lo pusieramos al reves, no funcionaría, porque el primery byte es String
            System.out.println(dataIS.readUTF());
            System.out.println(dataIS.readInt());
        }
        dataIS.close();
    }
}
