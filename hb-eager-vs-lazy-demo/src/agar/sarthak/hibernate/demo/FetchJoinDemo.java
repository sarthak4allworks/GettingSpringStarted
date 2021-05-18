package agar.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import agar.sarthak.hibernate.demo.entity.Course;
import agar.sarthak.hibernate.demo.entity.Instructor;
import agar.sarthak.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo 
{
	public static void main(String[] args) 
	{
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try
		{			
			//start a transaction
			session.beginTransaction();
			
			// get the instruction details object
			int theId = 1;
			
			Query<Instructor> query = session.createQuery("select i from Instructor i "
															+ "JOIN fetch i.courses "
															+ "where i.id=:theInstructorId", 
															Instructor.class);
			
			query.setParameter("theInstructorId", theId);
			
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("Sarthak: Instructor: "+tempInstructor);
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			System.out.println("\nSarthak: The session is now closed!\n");
			// print the instruction detail
			System.out.println("Sarthak: Courses: " + tempInstructor.getCourses());
						
			System.out.println("Sarthak: Done..");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
}
