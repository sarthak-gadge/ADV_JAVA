package SingleTableInheritance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainClass {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).
		          addAnnotatedClass(Manager.class).addAnnotatedClass(Developer.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Developer d1 = new Developer();
		d1.setId(1);
		d1.setName("Sanket Chaudhar");
		d1.setSalary(85000);
		d1.setNightAllowance(5400);
		
		Manager m1 = new Manager();
		m1.setId(2);
		m1.setName("Ravi Bade");
		m1.setSalary(75000);
		m1.setIntensive(8900);
		
		session.save(m1);
		session.save(d1);
		
		transaction.commit();
		
		System.out.println("Employee Saved Successfully!!!");
	}

}
