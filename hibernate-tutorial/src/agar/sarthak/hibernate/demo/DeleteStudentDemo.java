package agar.sarthak.hibernate.demo;

import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DeleteStudentDemo 
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
			
			// delete the student
//			System.out.println("Deleteing the student: "+ myStudent);
//			session.delete(myStudent);
			
			// delete student id 2
			System.out.println("Deleting studnt id = 2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
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
