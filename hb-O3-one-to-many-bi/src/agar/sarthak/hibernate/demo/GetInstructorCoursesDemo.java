package agar.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Course;
import agar.sarthak.hibernate.demo.entity.Instructor;
import agar.sarthak.hibernate.demo.entity.InstructorDetail;

public class GetInstructorCoursesDemo 
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
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println(tempInstructor);
			
			// print the instruction detail
			System.out.println("Courses: " + tempInstructor.getCourses());
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done..");
		}
		finally
		{
			session.close();
			factory.close();
		}
	}
}
