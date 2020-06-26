package net.consorcio.service;

import java.util.List;

import net.consorcio.entidad.Empleado;
import net.consorcio.fabrica.DAOFactory;
import net.consorcio.interfaces.EmpleadoDAO;

public class EmpleadoService {

	// MySql
	DAOFactory factory = DAOFactory.getDAOFactory(1);
	EmpleadoDAO daoEmpleado = factory.getEmpleadoDAO();
	
	public int registrar(Empleado bean) {
		return daoEmpleado.save(bean);
	}
	
	public int eliminar(int codigo) {
		return daoEmpleado.delete(codigo);
	}
	
	public List<Empleado> listar() {
		return daoEmpleado.listAll();
	}
	
	public int actualizar(Empleado bean) {
		return daoEmpleado.update(bean);
	}
	
	public Empleado buscarEmpleado(int codigo) {
		return daoEmpleado.findEmpleado(codigo);
	}
}
