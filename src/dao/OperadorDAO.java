package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Operador;
public class OperadorDAO{

	public List<Operador> getAllOperadores(){
		
		List<Operador> operadores = new ArrayList<Operador>();
		
		String sql = "SELECT * FROM operador";
				
		Connection con = new DAO().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			ResultSet rs = smtm.executeQuery();
			
			while(rs.next()){
				Operador operador = new Operador();
				
				operador.setId(rs.getInt("id_operador"));
				operador.setNome(rs.getString("nome"));
				operador.setLogin(rs.getString("login"));
				operador.setSenha(rs.getString("senha"));
				operadores.add(operador);
			}
			smtm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return operadores;
	}
	
	
public Operador loginOperador(String login, String senha){
		
		Operador operador = new Operador();
		
		String sql = "SELECT * FROM operador "
				+ "WHERE login = ? "
				+ "AND senha = ?";
				
		Connection con = new DAO().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setString(1, login);
			smtm.setString(2, senha);
			ResultSet rs = smtm.executeQuery();
			
			if(!rs.next()){
				operador = null;
			}
			else{
				operador.setId(rs.getInt("id_operador"));
				operador.setNome(rs.getString("nome"));
				operador.setLogin(rs.getString("login"));
				operador.setSenha(rs.getString("senha"));
			}
			
			smtm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return operador;
	}
	
	public void setOperador(Operador operador){
		
		Connection con = new DAO().getConnection();
		
		String sql = "INSET INTO operador"
				+ " (id_operador, nome, login, senha) "
				+ "VALUES( " + Integer.toString(operador.getId()) + ", "
				+ (operador.getNome()) + ", "
				+ (operador.getLogin()) + ", "
				+ (operador.getSenha()) + ")";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.executeQuery();
			smtm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public <T> void updateOperador(Operador operador){
		
		Connection con = new DAO().getConnection();
		
		String sql = "UPDATE operador SET nome = ?, login = ?, senha = ?"
				+ "WHERE  id_operador = ?";
	
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setString(1, operador.getNome());
			smtm.setString(2, operador.getLogin());
			smtm.setString(3, operador.getSenha());
			smtm.setInt(4, operador.getId());
			
			smtm.execute();
			smtm.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
