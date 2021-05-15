package agar.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Student;

public class PrimaryKeyDemo
{
	public static void main(String[] args)
	{
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try 
		{
			// create 3 student objects
			System.out.println("Creating 3 Student objects..");
			Student student1 = new Student("Swati", "Agarwal", "agarwalSwati21@gmail.com");
			Student student2 = new Student("Sushmita", "Agarwal", "agarwalSushmita21@gmail.com");
			Student student3 = new Student("Shadan", "Agarwal", "agarwalShadan21@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students..");
			session.save(student1);
			session.save(student2);
			session.save(student3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done..");
		} 
		finally
		{
			factory.close();
		}
	}
}
