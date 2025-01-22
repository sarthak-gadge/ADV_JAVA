package BasicHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.registry.internal.StandardServiceRegistryImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainLoadData {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee employee = (Employee) session.load(Employee.class,1);
		
		System.out.println("==========================================================");
		
		System.out.println("ID: "+employee.getId());
		System.out.println("NAME: "+employee.getName());
		System.out.println("SALARY: "+employee.getSalary());
		
		transaction.commit();
		session.close();
		
		System.out.println("Data Loaded Successfully!!!");
	}

}
