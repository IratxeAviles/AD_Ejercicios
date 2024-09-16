package Ejercicios.Caracteres;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFichBR {
    public static void main(String[] args) {
        try {
            BufferedWriter fichero = new BufferedWriter(new FileWriter("FichTexto.txt")); // creamos todo en la misma linea
            for (int i = 1; i < 11; i++) {
                fichero.write("Fila numero: " + i); // escribe una linea
                fichero.newLine(); // escribe un salto de línea
            }
            fichero.close();
        } catch (FileNotFoundException fn) {
            System.out.println("No se encuentra el fichero");
        } catch (IOException io) {
            System.out.println("Error de E/S ");
        }
    }
}
