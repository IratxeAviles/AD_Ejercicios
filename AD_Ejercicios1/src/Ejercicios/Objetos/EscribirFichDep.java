package Ejercicios.Objetos;

import java.io.*;

public class EscribirFichDep {
    public static void main(String[] args) throws IOException {
        Departamento dep;
        File fichero = new File("Departamentos.dat"); // declara el fichero
        FileOutputStream fileout = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout); // conecta el flujo de bytes al flujo de datos

        String[] nombres = {"INFORMÁTICA", "MÁRKETING", "CONTABILIDAD", "VENTAS",
                "COMPRAS", "PERSONAL", "RECURSOS", "ADMINISTRACIÓN", "ECONOMÍA"};
        int[] num = {10, 15, 20, 25, 30, 35, 40, 45, 50};
        String[] localidades = {"MADRID", "SEVILLA", "LEÓN", "TOLEDO", "GUADALAJARA",
                "CUENCA", "OVIEDO", "BILBAO", "VALENCIA"};

        for (int i = 0; i < num.length; i++) {
            dep = new Departamento(nombres[i], num[i], localidades[i]);
            dataOS.writeObject(dep); // escribo el departamento en el fichero
        }
        dataOS.close();

        listaDep();
    }

    public static void listaDep() throws IOException {
        Departamento dep;
        // declara el fichero
        File fichero = new File("Departamentos.dat");
        FileInputStream filein = new FileInputStream(fichero);

        // conecta el flujo de bytes al flujo de datos
        ObjectInputStream dataIS = new ObjectInputStream(filein);

        while (true) { // lectura del fichero
            try {
                dep = (Departamento) dataIS.readObject();
                System.out.println("Departamento: " + dep.getDep() + ", Nombre: " + dep.getNombre() + ", Localidad:" + dep.getLoc());

            } catch (EOFException | ClassNotFoundException e) {
                System.out.println("Final lectura");
                break;
            }
        }
        dataIS.close();
    }
}


