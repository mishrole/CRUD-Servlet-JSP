package net.consorcio.entidad;

public class Empleado {
	private int codigo, dni, nhijos;
	private String nombre, apellido;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public int getNhijos() {
		return nhijos;
	}
	public void setNhijos(int nhijos) {
		this.nhijos = nhijos;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
}
