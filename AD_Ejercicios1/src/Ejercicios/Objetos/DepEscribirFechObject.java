package Ejercicios.Objetos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DepEscribirFechObject {
    public static void main(String[] args) throws IOException {
        Departamento dep;
        // declara el fichero
        File fichero = new File("Departamentos.dat");
        FileOutputStream fileout = new FileOutputStream(fichero);
        // conecta el flujo de bytes al flujo de datos
        ObjectOutputStream dataOS = new ObjectOutputStream(fileout);

        String nombres[] = {"INFORMÁTICA", "MÁRKETING", "CONTABILIDAD", "VENTAS",
                "COMPRAS", "PERSONAL", "RECURSOS", "ADMINISTRACIÓN", "ECONOMÍA"};
        int num[] = {10, 15, 20, 25, 30, 35, 40, 45, 50};
        String loc[] = {"MADRID", "SEVILLA", "LEÓN", "TOLEDO", "GUADALAJARA",
                "CUENCA", "OVIEDO", "BILBAO", "VALENCIA"};

        for (int i = 0; i < num.length; i++) { // recorro los arrays
            dep = new Departamento(nombres[i], num[i], loc[i]);
            dataOS.writeObject(dep); // escribo el departamento en el fichero
        }
        dataOS.close(); // cerrar stream de salida
    }
}
