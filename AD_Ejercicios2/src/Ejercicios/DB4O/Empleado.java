package Ejercicios.DB4O;

public class Empleado {
    private Integer id; // para poder poner "null"
    private String apellido;
    private String tipo;
    private Integer departamento;

    public Empleado(Integer id, String apellido, String tipo, Integer departamento) {
        this.id = id;
        this.apellido = apellido;
        this.tipo = tipo;
        this.departamento = departamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Integer departamento) {
        this.departamento = departamento;
    }
}
