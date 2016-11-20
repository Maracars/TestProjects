package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.UserDetails.UserDetails;
import model.address.Address;

public class HibernateTest {

	public static void main(String[] args) {
		
		Address add= new Address();
		add.setCity("Bergara");
		add.setState("Euskal herrixa");
		add.setStreet("Iokstio");
		Address add2 = new Address();
		add2.setCity("Gasteiz");
		

		UserDetails user = new UserDetails();
		Session session = null;
		SessionFactory sessionFactory = null;
		user.setUsername("Mikel");
		user.setDescription("This is a description");
		user.setJoinedDate(new Date());
		user.getListOfAddresses().add(add);
		user.getListOfAddresses().add(add2);
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
