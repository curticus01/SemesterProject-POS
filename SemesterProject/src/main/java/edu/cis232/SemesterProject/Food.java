package edu.cis232.SemesterProject;
//REQ#4
//REQ#6
public class Food extends Item{

	private boolean parishable;
	public Food(String name, String prodNum, double price, boolean par){
		super(name, prodNum, price);
		parishable = par;
	}


}
