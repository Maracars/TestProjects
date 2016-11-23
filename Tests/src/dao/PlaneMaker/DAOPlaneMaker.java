package dao.PlaneMaker;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.PlaneMaker.PlaneMaker;


public class DAOPlaneMaker {
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
	
	
	public static boolean insertPlaneMaker(PlaneMaker planeMaker){
		try{
			before();
			session.getTransaction().begin();
			session.save(planeMaker);
			session.getTransaction().commit();
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
		
	}
	
	public static boolean deletePlaneMaker(PlaneMaker planeMaker){
		try{
			before();
			session.delete(planeMaker);
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
	}

	public static List<PlaneMaker> loadAllPlaneMakers() {
		List<PlaneMaker> planeMakerList = null;
		try {
			before();
		  @SuppressWarnings("unchecked")
			TypedQuery<PlaneMaker> query = session.createQuery("from PlaneMaker");
			planeMakerList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		after();

		
		return planeMakerList;
	}



}
