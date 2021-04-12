package agar.sarthak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
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
