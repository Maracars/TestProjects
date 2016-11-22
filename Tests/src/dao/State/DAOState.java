package dao.State;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.State.State;

public class DAOState {
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
	
	
	public static boolean insertState(State state){
		try{
			before();
			session.getTransaction().begin();
			session.save(state);
			session.getTransaction().commit();
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
		
	}
	
	public static boolean deleteState(State state){
		try{
			before();
			session.delete(state);
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
	}
	public static List<State> loadAllStates() {
		List<State> stateList = null;
		try {
			before();
		  @SuppressWarnings("unchecked")
			TypedQuery<State> query = session.createQuery("from State");
			stateList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		after();

		
		return stateList;
	}



}
