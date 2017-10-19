package GUI;

import Tool.Tool;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BaseController {

	
	/**
	 * load fxml
	 * @param path
	 * @return
	 */
	protected Parent loadFxml(String path) {
		
		return Tool.loadFxml(path,this);
		
	}
	
	
	/**
	 * create window
	 * @param stage
	 * @param root
	 * @param title
	 */
	protected void createWindow(Stage stage,Parent root,String title) {
		Scene scene = new Scene(root);
		stage.setTitle(title);
		stage.setScene(scene);
		stage.show();
	}
}
