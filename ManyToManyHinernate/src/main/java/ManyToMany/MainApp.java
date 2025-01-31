package ManyToMany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;

public class MainApp {
    public static void main(String[] args) {

        // Set up session factory and session
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student10.class)
                .addAnnotatedClass(Course10.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        Transaction transaction = session.beginTransaction();

        // Create courses
        Course10 c1 = new Course10();
        c1.setName("JAVA");

        Course10 c2 = new Course10();
        c2.setName("Python");

        // Create student
        Student10 s1 = new Student10();
        s1.setName("Rajiv");

        // Add courses to student (many-to-many)
        s1.getCourses().add(c1);
        s1.getCourses().add(c2);

        // Add student to courses (many-to-many)
        c1.getStudents().add(s1);
        c2.getStudents().add(s1);

        // Save student (this will also save courses due to cascade)
        session.save(s1);

        // Commit transaction
        transaction.commit();

        System.out.println("Info Stored Successfully!!!");

        // Close session
        session.close();
        factory.close();
    }
}
