package mbean;

import java.util.Collection;

import dao.AlimentoDAO;
import dominio.Alimento;


public class AlimentoMBean {

	Collection<Alimento> alimentos = null;
	
	public Collection<Alimento> findAllAlimentosValidosMaquina(int idMaquina){
		
		AlimentoDAO dao = new AlimentoDAO();
		
		alimentos = dao.findAllAlimentosValidos(idMaquina);
		
		return alimentos;
	}
	
}
