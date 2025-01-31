package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


// Sql query:- select * from employees;
//hibernate query:- select emp from Employees emp;

public class MainApp {

	public static void main(String[] args) {

//		Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
				.addAnnotatedClass(Passport.class).buildSessionFactory();

//		Create a session.
		Session session = factory.openSession();

//		Begin a transaction.
		Transaction transaction = session.beginTransaction();

//		Create a new Passport.
		Passport passport = new Passport();
		passport.setPassportNumber("K8523697");

//		Create a new Person And Associate it with the Passport.
		Person person = new Person();
		person.setName("Sagar Chauhan");
		person.setPassport(passport);

//		Save the person (this will also save the associated Passport due to CascadeType.ALL)
		session.save(person);

//		Commit the transaction.
		transaction.commit();

		System.out.println("Person And Passport Saved!!!");

	}

}
