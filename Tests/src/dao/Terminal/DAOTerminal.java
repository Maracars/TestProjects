package dao.Terminal;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Terminal.Terminal;

public class DAOTerminal {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	private static void before(){
		
		sessionFactory  = new Configuration().configure().buildSessionFactory();
		session= sessionFactory.openSession();
		
	}
	
	private static void after(){
		
		session.close();
		sessionFactory.close();
		
	}
	
	
	public static boolean insertTerminal(Terminal terminal){
		try{
			before();
			session.getTransaction().begin();
			session.save(terminal);
			session.getTransaction().commit();
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
		
	}
	
	public static boolean deleteTerminal(Terminal terminal){
		try{
			before();
			session.delete(terminal);
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
	}

	public static ArrayList<Terminal> loadAllGatesFromTerminal(int airportId) {
		// TODO Auto-generated method stub
		return null;
	}

}
