package agar.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Course;
import agar.sarthak.hibernate.demo.entity.Instructor;
import agar.sarthak.hibernate.demo.entity.InstructorDetail;
import agar.sarthak.hibernate.demo.entity.Review;
import agar.sarthak.hibernate.demo.entity.Student;

public class AddCoursesForSarthakDemo 
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
			
			int tempStudentId = 1;
			Student student = session.get(Student.class, tempStudentId);
			System.out.println("\nLoaded Student: "+student);
			System.out.println("Course: "+ student.getCourses());
			
			Course tempCourse1 = new Course("C++");
			Course tempCourse2 = new Course("C#");
			Course tempCourse3 = new Course("Node JS");
			Course tempCourse4 = new Course("HTML");
			tempCourse1.addStudent(student);
			tempCourse2.addStudent(student);
			tempCourse3.addStudent(student);
			tempCourse4.addStudent(student);
			
			System.out.println("\n Saving the courses...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			session.save(tempCourse4);
			
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
