package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dominio.TipoAlimento;
public class TipoAlimentoDAO{

	public List<TipoAlimento> getAllTipoAlimentos(){
		
		List<TipoAlimento> tipoAlimentos = new ArrayList<TipoAlimento>();
		
		String sql = "SELECT * FROM tipo_alimento)";
				
		Connection con = new DAO().getConnection();
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			ResultSet rs = smtm.executeQuery();
			
			while(rs.next()){
				TipoAlimento tipoAlimento = new TipoAlimento();
				
				tipoAlimento.setId(rs.getInt("id_tipo_alimento"));
				tipoAlimento.setNome(rs.getString("nome"));
				tipoAlimento.setPreco(rs.getDouble("preco"));
				tipoAlimento.setValidadeDias(rs.getInt("validade_dias"));
				tipoAlimentos.add(tipoAlimento);
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
		
		return tipoAlimentos;
	}
	
	public void setTipoAlimento(TipoAlimento tipoAlimento){
		
		Connection con = new DAO().getConnection();
		
		String sql = "INSET INTO tipo_alimento"
				+ " (id_tipo_alimento, nome, preco, validade_dias) "
				+ "VALUES( " + Integer.toString(tipoAlimento.getId()) + ", "
				+ (tipoAlimento.getNome()) + ", "
				+ Double.toString(tipoAlimento.getPreco()) + ", "
				+ Integer.toString(tipoAlimento.getValidadeDias()) + ")";
		
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
	
	public <T> void updateTipoAlimento(TipoAlimento tipoAlimento){
		
		Connection con = new DAO().getConnection();
		
		String sql = "UPDATE tipo_alimento SET nome = ?, preco = ?, validade_dias = ?"
				+ "WHERE id_tipo_alimento = ?";
	
		try {
			PreparedStatement smtm = con.prepareStatement(sql);
			smtm.setString(1, tipoAlimento.getNome());
			smtm.setDouble(2, tipoAlimento.getPreco());
			smtm.setInt(3, tipoAlimento.getValidadeDias());
			smtm.setInt(5, tipoAlimento.getId());
			
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
