package edu.cis232.SemesterProject;

//Author: Curtis Coughenour
//Description:
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Inventory 
{
  //declare variables
public static DecimalFormat currency = new DecimalFormat("$#,##0.00");

  //REQ#10
  public ArrayList<Item> food = new ArrayList<>();
  public ArrayList<Item> inventory = new ArrayList<>();
  public ArrayList<Item> clothes = new ArrayList<>();
  private double price;
  private boolean notFound;
  public POS pos = new POS(this);
  final String DB_URL = "jdbc:hsqldb:file:ItemDB/Item";
  
  public void switchInventory(String s){
	  if(s.equalsIgnoreCase("food")){
		  loadFood();
		  inventory = food;
	  }else if(s.equalsIgnoreCase("clothes")){
		  loadClothes();
		  inventory = clothes;
	  }
  }
//REQ#8
  public void loadFood()
  {

		try {
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// Create a Statement object.
			Statement stmt = conn.createStatement();

			// Create a string with a SELECT statement.
			String sqlStatement = "SELECT * FROM Item"
					+ " WHERE Type LIKE 'Food'";

			// Send the statement to the DBMS.
			ResultSet result = stmt.executeQuery(sqlStatement);

			
			// Display the contents of the result set.
			while (result.next()) {
			//REQ#10
		      food.add(new Food(result.getString("Description").trim(),result.getString("ProdNum"),result.getDouble("Price"), result.getBoolean("Par")));
			}

			// Close the connection.
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}     
  }
  public void loadClothes()
  {

		try {
			// Create a connection to the database.
			Connection conn = DriverManager.getConnection(DB_URL);

			// Create a Statement object.
			Statement stmt = conn.createStatement();

			// Create a string with a SELECT statement.
			String sqlStatement = "SELECT ProdNum, Description, Price FROM Item"
					+ " WHERE Type LIKE 'Clothes'";

			// Send the statement to the DBMS.
			ResultSet result = stmt.executeQuery(sqlStatement);

			
			// Display the contents of the result set.
			while (result.next()) {
			//REQ#10
		      clothes.add(new Clothes(result.getString("Description").trim(),result.getString("ProdNum"),result.getDouble("Price")));
			}

			// Close the connection.
			conn.close();

		} catch (Exception ex) {
			System.out.println("ERROR: " + ex.getMessage());
		}      
  }
  
  //prints all of inventory including items' values(name, ProdNum, price)
  public void printInventory()
  {
      for(int i =0; i< inventory.size(); i++)
      {
          System.out.printf("%s, %s, %f%n", inventory.get(i).getName(),inventory.get(i).getProdNum(),inventory.get(i).getPrice());
      }
  }
  
  //checks user input for item in system
  public double search(String item)throws IOException
  {
      int i;
      for(i=0; i < inventory.size(); i++)
      {    	  
    	  if(inventory.get(i).getName().equalsIgnoreCase(item) ){
          
              price = inventory.get(i).getPrice();
              //System.out.println("Item: " + item);
              //System.out.println("Price: " + currency.format(price));
              notFound = true;              
              break;    
    	  }      
      }
      checkNotFound(item);
      return price;
  }
  
  //Validation loop
  //checking if item is found in the inventory list.
  //if item is not found, this removes the input from the list for the reciept
  //and sets fields to null to keep total and item count correct
  public void checkNotFound(String item)
  {
      if(notFound == true)
      {
          
          notFound = false;
      }
      else
      {
          System.out.println("Item Not Found: " + item);
          price = 0;
          pos.voidItem(item, price);
          
          notFound = false;
      }
  }
  
  

}
