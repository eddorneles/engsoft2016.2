package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dominio.Alimento;
import dominio.Bandeja;
import dominio.Maquina;
import dominio.TipoAlimento;

public class AlimentoDAO {

	public List<Alimento> getAlimentosValidos(Maquina maquina){
		
		List<Alimento> alimentos = new ArrayList<Alimento>();
	
		Connection con = new DAO().getConnection();

		String sql = "SELECT * FROM alimento JOIN tipo_alimento ON alimento.id_tipo_alimento = tipo_alimento.id_tipo_alimento "
				+ "JOIN bandeja ON alimento.id_maquina = bandeja.id_maquina AND alimento.id_bandeja = bandeja.id_bandeja "
				+ "WHERE date_add(alimento.data_cadastro, INTERVAL tipo_alimento.validade_dias DAY) >= curdate() AND alimento.id_maquina = ? "
				+ "AND tipo_alimento.id_tipo_alimento = bandeja.id_tipo_alimento "
				+ "ORDER BY alimento.data_cadastro";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, maquina.getId());
			
			ResultSet rs = smtm.executeQuery();
			
			while(rs.next()){
				Alimento alimento = new Alimento();
				TipoAlimento tipoAlimento = new TipoAlimento();
				Bandeja bandeja = new Bandeja();
				
				tipoAlimento.setId(rs.getInt("id_tipo_alimento"));
				tipoAlimento.setNome(rs.getString("nome"));
				tipoAlimento.setPreco(rs.getDouble("preco"));
				tipoAlimento.setValidadeDias(rs.getInt("validade_dias"));
			
				bandeja.setId(rs.getInt("id_bandeja"));
				bandeja.setMaquina(maquina);
				bandeja.setNumero(rs.getInt("numero"));
				bandeja.setTipoAlimento(tipoAlimento);
				
				alimento.setTipoAlimento(tipoAlimento);
				alimento.setMaquina(maquina);
				alimento.setBandeja(bandeja);
				alimento.setDataCadastro(rs.getDate("data_cadastro"));
				alimento.setQuantidade(rs.getInt("quantidade"));
				
				alimentos.add(alimento);
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
		return alimentos;
	}
	
	public void deleteAlimento(Alimento alimento){
		
		Connection con = new DAO().getConnection();

		String sql = "DELETE FROM alimento WHERE id_maquina = ? AND id_bandeja = ?";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, alimento.getMaquina().getId());
			smtm.setInt(2, alimento.getBandeja().getId());
			
			smtm.executeUpdate();
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
	
	public void decrementoQuantidade(Alimento alimento){
		
		Connection con = new DAO().getConnection();

		String sql = "UPDATE alimento SET quantidade = ? "
				+ "WHERE id_maquina = ? AND id_bandeja = ?";
		
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setInt(1, alimento.getQuantidade() - 1 );
			smtm.setInt(2, alimento.getMaquina().getId());
			smtm.setInt(3, alimento.getBandeja().getId());
			smtm.executeUpdate();
			smtm.close();
			
		} catch ( SQLException e ) {
			e.printStackTrace();
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}//END decrementoQuantidade
	
	public void atualizaQuantidade( Alimento alimento ){
		Connection con = new DAO().getConnection(); 
		
		String sql = "UPDATE alimento SET quantidade = ? "
				+ "WHERE  id_maquina = ? AND id_bandeja = ? ";
		try{
			PreparedStatement smtm = con.prepareStatement( sql );
			int i = 1;
			smtm.setInt( i , alimento.getQuantidade() );
			smtm.setInt( i++ , alimento.getMaquina().getId() );
			smtm.setInt( i++ , alimento.getBandeja().getId() );
			smtm.executeUpdate();
			smtm.close();
			
		}catch( SQLException e ){
			e.printStackTrace();
		} finally {
			try{
				con.close();
			} catch( SQLException e ){
				e.printStackTrace();
			}
		}// END try 
	}// END atualizaQuantidade
	
}//END class
