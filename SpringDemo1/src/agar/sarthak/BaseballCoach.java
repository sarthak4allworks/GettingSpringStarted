package agar.sarthak;

public class BaseballCoach implements Coach
{
	private FortuneService fortuneService;
	public BaseballCoach(FortuneService fortuneService) 
	{
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Spend 30 mins in batting practice";
	}
	@Override
	public String getDailyFortune() 
	{
		return fortuneService.getFortune();
	}
}
