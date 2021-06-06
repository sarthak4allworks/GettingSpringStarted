package agar.sarthak.aopdemo.dao;

import org.springframework.stereotype.Component;

import agar.sarthak.aopdemo.Account;

@Component
public class AccountDAO 
{
	public void addAccount(Account theAccount, boolean vipFlag)
	{
		System.out.println(getClass() + ": doing my db work - add account");
	}
}
