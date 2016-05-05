package edu.cis232.SemesterProject;
//REQ#3
public class Item implements Nameable{
	String name;
	String prodNum;
	double price;
	
	public Item(String name, String prodNum, double price){
		this.name = name;
		this.prodNum = prodNum;
		this.price = price;
	}
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	
	public double getPrice() {
		// TODO Auto-generated method stub
		return price;
	}

	
	public String getProdNum() {
		// TODO Auto-generated method stub
		return prodNum;
	}
	
}
