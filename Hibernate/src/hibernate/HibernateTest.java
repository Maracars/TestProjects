package hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.UserDetails.UserDetails;
import model.address.Address;
import model.vehicle.Vehicle;

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
		
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("JAJA");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Beikel2");
		
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
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
		try{
			sessionFactory  = new Configuration().configure().buildSessionFactory();
			session= sessionFactory.openSession();
			
			session.getTransaction().begin();
//			session.save(vehicle);
//			session.save(vehicle2);
//			session.save(user);
			session.persist(user);//Hau erabili ezkero ez dago azpiko objetu danak gordetzeko biharrik
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
		user = (UserDetails)session.get(UserDetails.class, 3);
		System.out.println(user);
		//Get list of addresses eittian ez dau objetuko datuak bueltatzen, tablan beiratuko dau ta hortik etara
		
		session.close();
		sessionFactory.close();

	}

}
