package database;

import java.sql.Connection;
import java.sql.SQLException;

public class Database {

	public static Database instance;
	private Connection con;
	
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void disconnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.err.println("Can't close the connection " + e);
				e.printStackTrace();
			}
			con = null;
		}
	}
	
	public void connect() {
		
	}
}
