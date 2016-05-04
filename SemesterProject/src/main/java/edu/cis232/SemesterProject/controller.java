package edu.cis232.SemesterProject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class controller {
	public static boolean foodbool = false;
	public static boolean clothesbool = false;
	
	
	
	ObservableList<Item> foodList = FXCollections.observableArrayList(Inventory.food);
	ObservableList<Item> clothesList = FXCollections.observableArrayList(Inventory.clothes);
	
	POS p = new POS();
	Inventory i;
	
    @FXML
    private ListView<Item> listView;

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
    private TextField subTotal;

    @FXML
    private TextField price;

    @FXML
    private TextField name;

    @FXML
    private TextField total;

    @FXML
    private Button bttnSubTotal;

    
    //shows all clothes items
    @FXML
    void SetClothes() {
    	clothesbool = true;	
    	showItems();
    }
    //shows all food items
    @FXML
    void setFood() {
    	foodbool = true;
    	showItems();
    }

    @FXML
    void addItem() throws Exception{
    	p.addItem(name.getText(), p.getPrice(name.getText()));
    	price.setText(String.valueOf(p.getPrice(name.getText())));
    	
    	
    }

    @FXML
    void compute() {

    }

    @FXML
    void getItem() {
    	
    }

    @FXML
    void subTotal() {

    }
    public void showItems(){
    	i = new Inventory();
    	//i.printAllItems();
    	i.printInventory();
    	if(foodbool){
    		listView.setItems(foodList);
    		//listView = new ListView<Item>(foodList);
    	}else if(clothesbool){
    		//listView = new ListView<String>(clothesList);
    	}
    }

}
