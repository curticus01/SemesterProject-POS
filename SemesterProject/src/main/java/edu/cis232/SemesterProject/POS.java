package edu.cis232.SemesterProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

//Author: Curtis Coughenour, Jack Shaw
//Description: Semester project CIS-232

import java.util.ArrayList;

public class POS {
	public static DecimalFormat currency = new DecimalFormat("$#,##0.00");
	private String item;
	public static ArrayList<AllItems> allItems = new ArrayList<AllItems>();
	protected double price, total, subTotal, quantity;
	private final double TAX;
	public static int itemNumber;

	public Inventory inventory;

	// constructors
	public POS(double t, Inventory i) {
		TAX = t;
		inventory = i;
	}

	public POS(Inventory i) {
		item = "";
		price = 0;
		TAX = 0.06;
		total = 0;
		itemNumber = 0;
		inventory = i;
	}

	public void reset() {
		item = "";
		price = 0;
		total = 0;
		subTotal = 0;
		itemNumber = 0;
		allItems.clear();
	}

	// Setters
	public void setPrice(double p) {
		price = p;
	}

	public void setItem(String i) {
		item = i;
	}

	// Getters
	public double getPrice(String i) throws IOException {
		item = i;
		price = inventory.search(item);
		return price;
	}

	public String getItem() {
		return item;
	}

	// adding an item to the transaction
	public void addItem(String i, double p, double q) throws IOException {
		allItems.add(new AllItems(i,q));
		quantity = q;
		price = p;
		item = i;
		itemNumber+=quantity;
		subTotal += (price * quantity);
		total = (subTotal + (subTotal * TAX));

	}

	// get rid of item that is not on inventory
	public void voidItem(String i, double p) {
		price = 0;
		price -= p;
		item = i;
		if(i != null)
		{
			itemNumber--;
		}
		allItems.remove(i);
	}

	// computing a transaction
	public void computeSales() throws IOException {
		printReceipt();
	}

	// Prints reciept to file and screen
	public void printReceipt() throws IOException {
		// REQ#2
		StringBuilder sb = new StringBuilder();
		// System.out.println();
		PrintWriter outputFile = new PrintWriter("reciept.txt");
		outputFile.println();
		sb.append("StoreMart\n");
		// System.out.println("StoreMart");
		for (int i = 0; i < allItems.size(); i++) {
			sb.append(String.format("%-5.0f %s%n",allItems.get(i).getQuantity(), allItems.get(i).getItem()));
		}
		// print reciept to file
		sb.append("You had " + itemNumber + " items.\n");
		sb.append("Your total is: " + currency.format(total) + "\n");
		sb.append("Thank you for shopping at StoreMart");
		outputFile.println(sb);
		System.out.println(sb);

		outputFile.close();

	}

}
