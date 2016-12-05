package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import dominio.Maquina;


public class MaquinaDAO extends DAO{

	
	public List<Maquina> findAllMaquinasWithProduction(){
		
		Criteria c = getSession().createCriteria(Maquina.class);
		
		c.add(Restrictions.eq("id", 1));
		
		return c.list();
	}
}
