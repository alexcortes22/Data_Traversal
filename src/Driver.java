import javafx.application.Application;
import javafx.stage.*;


public class Driver extends Application{
	private Stage primaryStage;
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage stage){
		primaryStage = stage;
		primaryStage.setTitle("Decision Tree");
		ImportScene newImport = new ImportScene();
		primaryStage.setScene(newImport.createScene(stage));
		primaryStage.show();
		//informationParser nP = new informationParser();
		
	}
	
	
	
	
}
