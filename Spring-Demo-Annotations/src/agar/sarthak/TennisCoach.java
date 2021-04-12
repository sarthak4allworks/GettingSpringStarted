package agar.sarthak;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
@Scope("singleton")
public class TennisCoach implements Coach 
{
	@Autowired
//	@Qualifier("happyFortuneService")
	@Qualifier("randomFortuneService")
	FortuneService fotuneService;
	
	@Value("${foo.email}")
	private String emailAddress;
	@Value("${foo.team}")
	private String team;
	
//	@Autowired
//	public TennisCoach(FortuneService fotuneService)
//	{
//		this.fotuneService = fotuneService;
//	}
	public TennisCoach()
	{
		System.out.println("TennisCoach: Inside default constructor");
	}
	
	// define my init method
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println(">> TennisCoach: Inside doMyStartupStuff() method");
	}
	
	// define my destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println(">> TennisCoach: Inside doMyCleanupStuff() method");
	}
	
//	@Autowired
//	public void setFotuneService(FortuneService fotuneService) 
//	{
//		System.out.println("TennisCoach: Inside set Fortune Service");
//		this.fotuneService = fotuneService;
//	}

	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volly";
	}

	@Override
	public String getDailyFortune()
	{
		return fotuneService.getFortune();
	}

	public String getEmailAddress() 
	{
		return emailAddress;
	}

	public String getTeam()
	{
		return team;
	}
	
}
