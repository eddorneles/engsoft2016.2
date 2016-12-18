package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.Bandeja;
import dominio.Maquina;
import dominio.TipoAlimento;

public class BandejaDAO {

public List<Bandeja> getBandejas(Maquina maquina){
		
		List<Bandeja> bandejas = new ArrayList<Bandeja>();
	
		Connection con = new DAO().getConnection();

		String sql = "SELECT * FROM bandeja "
				+ "WHERE bandeja.id_maquina = ?";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, maquina.getId());
			
			ResultSet rs = smtm.executeQuery();
			
			while(rs.next()){
				Bandeja bandeja = new Bandeja();
		
				bandeja.setMaquina(maquina);
				bandeja.setId(rs.getInt("id_bandeja"));
				
				bandejas.add(bandeja);
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
		return bandejas;
	}
	
	public void insertBandeja(Bandeja bandeja){
		Connection con = new DAO().getConnection();
		
		String sql = "INSERT INTO alimento"
				+ " (id_maquina, numero, id_tipo_alimento) "
				+ "VALUES( ?, ?, ?)";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
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
	
	public <T> void updateBandeja(Bandeja bandeja){
		
		Connection con = new DAO().getConnection();
		
		String sql = "UPDATE alimento SET id_tipo_alimento = ?, id_maquina = ?," 
				+" numero = ?"
				+ "WHERE id_bandeja = ?";
	
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(2, bandeja.getMaquina().getId());
			smtm.setInt(3, bandeja.getNumero());
			smtm.setInt(4, bandeja.getId());
			
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
	
	public void deleteBandeja(Bandeja bandeja){
		
		Connection con = new DAO().getConnection();

		String sql = "DELETE FROM bandeja WHERE id_bandeja = ?";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, bandeja.getId());
			
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
}
