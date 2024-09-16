package Ejercicios.Caracteres;

import java.io.*;

public class EscribirCadenaFich {
    public static void main(String[] args) throws IOException {
        String textos[] = {"Texto","de","prueba"};

        File fichero = new File("hula.txt");

        FileWriter fw = new FileWriter(fichero, true);
        for(int i=0;i<textos.length;i++){
          fw.write(textos[i]);
          fw.write(" ");
          fw.flush(); // Sirve para escribir y cargar, en vez de tener que esperar al close para que escriba
        }
        fw.close();
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
