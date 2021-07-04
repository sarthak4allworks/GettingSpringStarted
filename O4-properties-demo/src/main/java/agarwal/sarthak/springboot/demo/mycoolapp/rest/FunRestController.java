package agarwal.sarthak.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController 
{
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello World! Time on server is "+ LocalDateTime.now();
	}
	
	@GetMapping("/teaminfo")
	public String getTeamInfo()
	{
		return "Coach: "+coachName+" Team: "+teamName;
	}
	
	// expose a new endpoint for workout
	@GetMapping("/workout")
	public String getDailyWorkout()
	{
		return "run 5k everyday";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune()
	{
		return "Lucky Day";
	}
}
