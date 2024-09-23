package Ejercicios.Objetos;

import java.io.*;

public class EscribirFichObject {
    public static void main(String[] args) throws IOException {
        File fichero = new File("./src/Ficheros/FichPersona.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

        Persona[] personas = new Persona[8];

        String[] nombres = {"Ana", "Luis, Miguel", "Alicia", "Pedro", "Manuel", "Andrés",
                "Julio", "Antonio", "María Jesús"};
        int[] edades = {14, 15, 13, 15, 16, 12, 16, 14, 13};

        for(int i = 0; i < personas.length; i++){
            personas[i] = new Persona(nombres[i], edades[i]);
            dataOS.writeObject(personas[i]);
        }
        dataOS.close(); //cerrar stream
    }
}
