
import java.io.File;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ImportScene {
	
	//private ArrayList<simplePerson> personList;
	protected Scene createScene(Stage primaryStage){
		Group root = new Group();
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Excel File");
		Button btn = new Button();
		btn.setAlignment(Pos.CENTER);
		btn.setText("Import Excel File");
		btn.setOnAction(
			new EventHandler<ActionEvent>(){
				@Override
				public void handle(ActionEvent event){
					File excelFile = fileChooser.showOpenDialog(primaryStage);
					if (excelFile != null){
						excelReader ER = new excelReader();
						//retrieving objects from excel
						ArrayList<Person> personList = ER.reader(excelFile);
						QuestionScene newQuestion = new QuestionScene();
						primaryStage.setScene(newQuestion.createScene(primaryStage, personList));
					}
					
				}
			});
		root.getChildren().add(btn);
		return new Scene(root, 300, 250);
		
	}
}
	
