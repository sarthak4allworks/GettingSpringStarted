package agar.sarthak;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp 
{
	public static void main(String[] args) 
	{
		// Read spring java configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		SwimCoach propertyCoach = context.getBean("swimCoach", SwimCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(propertyCoach.getEmail());
		System.out.println(propertyCoach.getTeam());
		context.close();
	}
}
