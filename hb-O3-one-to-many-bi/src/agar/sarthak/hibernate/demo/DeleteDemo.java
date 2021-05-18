package agar.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Instructor;
import agar.sarthak.hibernate.demo.entity.InstructorDetail;

public class DeleteDemo 
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
			
			// get instructor by their primary key
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found Instructor: "+ tempInstructor);
			// delete the instructors
			if(tempInstructor != null)
			{
				System.out.println("Delete: "+tempInstructor);
				// Note: will delete instructor detail because of cascade type all
				session.delete(tempInstructor);
			}
			
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
