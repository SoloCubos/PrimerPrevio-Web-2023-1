package com.primer.previo.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.primer.previo.DAO.PacienteDAO;
import com.primer.previo.models.Paciente;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PacienteDAO pacienteDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.pacienteDAO = new PacienteDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accion = request.getServletPath();
		try {
			switch (accion) {
				case "/nuevo": 
					showNewForm(request, response);
					break;
				case "/insertar":
					insertarPaciente(request, response);
					break;
				case "/eliminar":
					eliminarPaciente(request, response);
					break;
				case "/editar":
					showEditForm(request, response);
					break;
				case "/actualizar":
					actualizarPaciente(request, response);
					break;
				case "/listar":
					listPacientes(request, response);
					break;
			}
		}catch (SQLException e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("paciente.jsp");
		//System.out.println("Mostrar nuevo paciente");
		dispatcher.forward(request, response);
	}
	
	private void insertarPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");;
		Date fechaNac = Date.valueOf(request.getParameter("fechanacimiento"));
		String telefono = request.getParameter("telefono");
		String direcion = request.getParameter("direccion");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float estatura = Float.parseFloat(request.getParameter("estatura"));
		
		Paciente p = new Paciente(documento, nombre, apellido, email, genero, fechaNac, telefono, direcion, peso, estatura);
		
		pacienteDAO.insert(p);
		
		response.sendRedirect("listar");
	}
	
	private void actualizarPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException, ServletException {
		
		int id = Integer.parseInt(request.getParameter("id"));		
		String documento = request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String email = request.getParameter("email");
		String genero = request.getParameter("genero");;
		Date fechaNac = Date.valueOf(request.getParameter("fechanacimiento"));
		String telefono = request.getParameter("telefono");
		String direcion = request.getParameter("direccion");
		float peso = Float.parseFloat(request.getParameter("peso"));
		float estatura = Float.parseFloat(request.getParameter("estatura"));
		
		Paciente paciente = new Paciente(id, documento, nombre, apellido, email, genero, fechaNac, telefono, direcion, peso, estatura);
		
		pacienteDAO.update(paciente);
		
		response.sendRedirect("listar");
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Paciente paciente = pacienteDAO.select(id);
		
		request.setAttribute("paciente", paciente);
		
		request.getRequestDispatcher("paciente.jsp").forward(request, response);	
	}

	private void eliminarPaciente(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		pacienteDAO.delete(id);
		
		response.sendRedirect("list");
		
	}
	
	private void listPacientes(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException{
		
		List<Paciente> listaPacientes = pacienteDAO.selectAll();
		request.setAttribute("listPacientes", listaPacientes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
}
