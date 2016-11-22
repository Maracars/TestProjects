package dao.City;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.City.City;

public class DAOCity {
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
	
	
	public static boolean insertCity(City city){
		try{
			before();
			session.getTransaction().begin();
			session.persist(city);
			session.getTransaction().commit();
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
		
	}
	
	public static boolean deleteCity(City city){
		try{
			before();
			session.delete(city);
			after();
			
		}catch(Exception e){
			session.getTransaction().rollback();
			after();
			return false;
		}
		
		return true;
	}

	public static List<City> loadAllCities() {
		List<City> cityList = null;
		try {
			before();
		  @SuppressWarnings("unchecked")
			TypedQuery<City> query = session.createQuery("from City");
			cityList = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		after();

		
		return cityList;
	}



}
