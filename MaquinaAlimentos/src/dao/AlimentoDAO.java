package dao;

import java.util.Date;
import java.util.List;

import dominio.Alimento;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

public class AlimentoDAO extends DAO {

	@SuppressWarnings("unchecked")
	public List<Alimento> findAllAlimentosValidosMaquina(int idMaquina){
		 
		try{
			Date dataAtual = new Date();
			return getSession().createCriteria(Alimento.class, "alimento")
					.add(Restrictions.ilike("id", idMaquina))
					.createAlias("alimento.tipoAlimento", "tipoAlimento")
					.list();
		}
		finally{
			getSession().close();
		}
			
	}
}
