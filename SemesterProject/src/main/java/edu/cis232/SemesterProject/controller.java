package edu.cis232.SemesterProject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class controller {
	public static boolean food = false;
	public static boolean clothes = false;
	
	POS p = new POS();
	
    @FXML
    private ListView<?> listView;

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

    
    
    @FXML
    void SetClothes() {
    	clothes = true;	
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
    void setFood() {
    	food = true;
    }

    @FXML
    void subTotal() {

    }

}
