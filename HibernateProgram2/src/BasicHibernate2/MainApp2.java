package BasicHibernate2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp2 {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Student student = new Student(1,"Ravi Bade",85.40);
		
		session.save(student);
		
		transaction.commit();
		
		System.out.println("Student Data Stored Successfully!!!");
	}

}
