package Ejercicios.Objetos;

import java.io.*;

class Departamento implements Serializable {
    private int num;
    private String nombre;
    private String localidad;

    public Departamento(String nombre, int dep, String loc) {
        this.nombre = nombre;
        this.num = dep;
        this.localidad = loc;
    }

    public Departamento() {
        this.nombre = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLoc() {
        return localidad;
    }

    public void setLoc(String loc) {
        this.localidad = loc;
    }

    public int getDep() {
        return num;
    }

    public void setDep(int dep) {
        this.num = dep;
    }


}