package Ejercicios;

import Ejemplo_DB4O.Persona;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;

public class BBDD {
    final static String BD = "src/BBDD/EMPLEDEP.yap";

    public static void main(String[] args) {
        //Abrir la BD
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BD);

        // Creamos Empleados
        Empleado emp1 = new Empleado(7369, "SANCHEZ", "EMPLEADO", 20);
        Empleado emp2 = new Empleado(7499, "ARROYO", "VENDEDOR", 30);
        Empleado emp3 = new Empleado(7521, "SALA", "VENDEDOR", 30);
        Empleado emp4 = new Empleado(7566, "JIMENEZ", "DIRECTOR", 20);
        Empleado emp5 = new Empleado(7782, "CEREZO", "DIRECTOR", 10);
        Empleado emp6 = new Empleado(7839, "REY", "PRESIDENTE", 10);

        // Creamos Departamentos
        Departamento dep1 = new Departamento(10, "CONTABILIDAD", "SEVILLA");
        Departamento dep2 = new Departamento(20, "INVESTIGACION", "MADRID");
        Departamento dep3 = new Departamento(30, "VENTAS", "BARCELONA");

        //Almacenar objetos en la base de datos
        db.store(emp1);
        db.store(emp2);
        db.store(emp3);
        db.store(emp4);
        db.store(emp5);
        db.store(emp6);

        db.store(dep1);
        db.store(dep2);
        db.store(dep3);

        db.close(); //cerrar base de datos
    }
}