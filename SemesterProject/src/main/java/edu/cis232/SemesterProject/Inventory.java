package edu.cis232.SemesterProject;

//Author: Curtis Coughenour
//Description:
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Inventory 
{
  //declare variables
public static DecimalFormat currency = new DecimalFormat("$#,##0.00");
  private ArrayList<String[]> inventory = new ArrayList<String[]>();
  private String[] allItems;
  private double price;
  private int quantity=0;
  private boolean notFound;
  public static POS pos = new POS();
  
  public Inventory()
  {
      createStock();
  }
  
  //Setter for inventory
  public void createStock()
  {
      //row 0        
      inventory.add(new String[3]);
      inventory.get(0)[0] = "crackers";
      inventory.get(0)[1] = "10";
      inventory.get(0)[2] = "2.99";
      
      //row 1   
      inventory.add(new String[3]);
      inventory.get(1)[0] = "eggs";
      inventory.get(1)[1] = "10";
      inventory.get(1)[2] = "1.99";
      
      //row 2   
      inventory.add(new String[3]);
      inventory.get(2)[0] = "fish";
      inventory.get(2)[1] = "20";
      inventory.get(2)[2] = "4.49";
      
      //row 3   
      inventory.add(new String[3]);
      inventory.get(3)[0] = "milk";
      inventory.get(3)[1] = "50";
      inventory.get(3)[2] = "2.29";
      
      //row 4   
      inventory.add(new String[3]);
      inventory.get(4)[0] = "bread";
      inventory.get(4)[1] = "15";
      inventory.get(4)[2] = "1.29";
      
      allItems = new String[inventory.size()];
      
      for(int i =0; i < inventory.size(); i++)
      {
          allItems[i] = inventory.get(i)[0];
      }
      
  }
  
  public String[] getAllItems()
  {
      return allItems;
  }
  
  //prints items availible in inventory
  public void printAllItems()
  {
      for(int i =0; i< inventory.size(); i++)
      {
          System.out.println(allItems[i]);
      }
  }
  
  //prints all of inventory including items' values(name, quantity, price)
  public void printInventory()
  {
      for(int i =0; i< inventory.size(); i++)
      {
          for(int j=0; j<inventory.get(i).length; j++)
          {
              System.out.println(inventory.get(i)[j] + "\ti= " + i + "\n\tj= " + j + "\n");
              
          }
      }
  }
  
  //checks user input for item in system
  public double search(String item)throws IOException
  {
      int i,
          j;

       
      for(i=0; i < inventory.size(); i++)
      {
          for(j=0; j< inventory.get(i).length; j++)
          {
              

              if((Arrays.asList(allItems).contains(inventory.get(i)[0])) && inventory.get(i)[0].equalsIgnoreCase(item) )
              {
                  
                  price = Double.parseDouble((String) inventory.get(i)[2]);
                  System.out.println("Item: " + item);
                  System.out.println("quantity: " + subtractItem(item));
                  System.out.println("Price: " + currency.format(price));
                  pos.allItems.add(item);
                  notFound = (Arrays.asList(allItems).contains(inventory.get(i)[0]));
                  
                  
                  /* //Test Location of item
                  System.out.println("\nLocation");
                  System.out.println("i is: " +i);
                  System.out.println("j is: " +j);
                  */

                  break;                    
              }
              
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
          pos.itemNumber--;
          pos.allItems.remove(item);
          pos.voidItem(item, price);
          
          notFound = false;
      }
  }
  
  //subtracts item quantity from inventory. 
  //called when adding item to transaction
  public int subtractItem(String item)throws IOException
  {
      int section=0;
      
      //outter loop, looking in each row of arraylist
      for(int i=0; i<inventory.size(); i++)
      {
          //innerloop looking at each column(j) in the current row of arraylist(i)
          for(int j=0; j< inventory.get(i).length; j++)
          {
              //testing to see if the name of the item matches the first position (0) of the current row(i)
              if(inventory.get(i)[0].equalsIgnoreCase(item))
              {
                  quantity = (Integer.parseInt( (String) inventory.get(i)[1])-1);
                  inventory.get(i)[1]= Integer.toString(quantity);
                  quantity = (Integer.parseInt( (String) inventory.get(i)[1]));
                  section = (i);
                  if(quantity<5)
                  {
                      placeOrder(item);
                  }
                  break;
              }
          }
      }  
      
      //i0=first item
      //i1=second item
      
      //j0=item name
      //j1=quantity
      //j2=price
      

      return quantity;
  }
  //Places and order for more items if their quantity drops below thresh hold
  public void placeOrder(String item)throws IOException
  {
      PrintWriter outputFile = new PrintWriter("order.txt");
      outputFile.println("Ordered 10 " + item + "s");
      System.out.println("Ordered 10 " + item + "s");
      outputFile.close();
       //outter loop, looking in each row of arraylist
      for(int i=0; i<inventory.size(); i++)
      {
          //innerloop looking at each column(j) in the current row of arraylist(i)
          for(int j=0; j< inventory.get(i).length; j++)
          {
              //testing to see if the name of the item matches the first position (0) of the current row(i)
              if(inventory.get(i)[0].equalsIgnoreCase(item))
              {
                  quantity = (Integer.parseInt( (String) inventory.get(i)[1])+10);
                  inventory.get(i)[1]= Integer.toString(quantity);
              }
              break;
          }
          break;
          
      } 
      
  }
}
