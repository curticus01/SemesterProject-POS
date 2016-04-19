package edu.cis232.SemesterProject;

import java.util.Random;

public class Customer implements Person{
	int ShopperID;
	String Name;
	
	public Customer(){
		Name = null;
		ShopperID = generateId();
		
	}
	
	public int generateId(){
		Random r = new Random();
		return r.nextInt(10);
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public void setName(String n) {
		Name = n;
	}

	@Override
	public int getNumber() {
		return ShopperID;
	}

	@Override
	public void setNumber(int n) {
		ShopperID = n;
	}
}
