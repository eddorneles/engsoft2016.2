package mbean;

import java.util.List;

import dao.AlimentoDAO;
import dominio.Alimento;


public class AlimentoMBean {

	private List<Alimento> alimentos = null;
	
	public List<Alimento> findAllAlimentosValidosMaquina(int idMaquina){
		
		AlimentoDAO dao = new AlimentoDAO();
		
		alimentos = dao.findAllAlimentosValidos(idMaquina);
		
		return alimentos;
	}
	
}
