package GUI;

import Converter.AS32J;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class MainController extends BaseController{

	private Stage stage;
	private Parent root;
	
	@FXML
	private TextArea sourceTA;
	@FXML 
	private TextArea targetTA;

	public MainController(Stage primaryStage) {
		this.stage = primaryStage;
		this.root=loadFxml("main");
		createWindow(primaryStage, root, "AS3ToJavaConverter");
		
		initView();
	}

	private void initView() {
		// TODO Auto-generated method stub
		
	}

	
	@FXML
	public void pressButton()
	{
		String source=sourceTA.getText();
		String result=AS32J.convert(source);
		targetTA.setText(result);
		
	}
}
