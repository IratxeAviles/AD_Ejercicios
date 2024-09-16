package Ejercicios.Objetos;

import java.io.*;

public class LeerFichObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fichero = new File("FichData.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        try {
            while (true) {
                Persona persona = (Persona) dataIS.readObject();
                System.out.println("Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
            }
        } catch (EOFException e) {
            System.out.println("error");
        }
        dataIS.close();
    }
}
// NO FUNCIONA
