package com.primer.previo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.empresa.prueba.utils.Conexion;

public class Conexion {
	
	private Connection con = null;
	private static Conexion db;
	private PreparedStatement preparedStatement;

	private static final String url = "database-1.ct3gev1bipds.us-east-2.rds.amazonaws.com";
	private static final String  dbName= "testpweb";
	private static final String  driver= "org.postgresql.Driver";
	private static final String  userName= "student";
	private static final String  password= "Student22";
	
	public Conexion(){
        try{
        	
        	Class.forName(driver).getDeclaredConstructor().newInstance();

            //Class.forName(driver).newInstance();
            con =(Connection) DriverManager.getConnection(url+dbName,userName,password);
            
        } catch (InstantiationException | IllegalAccessException
        		| ClassNotFoundException | SQLException e) {
            e.printStackTrace(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public static Conexion getConexion() {//patrón singleton
		if(db == null)
			db = new Conexion();
		return db;
	}
	
	public void cerrarConexion() {
		try {
			con.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet query() throws SQLException{
		ResultSet res = preparedStatement.executeQuery();
		return res;
	}
	
	public int execute() throws SQLException{
		int result = preparedStatement.executeUpdate();
		return result;
	}
	
	public Connection getCon() {
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException {
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
}
