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
	
	
	
	ObservableList<String> foodList;
	ObservableList<String> clothesList;
	
	POS p = new POS();
	Inventory i;
	
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
    	p.addItem(name.getText(), p.getPrice(name.getText()),Double.parseDouble(qnt.getText()));
    	qnt.setText("1");
    }

    @FXML
    void compute() {

    }

    @FXML
    void getItem() throws Exception{
    	name.setText(listView.getSelectionModel().getSelectedItem());
    	price.setText(String.valueOf(p.getPrice(name.getText())));
    }

    @FXML
    void subTotal() {
    	subTotaltxt.setText(String.valueOf(p.total));
    }
    public void showItems(){
    	i = new Inventory();
    	//i.printAllItems();
    	i.printInventory();
    	if(foodbool){
    		foodList= FXCollections.observableArrayList(Inventory.food.get(0).getName());
    		for(int i=1; i<Inventory.food.size(); i++){
    			foodList.add(Inventory.food.get(i).getName());
    		}
    		
    		listView.setItems(foodList);
    		
    	}else if(clothesbool){
    		clothesList= FXCollections.observableArrayList(Inventory.clothes.get(0).getName());
    		for(int i=1; i<Inventory.clothes.size(); i++){
    			clothesList.add(Inventory.clothes.get(i).getName());
    		}
    		
    		listView.setItems(clothesList);
    	}
    }

}
