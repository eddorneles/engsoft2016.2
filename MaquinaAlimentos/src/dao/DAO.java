package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import dao.conf.ConfiguracaoHibernate;

public class DAO {

	private static final SessionFactory sessionFactory =
			new Configuration().configure(ConfiguracaoHibernate.class.getResource("hibernate.cfg.xml")).buildSessionFactory();
	

	protected  Session getSession(){
		
		Session session = sessionFactory.openSession();
		
		return session;
	}
	
	protected void closeSession(){
		sessionFactory.close();
	}
}