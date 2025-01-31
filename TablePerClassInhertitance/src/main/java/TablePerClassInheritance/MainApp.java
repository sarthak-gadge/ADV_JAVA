package TablePerClassInheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Vehicle.class)
		     .addAnnotatedClass(Car.class).addAnnotatedClass(Bike.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Car c1 = new Car();
		
		c1.setBrand("Maruti");
		c1.setNoofDoor(4);
		
		Bike b1 = new Bike();
		
		b1.setBrand("Suzuki");
		b1.setBiketype("Sports");
		
		session.save(b1);
		session.save(c1);
		
		session.getTransaction().commit();
		
		System.out.println("Info Stored SuccessFully!!!");
		
		session.close();
		factory.close();
		
	}

}
