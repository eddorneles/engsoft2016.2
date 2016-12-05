package dao;

import java.util.List;

import dominio.Alimento;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class AlimentoDAO extends DAO {

	public List<Alimento> findAllAlimentosValidos(int idMaquina){
		
		Criteria c = getSession().createCriteria(Alimento.class);
		
		c.add(Restrictions.ilike("id", idMaquina));
		 
		try{
			return c.list();
		}
		finally{
			getSession().close();
		}
			
	}
}
