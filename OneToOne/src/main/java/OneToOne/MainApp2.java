package OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MainApp2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                 .configure("hibernate.cfg.xml")
				                 .addAnnotatedClass(Person.class)
				                 .addAnnotatedClass(Passport.class)
				                 .buildSessionFactory();
	}

//   	Method to save a person with passport.
		private static void savePersonWithPassport(SessionFactory factory,String name,String passportNumber) {
		   Session session = factory.openSession();
		   Transaction transaction = session.beginTransaction();
		   
		   
		   Passport passport = new Passport();
		   passport.setPassportNumber(passportNumber);
		   
		   Person person = new Person();
		   person.setName(name);
		   person.setPassport(passport);
		   
		   session.save(person);
		   transaction.commit();
		   session.close();
		   
		   System.out.println("Person And Passport Saved!!!!");
		   
	}
		
//		Method to Update Person^s name based on their ID
		private static void updatePersonName(SessionFactory)

}
