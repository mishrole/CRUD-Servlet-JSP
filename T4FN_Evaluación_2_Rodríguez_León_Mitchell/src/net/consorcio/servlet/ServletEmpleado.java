package net.consorcio.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.consorcio.entidad.Empleado;
import net.consorcio.service.EmpleadoService;

/**
 * Servlet implementation class ServletEmpleado
 */
@WebServlet("/ServletEmpleado")
public class ServletEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	private EmpleadoService servicioEmpleado;
	
    public ServletEmpleado() {
        super();
        
        servicioEmpleado = new EmpleadoService();
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tipo = request.getParameter("accion");
		
		if(tipo.equals("registrar")) {
			registrar(request, response);
		} else if (tipo.equals("eliminar")) {
			eliminar(request, response);
		} else if (tipo.equals("listar")) {
			listar(request, response);
		} else if (tipo.equals("editar")) {
			actualizar(request, response);
		} else if (tipo.equals("buscar")) {
			buscarEmpleado(request, response);
		}
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Crear un objeto de tipo arreglo de objeto de la clase Empleado
		List<Empleado> lista = servicioEmpleado.listar();
		
		// Crear un atributo que almacene el valor de la lista
		request.setAttribute("empleados", lista);
		
		// Direccionar a la página listaEmpleado.jsp para que reciba el atributo "empleados"
		request.getRequestDispatcher("/listaEmpleado.jsp").forward(request, response);
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		int salida;
		salida = servicioEmpleado.eliminar(Integer.parseInt(codigo));
		
		if(salida!=-1) {
			request.setAttribute("MENSAJE", "Se eliminó correctamente");
		} else {
			request.setAttribute("MENSAJE", "Error al eliminar el registro");
		}
		
		listar(request, response);
	}

	private void registrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Variables para almacenar los valores de la cajas
		// ** Utilizar la propiedad name de cada control
		
		String nombre, apellido, dni, nhijos;
		nombre = request.getParameter("nombre");
		apellido = request.getParameter("apellido");
		dni = request.getParameter("dni");
		nhijos = request.getParameter("hijos");
		
		// Crear un objeto de la clase Empleado
		Empleado bean = new Empleado();
		
		// Setear los atributos del objeto "bean"
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setDni(Integer.parseInt(dni));
		bean.setNhijos(Integer.parseInt(nhijos));
		
		// Invocar al método registrar
		int salida = servicioEmpleado.registrar(bean);
		
		if(salida!=-1) {
			request.setAttribute("MENSAJE", "Se registró correctamente");
		} else {
			request.setAttribute("MENSAJE", "Error en el registro");
		}
		
		// Direccionar a la página empleado.jsp y enviar el atributo MENSAJE 
		request.getRequestDispatcher("/empleado.jsp").forward(request, response);
	}
	
	private void actualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Empleado bean = new Empleado();
		
		String codigo, nombre, apellido, dni, nhijos;
		
		codigo = request.getParameter("codigo");
		nombre = request.getParameter("nombre");
		apellido = request.getParameter("apellido");
		dni = request.getParameter("dni");
		nhijos = request.getParameter("hijos");
		
		bean.setCodigo(Integer.parseInt(codigo));
		bean.setNombre(nombre);
		bean.setApellido(apellido);
		bean.setDni(Integer.parseInt(dni));
		bean.setNhijos(Integer.parseInt(nhijos));
		
		int salida = servicioEmpleado.actualizar(bean);
		
		if(salida != -1) {
			request.setAttribute("MENSAJE", "Se actualizaron los datos correctamente");
		}else {
			request.setAttribute("MENSAJE", "Error al actualizar");
		}
		
		request.getRequestDispatcher("/editar.jsp").forward(request, response);
	}
	
	private void buscarEmpleado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		
		Empleado bean = servicioEmpleado.buscarEmpleado(Integer.parseInt(codigo));
		request.setAttribute("empleado", bean);
		
		request.getRequestDispatcher("/editar.jsp").forward(request, response);
	}
}
