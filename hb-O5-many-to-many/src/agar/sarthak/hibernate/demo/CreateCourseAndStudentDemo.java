package agar.sarthak.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import agar.sarthak.hibernate.demo.entity.Course;
import agar.sarthak.hibernate.demo.entity.Instructor;
import agar.sarthak.hibernate.demo.entity.InstructorDetail;
import agar.sarthak.hibernate.demo.entity.Review;
import agar.sarthak.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo 
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
			
			// create a course
			Course tempCourse = new Course("Java");
			
			// save the course ... and leverage the cascade all
			System.out.println("\nSaving the courses");
			System.out.println("Saved course: "+tempCourse);
			session.save(tempCourse);
			
			// create the student
			Student tempStudent1 = new Student("Sarthak", "Agarwal", "agarwalsarthak21@gmail.com");
			Student tempStudent2 = new Student("Shadan", "Agarwal", "agarwalshadan21@gmail.com");
			
			// add students to the course
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			
			//save the students
			System.out.println("\nSaving Students");
			session.save(tempStudent1);
			session.save(tempStudent2);
			System.out.println("Saved Students: "+ tempCourse.getStudents());
			
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
