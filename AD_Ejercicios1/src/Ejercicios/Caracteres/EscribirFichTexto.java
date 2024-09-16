package Ejercicios.Caracteres;

import java.io.*;

public class EscribirFichTexto {
    public static void main(String[] args) throws IOException {
        String texto = "Texto de pruebo";
        char[] textoArray = texto.toCharArray();

        File fichero = new File("hula.txt");

        FileWriter fw = new FileWriter(fichero, true);
        for (int i = 0; i < textoArray.length; i++) {
            fw.write(textoArray[i]); // caracter de uno en uno
        }
        // fw.write(textoArray); // para escribirlo entero
        fw.close(); //Cerramos flujo de salida (si no lo ponemos no escribe)

        try {
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
