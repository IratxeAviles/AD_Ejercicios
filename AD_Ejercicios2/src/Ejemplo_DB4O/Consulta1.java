package Ejemplo_DB4O;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

import static Ejemplo_DB4O.CrearBBDD.BDPer;

public class Consulta1 {
    static String BDPer = "DBPersonas.yap";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
        busquedas(db);
        modificar(db);
        busquedas(db);
        eliminar(db);
        busquedas(db);

        db.close();
    }


    public static void busquedas(ObjectContainer db) {
        //devuelve todos los objetos persona de la bd
        Persona per = new Persona(null, null);
        ObjectSet<Persona> result = db.queryByExample(per);
        leer(result);

        //búsqueda de objetos Ejemplo_DB4O.Persona con nombre Juan
        /*
        per = new Persona("Ana", null);
        result = db.queryByExample(per);
        leer(result);
         */

        //búsqueda de objetos Ejemplo_DB4O.Persona con ciudad Vitoria
        /*
        per = new Persona("Vitoria", null);
        result = db.queryByExample(per);
        leer(result);
        */
    }

    public static void modificar(ObjectContainer db) {
        Persona per = new Persona("Luis", null);
        ObjectSet<Persona> result = db.queryByExample(per);
        if (result.isEmpty()) {
            System.out.println("No existe JUAN");
        } else {
            while (result.hasNext()) {
                Persona existe = result.next();
                existe.setLocalidad("Vitoria");
                db.store(existe);
            }
        }
    }

    public static void eliminar(ObjectContainer db) {
        Persona per = new Persona("Juan", null);
        ObjectSet<Persona> result =
                db.queryByExample(per);
        if (result.isEmpty()) {
            System.out.println("No existe JUAN");
        } else {
            while (result.hasNext()) {
                Persona p = result.next();
                db.delete(p);
                //consultar los datos
                System.out.println("Eliminado..");
            }
        }
    }

    public static void leer(ObjectSet<Persona> result) {
        if (result.isEmpty()) {
            System.out.println("No hay personas en la BD");
        }
        while (result.hasNext()) {
            Persona p = result.next();
            System.out.println("\tNombre: " + p.getNombre());
            System.out.println("\tCiudad:" + p.getLocalidad());
        }
    }
}