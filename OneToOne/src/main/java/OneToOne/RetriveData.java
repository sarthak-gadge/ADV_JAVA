package OneToOne;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RetriveData {

	public static void main(String[] args) {

//		Create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
				.addAnnotatedClass(Passport.class).buildSessionFactory();

//		Create A Session.
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();

//		Use HQL to retrive all Person instance.
		String hql = "SELECT p FROM Person p LEFT JOIN FETCH p.passport";
		Query query = session.createQuery(hql, Person.class);
		List<Person> persons = query.getResultList();

//		Display the Result.
		for (Person person : persons) {
			System.out.println("Person Name: " + person.getName());

			if (person.getPassport() != null) {
				System.out.println("Passport Number: " + person.getPassport().getPassportNumber());
			} else {
				System.out.println("No Passport Found");
			}
			System.out.println("==================================================");
		}

//		Commit the Transaction And Close The Session.
		transaction.commit();
		session.close();
	}

}
