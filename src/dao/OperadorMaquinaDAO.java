package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Maquina;
import dominio.Operador;
import dominio.OperadorMaquina;

public class OperadorMaquinaDAO {
	
	public List<OperadorMaquina> getAllOperadorWithMaquina(){
		
		List<OperadorMaquina> op_maquinas = new ArrayList<OperadorMaquina>();
		
		String sql ="SELECT * FROM operador_maquina JOIN operador ON operador_maquina.id_operador = operador.id_operador "
				+ "JOIN maquina ON operador_maquina.id_maquina = maquina.id_maquina ";
				
		Connection con = new DAO().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			ResultSet rs = smtm.executeQuery();
			
			while(rs.next()){
				Operador operador = new Operador();
				Maquina maquina = new Maquina();
				OperadorMaquina op_maq = new OperadorMaquina();
				
				maquina.setId(rs.getInt("id_maquina"));
				maquina.setUmReal(rs.getInt("um_real"));
				maquina.setCinCent(rs.getInt("cinquenta_centavo"));
				maquina.setCincoReal(rs.getInt("cinco_real"));
				maquina.setDezReal(rs.getInt("dez_real"));
				maquina.setDoisReal(rs.getInt("dois_real"));
				
				operador.setId(rs.getInt("id_operador"));
				operador.setNome(rs.getString("nome"));
				operador.setLogin(rs.getString("login"));
				operador.setSenha(rs.getString("senha"));
				
				op_maq.setOperador(operador);
				op_maq.setMaquina(maquina);
				
				op_maquinas.add(op_maq);
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
		
		return op_maquinas;
	}
	
	
public List<Maquina> getAllMaquinaOperador(Operador operador){
		
		List<Maquina> maquinas = new ArrayList<Maquina>();
		
		String sql ="SELECT * FROM operador_maquina JOIN operador ON operador_maquina.id_operador = operador.id_operador "
				+ "JOIN maquina ON operador_maquina.id_maquina = maquina.id_maquina "
				+ "WHERE operador_maquina.id_operador = ?";
				
		Connection con = new DAO().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, operador.getId());
			ResultSet rs = smtm.executeQuery();
			
			while(rs.next()){
				Maquina maquina = new Maquina();
				
				maquina.setId(rs.getInt("id_maquina"));
				maquina.setUmReal(rs.getInt("um_real"));
				maquina.setCinCent(rs.getInt("cinquenta_centavo"));
				maquina.setCincoReal(rs.getInt("cinco_real"));
				maquina.setDezReal(rs.getInt("dez_real"));
				maquina.setDoisReal(rs.getInt("dois_real"));
				maquina.setDinheiroVendas(rs.getDouble("dinheiro_vendas"));

				maquinas.add(maquina);
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
		
		return maquinas;
	}
	
	
	public void setOperadorMaquina(Operador operador,Maquina maquina){
		
		Connection con = new DAO().getConnection();
		
		String sql = "INSERT INTO operador_maquina"
				+ " (id_operador,id_maquina) "
				+ "VALUES( " + Integer.toString(operador.getId()) + ", "
				+ Integer.toString(maquina.getId()) + ")";
		
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
	
	public void deleteOperadorMaquina(Operador operador, Maquina maquina){
		
		Connection con = new DAO().getConnection();

		String sql = "DELETE FROM operador_maquina WHERE id_operador = ? and id_maquina = ?";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, operador.getId());
			smtm.setInt(2, maquina.getId());
			
			smtm.executeQuery();
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
	
	}
	
	public <T> void updateOperadorMaquina(OperadorMaquina op_maq){
		
		Connection con = new DAO().getConnection();
		
		String sql = "UPDATE operador_maquina SET id_operador = ?"
				+ "WHERE id_maquina = ?";
	
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, op_maq.getOperador().getId());
			smtm.setInt(2, op_maq.getMaquina().getId());
			
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
