package agar.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Course;
import agar.sarthak.hibernate.demo.entity.Instructor;
import agar.sarthak.hibernate.demo.entity.InstructorDetail;
import agar.sarthak.hibernate.demo.entity.Review;
import agar.sarthak.hibernate.demo.entity.Student;

public class GetCoursesForSarthakDemo 
{
	public static void main(String[] args) 
	{
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		// create a session
		Session session = factory.getCurrentSession();
		try
		{			
			//start a transaction
			session.beginTransaction();
			
			int tempStudentId = 2;
			Student student = session.get(Student.class, tempStudentId);
			System.out.println("\nLoaded Student: "+student);
			System.out.println("Courses: "+ student.getCourses());
			for(Course course: student.getCourses())
			{
				System.out.println(course);
			}
			
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
