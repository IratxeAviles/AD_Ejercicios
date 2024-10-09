package Ejercicios.DB4O;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;

public class Ejercicio1 {
    static String BD = "src/BBDD/EMPLEDEP.yap";

    public static void main(String[] args) {
        ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), BD);

        Departamento depart = new Departamento(null, null, null); // Leer departamento con id=10
        ObjectSet<Departamento> resultDEP = db.queryByExample(depart);

        if (resultDEP.isEmpty()) {
            System.out.println("No hay departamentos en la BD");
        }
        while (resultDEP.hasNext()) {
            Departamento e = resultDEP.next();
            System.out.println("\tDepartamento: " + e.getNombre());
        }

        Empleado emple = new Empleado(null, null, null, null); // Leer empleados con departamento=10
        ObjectSet<Empleado> resultEMP = db.queryByExample(emple);
        leer(resultEMP);

        //modificar(db);
        //eliminar(db);

        leer(resultEMP);
        db.close();
    }

    public static void agregar(ObjectContainer db) {
        Empleado emp1 = new Empleado(7360, "PEREZ", "EMPLEADO", 20);
        db.store(emp1);
    }

    public static void modificar(ObjectContainer db) {
        Departamento departamento = new Departamento(10, null, null);
        ObjectSet<Departamento> result = db.queryByExample(departamento);
        if (result.isEmpty()) {
            System.out.println("No existe " + departamento.getNombre());
        } else {
            while (result.hasNext()) {
                Departamento existe = result.next();
                existe.setId(50);
                db.store(existe);
            }
        }
    }

    public static void eliminar(ObjectContainer db) {
        Departamento departamento = new Departamento(10, null, null);
        ObjectSet<Departamento> resultDEP = db.queryByExample(departamento);
        Empleado emple = new Empleado(null, null, null, 10);
        ObjectSet<Empleado> resultEMP = db.queryByExample(emple);
        if (resultDEP.isEmpty()) {
            System.out.println("No existe " + departamento.getNombre());
        } else {
            while (resultEMP.hasNext()){
                Empleado existe = resultEMP.next();
                existe.setDepartamento(null);
            }
            while (resultDEP.hasNext()) {
                Departamento depar = resultDEP.next();
                db.delete(depar);
                //consultar los datos
                System.out.println("Eliminado departamento " + departamento.getId());
            }
        }
    }

    public static void leer(ObjectSet<Empleado> result) {
        if (result.isEmpty()) {
            System.out.println("No hay empleados en la BD");
        }
        while (result.hasNext()) {
            Empleado emp = result.next();
            System.out.print("\tId: " + emp.getId());
            System.out.print("\tApellido: " + emp.getApellido());
            System.out.print("\tTipo: " + emp.getTipo());
            System.out.println("\tDepartamento: " + emp.getDepartamento());
        }
    }
}
