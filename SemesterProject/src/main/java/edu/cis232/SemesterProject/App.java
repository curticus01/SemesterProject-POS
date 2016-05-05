package edu.cis232.SemesterProject;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(App.class.getResource("POS_GUI.fxml"));
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		//REQ#1
		stage.setTitle("POS - By Jake Shaw and Curtis Coughenour");		
		stage.show();
		
	}
}
