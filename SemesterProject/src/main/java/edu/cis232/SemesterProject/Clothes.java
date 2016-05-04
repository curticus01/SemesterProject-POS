package edu.cis232.SemesterProject;

public class Clothes implements Item{
	String name;
	String prodNum;
	double price;
	
	public Clothes(String name, String prodNum, double price){
		this.name = name;
		this.prodNum = prodNum;
		this.price = price;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	@Override
	public String getProdNum() {
		// TODO Auto-generated method stub
		return prodNum;
	}

}