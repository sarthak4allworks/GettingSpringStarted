package agar.sarthak.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Student;

public class QueryStudentDemo 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try
		{
			//start a transaction
			session.beginTransaction();
			
			// query the students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			// display the students
			displayStudent(theStudents);
			
			// query students: lastname='Agarwal'
			theStudents = session.createQuery("from Student s where s.lastName='Agarwal'").getResultList();
			
			System.out.println("\nStudent who have last name of Agarwal");
			displayStudent(theStudents);
			
			// query student: lastName='Agarwal' OR firstName='Sarthak'
			theStudents = session.createQuery("from Student s where"+
												" s.lastName='Gupta' OR firstName='Sarthak'").getResultList();
			System.out.println("\nStudent who have last name of Agarwal OR firstName of Sarthak");
			displayStudent(theStudents);
			
			// query student where email Like '%gamil.com'
			theStudents = session.createQuery("from Student s where"+
												" s.email like '%gmail.com'").getResultList();
			System.out.println("\nStudent who have email Like '%gmail.com'");
			displayStudent(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done..");
		}
		finally
		{
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudents)
	{
		for(Student student: theStudents)
		{
			System.out.println(student);
		}
	}
}
