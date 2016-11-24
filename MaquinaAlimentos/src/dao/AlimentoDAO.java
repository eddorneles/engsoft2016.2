package dao;

import java.util.Collection;

import dominio.Alimento;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class AlimentoDAO extends DAO {

	public Collection<Alimento> findAllAlimentosValidos(int idMaquina){
		
		Criteria c = getSession().createCriteria(Alimento.class);
		
		c.add(Restrictions.ilike("id_maquina", idMaquina));
		 
		
		return c.list();	
	}
}
