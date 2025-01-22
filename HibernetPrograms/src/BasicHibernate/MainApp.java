package BasicHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		  Employee employee = new Employee(1,"Ram Jadhav",25000);
		  
		  session.save(employee);
		  
		  transaction.commit();
		  
		  System.out.println("Employee saved Successfully!!!");
	}

}
