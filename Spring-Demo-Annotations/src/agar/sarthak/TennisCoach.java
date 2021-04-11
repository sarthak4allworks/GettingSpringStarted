package agar.sarthak;

import org.springframework.stereotype.Component;

//@Component("thatSillyCoach")
@Component
public class TennisCoach implements Coach 
{
	@Override
	public String getDailyWorkout()
	{
		return "Practice your backhand volly";
	}

}
