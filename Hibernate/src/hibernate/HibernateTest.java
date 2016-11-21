package hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

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
		Address add3 = new Address();
		add3.setCity("Arrasate");
		

		UserDetails user = new UserDetails();
		@SuppressWarnings("resource")
		Session session = null;
		SessionFactory sessionFactory = null;
		user.setUsername("Mikel");
		user.setDescription("This is a description");
		user.setJoinedDate(new Date());
		user.getListOfAddresses().add(add);
		user.getListOfAddresses().add(add2);
		user.getListOfAddresses().add(add3);
		try{
			sessionFactory  = new Configuration().configure().buildSessionFactory();
			session= sessionFactory.openSession();
			
			session.getTransaction().begin();
			session.save(user);
			session.getTransaction().commit();
		}catch(Exception e){
			session.getTransaction().rollback();
		}finally{
			session.close();
		}
		
		user = null;
		session = sessionFactory.openSession();
		//Bakarrik user_details tablako datuak jasoko dau, hau da, lehenengo kapako datuak bakarrik
		//Hemen behian bueltatzen dabena ez da user klase bat, user klasia heredatzen daben proxy bat baizik
		user = (UserDetails)session.get(UserDetails.class, 1);
		//Get list of addresses eittian ez dau objetuko datuak bueltatzen, tablan beiratuko dau ta hortik etara
		for (Address address : user.getListOfAddresses()) {
			System.out.println(address);
		}
		System.out.println("User Name retrieved is "+ user.getUsername());
		
		session.close();
		sessionFactory.close();

	}

}
