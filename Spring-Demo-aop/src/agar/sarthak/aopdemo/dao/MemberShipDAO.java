package agar.sarthak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO 
{
	public boolean addMember()
	{
		System.out.println(getClass() + ": Doing Stuff Adding a membership account");
		return true;
	}
}
