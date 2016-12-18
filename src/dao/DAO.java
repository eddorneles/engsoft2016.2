package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/maquina_de_alimentos";
	
	private Connection connection = null;
	
	protected Connection getConnection(){
	
		try{
			connection = DriverManager.getConnection(
					DATABASE_URL, "root", "Skuray1329");
			
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return connection;
	}
	
	protected void closeConnection(){
		
		try{
			connection.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
