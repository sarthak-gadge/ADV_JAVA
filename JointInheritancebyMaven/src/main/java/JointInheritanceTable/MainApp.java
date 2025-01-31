package JointInheritanceTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class MainApp {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Student1.class)
		    .addAnnotatedClass(PostGraduate.class).addAnnotatedClass(UnderGraduate.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		
		SessionFactory factory = cfg.buildSessionFactory(reg);
		
		Session session = factory.openSession();
		
		Transaction transaction = session.beginTransaction();
		
		PostGraduate pd = new PostGraduate();
		pd.setId(1);
		pd.setName("Ravi Bade");
		pd.setMaster("Doctor");
		
		UnderGraduate ud = new UnderGraduate();
		ud.setId(2);
		ud.setName("Sanket Chaudhar");
		ud.setMajor("Soldier");
		
		session.save(ud);
		session.save(pd);
		
		transaction.commit();
		
		System.out.println("Info Stored Successfully!!!");
		
		
		
	}

}
