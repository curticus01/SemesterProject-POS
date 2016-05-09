package edu.cis232.SemesterProject;

public class AllItems {
	double quantity;
	String item;
	
	public AllItems(String i, double q){
		item = i;
		quantity = q;
	}
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

}
