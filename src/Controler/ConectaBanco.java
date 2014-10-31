package Controler;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConectaBanco {

	public static Connection getConn(){
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:3306/estoque", "root", "admin");
		} catch(Exception e){
			System.err.println(e);
		}
		return conn;
	}
}
