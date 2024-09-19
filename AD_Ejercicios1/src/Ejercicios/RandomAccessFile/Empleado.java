package Ejercicios.RandomAccessFile;

public class Empleado {
    private int codigo;
    private String apellido;
    private int departamento;
    private Double salario;

    public Empleado(String apellido, int departamento, Double salario) {
        this.apellido = apellido;
        this.departamento = departamento;
        this.salario = salario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
