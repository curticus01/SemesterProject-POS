package edu.cis232.SemesterProject;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class controller {
	public boolean foodbool = false;
	public boolean clothesbool = false;
	
	
	
	ObservableList<String> foodList;
	ObservableList<String> clothesList;
	
	
	POS pos;
	Inventory inventory;
	
    @FXML
    private ListView<String> listView;

    @FXML
    private TextField qnt;

    @FXML
    private Button addToCart;

    @FXML
    private Button compute;

    @FXML
    private Button foodBttn;

    @FXML
    private Button clothesBttn;

    @FXML
    private TextField subTotaltxt;

    @FXML
    private TextField price;

    @FXML
    private TextField name;

    @FXML
    private TextField total;

    @FXML
    private Button totalBttn;

    @FXML
    private Button bttnSubTotal;

    @FXML
    void initialize(){
    	qnt.setText("1");
    	inventory= new Inventory();
    	 pos = new POS(inventory);
    }
    public void reset(){
    	listView.setItems(null);
    	foodList = null;
    	clothesList = null;
    	total.setText(null);
    	name.setText(null);
    	price.setText(null);
    	qnt.setText("1");
    	subTotaltxt.setText(null);
    	pos.reset();
    	
    }
    
    //shows all clothes items
    @FXML
    void SetClothes() {
    	clothesbool = true;	
    	foodbool = false;    	
    	showItems();
    }
    //shows all food items
    @FXML
    void setFood() {
    	foodbool = true;
    	clothesbool = false;    	
    	showItems();
    }

    @FXML
    void addItem() throws Exception{
    	pos.addItem(name.getText(), pos.getPrice(name.getText()),Double.parseDouble(qnt.getText()));
    	qnt.setText("1");
    }

    @FXML
    void compute() throws Exception{
    	pos.computeSales();
    	reset();
    }

    @FXML
    void getItem(){
    	try{
        	name.setText(listView.getSelectionModel().getSelectedItem());
        	price.setText(String.valueOf(pos.getPrice(name.getText())));	
    	}catch(NullPointerException e){
    		System.err.print(e);
    	}catch(IOException e){
    		System.err.print(e);
    	}
    }

    @FXML
    void subTotal() {
    	subTotaltxt.setText(String.format("$%,.2f", pos.subTotal));
    }
    @FXML
    void getTotal(){
    	total.setText(String.format("$%,.2f", pos.total));
    }
    
    public void showItems(){
    	listView.setItems(null);
    	//i.printAllItems();
    	inventory.printInventory();
    	if(foodbool== true){
    		inventory.switchInventory("food");
    		if(foodList==null|| foodList.isEmpty()){
    			foodList= FXCollections.observableArrayList(inventory.food.get(0).getName());
        		for(int i=1; i<inventory.food.size(); i++){
        			foodList.add(inventory.food.get(i).getName());
        		}	
    		}
    		listView.setItems(foodList);
    		
    	}else if(clothesbool == true){
    		inventory.switchInventory("clothes");
    		if(clothesList==null || clothesList.isEmpty()){
    			clothesList= FXCollections.observableArrayList(inventory.clothes.get(0).getName());
        		for(int i=1; i<inventory.clothes.size(); i++){
        			clothesList.add(inventory.clothes.get(i).getName());
        		}	
    		}
    		listView.setItems(clothesList);
    	}
    }

}
