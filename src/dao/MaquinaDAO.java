package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Maquina;
public class MaquinaDAO{

	public List<Maquina> getAllMaquinasWithProducts(){
		
		List<Maquina> maquinas = new ArrayList<Maquina>();
		
		String sql = "SELECT * FROM maquina "
					+ "WHERE EXISTS ( "
					+ "SELECT * FROM alimento "
					+ "WHERE alimento.id_maquina = maquina.id_maquina)";
				
		Connection con = new DAO().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
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
	
	
public Maquina getMaquina(int id){
		
		Maquina maquina = new Maquina();
		
		String sql = "SELECT * FROM maquina "
					+ "WHERE id_maquina = ?";
				
		Connection con = new DAO().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, id);
			ResultSet rs = smtm.executeQuery();
			
			if(!rs.next()){
				maquina = null;
			}
			else{
				
				maquina.setId(rs.getInt("id_maquina"));
				maquina.setUmReal(rs.getInt("um_real"));
				maquina.setCinCent(rs.getInt("cinquenta_centavo"));
				maquina.setCincoReal(rs.getInt("cinco_real"));
				maquina.setDezReal(rs.getInt("dez_real"));
				maquina.setDoisReal(rs.getInt("dois_real"));
				maquina.setDinheiroVendas(rs.getDouble("dinheiro_vendas"));
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
		
		return maquina;
	}
	
	
	public void insertMaquina(Maquina maquina){
		
		Connection con = new DAO().getConnection();
		
		String sql = "INSERT INTO maquina"
				+ " (cinquenta_centavo, um_real, dois_real, cinco_real, dez_real, dinheiro_vendas) "
				+ "VALUES( " + Integer.toString(maquina.getCinCent()) + ", "
				+ Integer.toString(maquina.getUmReal()) + ", "
				+ Integer.toString(maquina.getDoisReal()) + ", "
				+ Integer.toString(maquina.getCincoReal()) + ", "
				+ Integer.toString(maquina.getDezReal()) + ", "
				+ Double.toString(maquina.getDinheiroVendas())+ ")";
		
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
	
	public <T> void updateMaquina(Maquina maquina){
		
		Connection con = new DAO().getConnection();
		
		String sql = "UPDATE maquina SET um_real = ? " + "," 
				+ "cinquenta_centavo = ? " + ","
				+ "dois_real = ? " + ","
				+ "cinco_real = ? " + ","
				+ "dez_real = ? " + ","
				+ "dinheiro_vendas = ? "
				+ "WHERE id_maquina = ?";
	
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, maquina.getUmReal());
			smtm.setInt(2, maquina.getCinCent());
			smtm.setInt(3, maquina.getDoisReal());
			smtm.setInt(4, maquina.getCincoReal());
			smtm.setInt(5, maquina.getDezReal());
			smtm.setDouble(6, maquina.getDinheiroVendas() );
			smtm.setInt(7, maquina.getId());
			
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
