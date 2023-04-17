package com.primer.previo.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.primer.previo.models.Paciente;
import com.primer.previo.utils.Conexion;

public class PacienteDAO {
	
	private Conexion conexion;
	
	private static final String INSERT_INTO_PACIENTE_SQL = "INSERT INTO paciente (documento, nombre, apellido, email, genero, fechanacimiento, telefono, direccion, peso, estatura) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ? ,?)";
	private static final String DELETE_PACIENTE_SQL = "INSERT FROM paciente WHERE id = ?";
	private static final String UPDATE_PACIENTE_SQL = "UPDATE paciente SET documento = ?, nombre = ?, apellido = ?, email = ?, genero = ?, fechanacimiento = ?, telefono = ?, direccion = ?, peso = ?, estatura = ? WHERE id = ?";
	private static final String SELECT_PACIENTE_BY_ID = "SELECT * FROM paciente WHERE id = ?";
	private static final String SELECT_ALL_PACIENTES = "SELECT * FROM paciente";
	
	public PacienteDAO() {
		this.conexion = conexion.getConexion();
	}
	public void insert(Paciente paciente) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_INTO_PACIENTE_SQL);
			
			preparedStatement.setString(1, paciente.getDocumento());
			preparedStatement.setString(2, paciente.getNombre());
			preparedStatement.setString(3, paciente.getApellido());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getGenero());
			preparedStatement.setDate(6, paciente.getFechaNacimiento());
			preparedStatement.setString(7, paciente.getTelefono());
			preparedStatement.setString(8, paciente.getDireccion());
			preparedStatement.setFloat(9, paciente.getPeso());
			preparedStatement.setFloat(10, paciente.getEstatura());
			
			conexion.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_PACIENTE_SQL);
			
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Paciente paciente) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_PACIENTE_SQL);
			
			preparedStatement.setString(1, paciente.getDocumento());
			preparedStatement.setString(2, paciente.getNombre());
			preparedStatement.setString(3, paciente.getApellido());
			preparedStatement.setString(4, paciente.getEmail());
			preparedStatement.setString(5, paciente.getGenero());
			preparedStatement.setDate(6, paciente.getFechaNacimiento());
			preparedStatement.setString(7, paciente.getTelefono());
			preparedStatement.setString(8, paciente.getDireccion());
			preparedStatement.setFloat(9, paciente.getPeso());
			preparedStatement.setFloat(10, paciente.getEstatura());
			preparedStatement.setInt(11, paciente.getId());
			
			conexion.execute();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Paciente> selectAll() throws SQLException {
		List <Paciente> pacientes = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_PACIENTES);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String genero = rs.getString("genero");
				Date fechaNac = rs.getDate("fechanacimiento");
				String telefono = rs.getString("telefono");
				String direcion = rs.getString("direccion");
				float peso = rs.getFloat("peso");
				float estatura = rs.getFloat("estatura");
				
				pacientes.add(new Paciente(id, documento, nombre, apellido, email, genero, fechaNac, telefono, direcion, peso, estatura));
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return pacientes;
	}
	
	public Paciente select(int id) throws SQLException {
		Paciente paciente = null;
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_PACIENTE_BY_ID);
			
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String genero = rs.getString("genero");
				Date fechaNac = rs.getDate("fechanacimiento");
				String telefono = rs.getString("telefono");
				String direcion = rs.getString("direccion");
				float peso = rs.getFloat("peso");
				float estatura = rs.getFloat("estatura");
				
				paciente = new Paciente(documento, nombre, apellido, email, genero, fechaNac, telefono, direcion, peso, estatura);
			}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return paciente;
	}
}
