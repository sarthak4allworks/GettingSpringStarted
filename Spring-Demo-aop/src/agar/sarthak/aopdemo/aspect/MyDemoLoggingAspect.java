package agar.sarthak.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect 
{
	// this is where we add all of our related advices for logging
	
	// let's start with @Before advice
	
	// below are the pointcut expressions
	
//	@Before("execution(public void agar.sarthak.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void add*())")
	@Before("execution(* add*())")
	public void beforeAddAccountAdvice()
	{
		System.out.println("\n====>>>> Executing @Before Advice on method()");
	}
}
