package agar.sarthak;

public class CricketCoach implements Coach 
{
	private FortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	public CricketCoach() 
	{
		System.out.println("Inside cricket coach no arg constructor");
	}

	public void setFortuneService(FortuneService fortuneService)
	{
		System.out.println("Inside cricket coach setter method");
		this.fortuneService = fortuneService;
	}
	
	public void setEmailAddress(String emailAddress) 
	{
		System.out.println("Inside cricket coach setter email method");
		this.emailAddress = emailAddress;
	}

	public void setTeam(String team) 
	{
		System.out.println("Inside cricket coach setter team method");
		this.team = team;
	}
	
	public String getEmailAddress() 
	{
		return emailAddress;
	}

	public String getTeam() 
	{
		return team;
	}

	@Override
	public String getDailyWorkout() 
	{
		return "Practice fast bowling 15 mins a day";
	}

	@Override
	public String getDailyFortune() 
	{
		return fortuneService.getFortune();
	}
}
