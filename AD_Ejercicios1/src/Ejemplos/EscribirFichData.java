package Ejemplos;

import java.io.*;

public class EscribirFichData {
    public static void main(String[] args) throws IOException {
        File fichero = new File("FichData.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        DataOutputStream dataOS = new DataOutputStream(fileout);
        String[] nombres = {"Ana", "Luis, Miguel", "Alicia", "Pedro", "Manuel", "Andrés",
                "Julio", "Antonio", "María Jesús"};
        int[] edades = {14, 15, 13, 15, 16, 12, 16, 14, 13};

        for (int i = 0; i < edades.length; i++) {
            dataOS.writeUTF(nombres[i]); //inserta nombre, si se escriben los strings porque la tabla ascii se escribe con numeros
            dataOS.writeInt(edades[i]); //inserta edad, al haber escrito los numeros en int, DataOutputStream escribe lo equivalente a la tabla ascii
        }
        dataOS.close(); //cerrar stream
    }
}