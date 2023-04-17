package com.primer.previo.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Conexion {
	
	private Connection con = null;

	private static final String url = "database-1.ct3gev1bipds.us-east-2.rds.amazonaws.com";
	private static final String  dbName= "testpweb";
	private static final String  driver= "org.postgresql.Driver";
	private static final String  userName= "student";
	private static final String  password= "Student22";
}
