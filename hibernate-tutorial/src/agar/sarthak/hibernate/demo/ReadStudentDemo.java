package agar.sarthak.hibernate.demo;

import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ReadStudentDemo 
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
			// create the student object
			System.out.println("Creating new Student object..");
			Student student = new Student("Sarthak", "Agarwal", "agarwalsarthak21@gmail.com");
			
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the student..");
			System.out.println(student);
			session.save(student);
			
			// commit transaction
			session.getTransaction().commit();
			
			// find out the student's id: primary key
			System.out.println("Saved student. generated id: "+ student.getId());
			
			// now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// retrieved student based on id: primary key
			System.out.println("\nGetting student with id: "+ student.getId());
			Student myStudent = session.get(Student.class, student.getId());
			System.out.println("Get Complete: "+myStudent);
			
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
