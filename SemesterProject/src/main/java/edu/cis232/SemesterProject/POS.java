package edu.cis232.SemesterProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

//Author: Curtis Coughenour, Jack Shaw
//Description: Semester project CIS-232

import java.util.ArrayList;

public class POS 
{
  public static DecimalFormat currency = new DecimalFormat("$#,##0.00");
  private String item;
  public static ArrayList<String> allItems = new ArrayList<String>();
  private double price,
                 total,
                 subTotal;
  private final double TAX;
  public static int itemNumber;
  
  public static Inventory inventory = new Inventory();
  
  //constructors
  public POS(double t)
  {
      TAX = t;
  }
  
  public POS()
  {
      item = "";
      price=0;
      TAX=0.06;
      total=0;
      itemNumber=0;
  }
  //Setters
  public void setPrice(double p)
  {
      price = p;
  }
  
  public void setItem(String i)
  {
      item = i;
  }
  //Getters
  public double getPrice(String i) throws IOException
  {
      item = i;
      price = inventory.search(item);
      return price;
  }
  
  public String getItem()
  {
      return item;
  }
  
  //adding an item to the transaction
  public void addItem(String i, double p)throws IOException
  {
      price = p;
      item = i;
      itemNumber++;
      total += price;
      
  }
  //get rid of item that is not on inventory
  public void voidItem(String i, double p)
  {
      price =0;
      price -=p;
      item = i;
  }
  
  //computing a transaction
  public void computeSales()throws IOException
  {
      subTotal = (total + (total*TAX));
      printReceipt();
  }
  //Prints reciept to file and screen
  public void printReceipt()throws IOException
  {
      System.out.println();
      PrintWriter outputFile = new PrintWriter("reciept.txt");
      outputFile.println();
      outputFile.println("StoreMart");
      System.out.println("StoreMart");
      for(int i=0; i<allItems.size(); i++)
      {
          System.out.print("\t" +allItems.get(i) + "\n");            
          outputFile.print("\t" +allItems.get(i) + "\n");            
      }
      //print reciept to screen
      System.out.println();
      System.out.println("You had " + itemNumber + " items.");
      System.out.println("Your total is: " + currency.format(subTotal));
      System.out.println("Thank you for shopping at StoreMart\n");
      
      //print reciept to file
      outputFile.println();
      outputFile.println("You had " + itemNumber + " items.");
      outputFile.println("Your total is: " + currency.format(subTotal));
      outputFile.println("Thank you for shopping at StoreMart");
      
      
      outputFile.close();
      
  }

}
