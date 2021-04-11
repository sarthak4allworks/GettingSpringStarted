package agar.sarthak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp 
{
	public static void main(String[] args) 
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CricketCoach myCoach = context.getBean("cricketCoach", CricketCoach.class);
		System.out.println(myCoach.getDailyWorkout());
		System.out.println(myCoach.getDailyFortune());
		System.out.println(myCoach.getEmailAddress());
		System.out.println(myCoach.getTeam());
		context.close();
	}
}
