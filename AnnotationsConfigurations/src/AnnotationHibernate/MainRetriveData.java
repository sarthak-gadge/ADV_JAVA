package AnnotationHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class MainRetriveData {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure().addAnnotatedClass(Employee.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		Employee employee = (Employee) session.get(Employee.class,4);
		
		System.out.println("==========================================================");
		
		System.out.println("ID: "+employee.getId());
		System.out.println("Name: "+employee.getName());
		System.out.println("Salary: "+employee.getSalary());
		
		
		transaction.commit();
		session.close();
		
		System.out.println("Data retrived successfully!!!!");
		


	}

}
