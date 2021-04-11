package agar.sarthak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp 
{
	public static void main(String[] args)
	{		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		Coach theCoach = applicationContext.getBean("myCoach", Coach.class);
		Coach alphaCoach = applicationContext.getBean("myCoach", Coach.class);
		System.out.println("\nPoint to the same object: " + (theCoach == alphaCoach));
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for alphaCoach: " + alphaCoach);
		applicationContext.close();
	}
}
