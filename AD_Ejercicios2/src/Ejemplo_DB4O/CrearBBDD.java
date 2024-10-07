package Ejemplo_DB4O;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class CrearBBDD {
    final static String BDPer = "DBPersonas.yap";

    public static void main(String[] args) {
//Abrir la BD
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BDPer);
// Creamos Personas
        Persona p1 = new Persona("Juan", "Guadalajara");
        Persona p2 = new Persona("Ana", "Madrid");
        Persona p3 = new Persona("Luis", "Vitoria");
        Persona p4 = new Persona("Pedro", "Asturias");
//Almacenar objetos Ejemplo_DB4O.Persona en la base de datos
        db.store(p1);
        db.store(p2);
        db.store(p3);
        db.store(p4);
        db.close(); //cerrar base de datos
    }//fin de main
}