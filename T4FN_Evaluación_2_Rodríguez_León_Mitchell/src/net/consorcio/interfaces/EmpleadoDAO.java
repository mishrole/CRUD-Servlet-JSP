package net.consorcio.interfaces;

import java.util.List;

import net.consorcio.entidad.Empleado;

public interface EmpleadoDAO {
	public int save(Empleado bean);
	public int delete(int codigo);
	public int update(Empleado bean);
	public List<Empleado> listAll();
	public Empleado findEmpleado(int codigo);
}
