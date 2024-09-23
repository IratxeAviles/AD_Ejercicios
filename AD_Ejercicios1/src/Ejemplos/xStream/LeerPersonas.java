package Ejemplos.xStream;

import java.io.*;
import Ejercicios.Objetos.Persona;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.*;

public class LeerPersonas {
    public static void main(String[] args) throws IOException {
        //Objeto xstream
        XStream xstream = new XStream();
        //Etiquetas de ListaPersonas y de Persona --> para leerlas como están en el XML
        xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
        xstream.alias("DatosPersona", Persona.class);
        //Quitamos la etiqueta lista, ya que no aparece en el documento XML
        xstream.addImplicitCollection(ListaPersonas.class,"lista");

        FileInputStream fichero = new FileInputStream("./src/Ficheros/Personas.xml");
        xstream.addPermission(AnyTypePermission.ANY);

        //Primera opcion: En este caso no cargaremos objetos, sino la lista entera de las personas (objetos)
        ListaPersonas listadoTodas = (ListaPersonas) xstream.fromXML(fichero);
        System.out.println("Número de personas: " + listadoTodas.getListaPersonas().size());

        //Opción 2: Iremos persona a persona usando "iterator"
        //List<Persona> listaPersonas = new ArrayList<Persona>();
        //listaPersonas = listadoTodas.getListaPersonas();
        //Iterator iterador = listaPersonas.listIterator();

        for (Persona p : listadoTodas.getListaPersonas()) {
            System.out.printf("Nombre: %s, edad: %d %n", p.getNombre(), p.getEdad());
        }
        System.out.println("Fin de listado ....");
    }
}
