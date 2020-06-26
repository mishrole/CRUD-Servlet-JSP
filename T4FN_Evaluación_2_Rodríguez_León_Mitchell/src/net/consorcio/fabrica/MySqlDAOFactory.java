package net.consorcio.fabrica;

import net.consorcio.dao.MySqlEmpleadoDAO;
import net.consorcio.interfaces.EmpleadoDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public EmpleadoDAO getEmpleadoDAO() {
		// TODO Auto-generated method stub
		return new MySqlEmpleadoDAO();
	}

}
