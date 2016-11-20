package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.UserDetails.UserDetails;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		Session session = null;
		SessionFactory sessionFactory = null;
		user.setUsername("Mikel");
		user.setAddress("User's address");
		user.setDescription("Thi is a description");
		user.setJoinedDate(new Date());
		try{
			sessionFactory  = new Configuration().configure().buildSessionFactory();
			session= sessionFactory.openSession();
			
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		user = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		user = (UserDetails)session.get(UserDetails.class, 1);
		System.out.println("User Name retrieved is "+ user.getUsername());
		
		session.close();
		sessionFactory.close();

	}

}
