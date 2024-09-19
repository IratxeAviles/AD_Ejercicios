package Ejercicios.Objetos;

import java.io.*;

public class LeerFichObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fichero = new File("FichData.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        while (true) {
            try {
                Persona persona = (Persona) dataIS.readObject(); // leer primera persona sin leer de FichData.dat
                System.out.println(persona.getNombre() + " " + persona.getEdad()); // sacar inforcion de persona por sout
            } catch (EOFException e) {
                break;
            }
        }
        dataIS.close();
    }
}

