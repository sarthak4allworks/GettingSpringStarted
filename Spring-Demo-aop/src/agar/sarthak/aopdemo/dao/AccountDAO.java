package agar.sarthak.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO 
{
	public void addAccount()
	{
		System.out.println(getClass() + ": doing my db work - add account");
	}
}
