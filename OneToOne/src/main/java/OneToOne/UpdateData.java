package OneToOne;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				                     .configure("hibernate.cfg.xml")
				                     .addAnnotatedClass(Person.class)
				                     .addAnnotatedClass(Passport.class)
				                     .buildSessionFactory();
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		String newName="Sameer Bhor";
		long personId = 3;
		
//		Use HQL to Update The person^s name.
		String hql = "UPDATE Person p SET p.name = :newName WHERE p.id = :personId";
		Query query = session.createQuery(hql);
		query.setParameter("newName", newName);
		
		query.setParameter("personId", personId);
		
		int result = query.executeUpdate();
		
		transaction.commit();
		session.close();
		
		System.out.println("Updated "+result + "person(s) with ID: "+personId);
	}

}
