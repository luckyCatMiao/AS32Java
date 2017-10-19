package Main;

import java.io.IOException;

import GUI.MainController;
import javafx.application.Application;
import javafx.stage.Stage;

public class main extends Application{
	
	public static void main(String[] args) throws IOException {
		launch(args);

	}
	
	public void start(Stage primaryStage) throws Exception {

		new MainController(primaryStage);
	}
}
