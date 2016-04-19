package edu.cis232.SemesterProject;

import java.util.Random;

public class User implements Person{
	
	int employeeID;
	String Name;
	
	public User(){
		Name = null;
		employeeID = generateId();
		
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
		return employeeID;
	}

	@Override
	public void setNumber(int n) {
		employeeID = n;
	}
}
