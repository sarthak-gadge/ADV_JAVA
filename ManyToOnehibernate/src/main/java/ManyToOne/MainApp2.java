package ManyToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Employee28.class)
				                     .addAnnotatedClass(Department28.class)
				                     .buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		Create a Department.
		Department28 depart = new Department28();
		depart.setId(100);
		depart.setName("Production");
		
//		Save a department to get a persistant ID.
		session.save(depart);
		
//		Create employee associated with the department.
//		Many to One Association.
		Employee28 emp1 = new Employee28();
		emp1.setName("Sumit Patil");
		emp1.setSalary(95000);
		emp1.setDepartment(depart);
		
		Employee28 emp2 = new Employee28();
		emp2.setName("Akash Gore");
		emp2.setSalary(15000);
		emp2.setDepartment(depart);
		
//		Save employees
		session.save(emp1);
		session.save(emp2);
		
		transaction.commit();
		
		System.out.println("info stored successfully!!!");
				                    
	}

}
