package agar.sarthak;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp 
{
	public static void main(String[] args)
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		System.out.println("\nPointing to the same object: "+ (theCoach==alphaCoach));
		System.out.println("\nMemory location for theCoach: "+ theCoach);
		System.out.println("\nMemory location for alphaCoach: "+ alphaCoach);
		context.close();
	}

}
