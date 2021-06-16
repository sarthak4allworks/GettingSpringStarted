package agarwal.sarthak.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect 
{
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// Setup pointcut declarations
	@Pointcut("execution(* agarwal.sarthak.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// do same thing for service and dao
	@Pointcut("execution(* agarwal.sarthak.springdemo.Service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* agarwal.sarthak.springdemo.DAO.*.*(..))")
	private void forDAOPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDAOPackage()")
	private void forAppFlow() {}
	
	// Add @BeforeAdvice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint)
	{
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @Before: calling method: "+ theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop thru and display args
		for(Object tempArg: args)
		{
			myLogger.info("===> argument: "+ tempArg);
		}
	}
	
	// Add @AfterReturningAdvice
	@AfterReturning(
				pointcut = "forAppFlow()",
				returning = "theResult"
			)
	public void afterReturning(JoinPoint theJoinPoint, Object theResult)
	{
		// display the method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("===> in @AfterReturning: from method: "+ theMethod);
		
		// display the returned result
		myLogger.info("===> result: "+ theResult);
	}
}
