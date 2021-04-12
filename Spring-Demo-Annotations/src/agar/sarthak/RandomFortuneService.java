package agar.sarthak;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService
{
	// create array of string
	private String[] data = {
			"Beware of the wolf in sheep's clothing",
			"Deligence is mother of good luck",
			"The journey is the reward"
	};
	
	// random number generator
	private Random myRandom = new Random();
	
	@Override
	public String getFortune() 
	{
		// pick random string from the array
		int index = myRandom.nextInt(data.length);
		return data[index];
	}
}
