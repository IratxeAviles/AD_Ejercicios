package Ejercicios.Objetos;

import java.io.*;

public class ModificarFichDep { // Modifica un departamento de Departamentos.dat
    public static void main(String[] args) throws IOException {
        Departamento dep;
        int depmodif = 10;

        // Leer fichero
        File fichero = new File("Departamentos.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        // Escrbibir fichero
        File fichero2 = new File("DepartamentosMod.dat");
        FileOutputStream fileout = new FileOutputStream(fichero2);
        ObjectOutput dataOS = new ObjectOutputStream(fileout);

        while (true) { // lectura del fichero para encontrar el departamento a modificar
            try {
                dep = (Departamento) dataIS.readObject();
                if (dep.getDep() == depmodif) {
                    dep.setNombre("NUEVO DEPARTAMENTO");
                    dep.setLoc("NUEVA LOCALIDAD");

                    dep = new Departamento(dep.getNombre(), dep.getDep(), dep.getLoc());
                }
                dataOS.writeObject(dep);
            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        dataIS.close();

        listaDep(new File("Departamentos.dat"));
        listaDep(new File("DepartamentosMod.dat"));
    }

    public static void listaDep(File fichero) throws IOException {
        Departamento dep;
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        System.out.println("Fichero " + fichero.getName());
        while (true) { // lectura del fichero
            try {
                dep = (Departamento) dataIS.readObject();
                System.out.println("Departamento: " + dep.getDep() + ", Nombre: " + dep.getNombre() + ", Localidad:" + dep.getLoc());

            } catch (EOFException | ClassNotFoundException e) {
                break;
            }
        }
        dataIS.close();
    }
}
