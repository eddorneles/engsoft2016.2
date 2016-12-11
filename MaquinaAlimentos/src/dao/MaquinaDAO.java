package dao;

import java.util.List;

import dominio.Maquina;


public class MaquinaDAO extends DAO{

	
	@SuppressWarnings("unchecked")
	public List<Maquina> findAllMaquinasWithProduction(){
		
		try{
			return getSession().createCriteria(Maquina.class, "maquina")
					.list();
		}
		finally{
			closeSession();
		}
	}
}
