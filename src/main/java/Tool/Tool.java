package Tool;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.InvalidParameterException;

import Main.Config;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;

public class Tool {

	
	public static Parent loadFxml(String path, Object controller) {
		FXMLLoader loader=new FXMLLoader();
		if(controller!=null)
		{
			loader.setController(controller);
		}
		
		try {
			loader.setLocation(new File(Config.FXML_DIRECTORY +path+".fxml").toURL());
			return loader.load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return null;
	}

	
}
