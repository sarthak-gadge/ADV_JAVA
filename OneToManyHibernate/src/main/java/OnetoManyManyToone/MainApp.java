package OnetoManyManyToone;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Employee27.class)
				                     .addAnnotatedClass(Department.class)
				                     .buildSessionFactory();
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
//		Create department.
		Department d1 = new Department();
		d1.setId(33);
		d1.setName("Computer Department");
		
		Department d2 = new Department();
		d2.setId(20);
		d2.setName("IT department");
		
//		Create Employee.
		Employee27 emp = new Employee27();
		emp.setName("krish Sharma");
		emp.setSalary(69000);
		emp.setDepartment(d1);
		
		Employee27 emp1 = new Employee27();
		emp1.setName("Ram Jadhav");
		emp1.setSalary(60000);
		emp1.setDepartment(d1);
		
	
		
		
//		Add employee to department.
		d1.setEmployees(Arrays.asList(emp,emp1));
		
		
		session.save(d1);
		
		
		transaction.commit();
		
		System.out.println("Department and Employee saved SuccessFully!!!");
		
		
	}

}
