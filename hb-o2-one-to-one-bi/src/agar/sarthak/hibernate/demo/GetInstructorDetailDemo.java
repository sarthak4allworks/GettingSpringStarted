package agar.sarthak.hibernate.demo;

import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GetInstructorDetailDemo 
{
	public static void main(String[] args) 
	{
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try
		{			
			//start a transaction
			session.beginTransaction();
			
			// get the instruction details object
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instruction detail
			System.out.println("InstructorDetail: "+ tempInstructorDetail);
			
			//print the associated instructor
			System.out.println("Associated Instructor: "+ tempInstructorDetail.getInstructor());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done..");
		}
		catch(Exception exe)
		{
			exe.printStackTrace();
		}
		finally
		{
			// handle the connection leak issue
			session.close();
			factory.close();
		}
	}
}
