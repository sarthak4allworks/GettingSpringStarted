package agar.sarthak.hibernate.demo;

import org.hibernate.cfg.Configuration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CreateDemo 
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
			// create the objects
//			Instructor tempInstructor = new Instructor("Sarthak", "Agarwal", "agarwalsarthak21@gmail.com");
//			InstructorDetail tempInstructorDetail = new InstructorDetail("dummy@youtube.com", "Java");
			Instructor tempInstructor = new Instructor("Shadan", "Agarwal", "agarwalshadan21@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("dummy@youtube.com/youtube", "C++");
			tempInstructor.setInstructionDetail(tempInstructorDetail);
			// associates the objects
			
			//start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// This will also save the instruction details
			// because of CascadeType.All
			System.out.println("Saving instructor: "+ tempInstructor);
			session.save(tempInstructor);
			
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
