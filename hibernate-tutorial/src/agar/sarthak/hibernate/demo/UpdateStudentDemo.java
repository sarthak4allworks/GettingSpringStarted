package agar.sarthak.hibernate.demo;

import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UpdateStudentDemo 
{
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
			int studentId = 3;
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieved student based on id: primary key
			System.out.println("\nGetting student with id: "+ studentId);
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Get Complete: "+myStudent);
			
			System.out.println("Updating student...");
			myStudent.setFirstName("Boby");
			
			// commit the transaction
			session.getTransaction().commit();
			
			// New Code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update email for all students");
			session.createQuery("Update Student set email='sarthak.1413088@kiet.edu'")
				.executeUpdate();
			
			// commit the transaction
			session.getTransaction().commit();		
			System.out.println("Done..");
		}
		finally
		{
			factory.close();
		}
	}
}
