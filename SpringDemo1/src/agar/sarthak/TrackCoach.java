package agar.sarthak;

public class TrackCoach implements Coach 
{
	private FortuneService fortuneService;
	
	public TrackCoach() 
	{
		super();
	}

	public TrackCoach(FortuneService fortuneService) 
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() 
	{
		return "Run a hard 5K";
	}

	@Override
	public String getDailyFortune() {
		return "Just do it: "+ fortuneService.getFortune();
	}
}
