package agar.sarthak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLiftCycleDemoApp 
{
	public static void main(String[] args)
	{		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanLifeCycleApplicationContext.xml");
		Coach theCoach = applicationContext.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		applicationContext.close();
	}
}
