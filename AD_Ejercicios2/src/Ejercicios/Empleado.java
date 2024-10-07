package Ejercicios;

public class Empleado {
    private int id;
    private String apellido;
    private String tipo;
    private int departamento;

    public Empleado(int id, String apellido, String tipo, int departamento) {
        this.id = id;
        this.apellido = apellido;
        this.tipo = tipo;
        this.departamento = departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }
}
