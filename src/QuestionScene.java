
import java.util.*;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class QuestionScene{
	ObservableList<Person> newPersonList;
	private Text fBOutcome = new Text("First Branch Question");
	private Text sBOutcome = new Text("Second Branch Question");
	private Text tBOutcome = new Text("Third Branch Question");
	
	private TableView<Person> table = new TableView<Person>();
	@SuppressWarnings("unchecked")
	protected Scene createScene(Stage primaryStage, ArrayList<Person> personList){
		Group root = new Group();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		
		//--------add table to grid-----------------------
		table.setEditable(true);
		TableColumn <Person,Integer>gender = new TableColumn<Person,Integer>("Gender");
		TableColumn <Person,Integer>income = new TableColumn<Person,Integer>("Income");
		TableColumn <Person,Integer>education = new TableColumn<Person,Integer>("Education");
		TableColumn <Person,Integer>work = new TableColumn<Person,Integer>("Work Hours");
		TableColumn <Person,Integer>health = new TableColumn<Person,Integer>("Health");
				
		newPersonList = FXCollections.observableArrayList(personList);
		
		gender.setCellValueFactory(new PropertyValueFactory<Person,Integer>("gender"));
		income.setCellValueFactory(new PropertyValueFactory<Person,Integer>("income"));
		education.setCellValueFactory(new PropertyValueFactory<Person,Integer>("education"));
		work.setCellValueFactory(new PropertyValueFactory<Person,Integer>("studyHours"));
		health.setCellValueFactory(new PropertyValueFactory<Person,Integer>("health"));
		
		//--------add columns to the table----------------
		table.setItems(newPersonList);
		table.getColumns().addAll(gender, income, education, work, health);
				
		
		grid.add(table, 0, 0, 2, 1);
		
		//--------add button to grid-----------------------
		Button calculate = new Button();
		calculate.setText("Calculate");
		calculate.setOnAction(
				new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event){
						List<Double> fBExpectants = new ArrayList<Double>();
						List<Double> sBExpectants = new ArrayList<Double>();
						List<Double> tBExpectants = new ArrayList<Double>();
						//--------First Branch---------------------
						informationParser iP = new informationParser();
						double gE = iP.checkFile("gender.txt");
						fBExpectants.add(gE);
						double eE = iP.checkFile("education.txt");
						fBExpectants.add(eE);
						double wHE = iP.checkFile("workHours.txt");
						fBExpectants.add(wHE);
						double hE = iP.checkFile("health.txt");
						fBExpectants.add(hE);
						int minIndex = fBExpectants.indexOf(Collections.min(fBExpectants));
						System.out.println(minIndex);
						switch(minIndex){
							case 0: fBOutcome.setText("The first optimal question is gender.");
									break;
							case 1: fBOutcome.setText("The first optimal question is education.");
									break;
							case 2: fBOutcome.setText("The first optimal question is workHours.");
									break;
							case 3: fBOutcome.setText("The first optimal question is health.");
									break;
						}
						
						
						//--------Second Branch--------------------
						double eGE = iP.checkFile("education|gender.txt");
						sBExpectants.add(eGE);
						double wHGE = iP.checkFile("workHours|gender.txt");
						sBExpectants.add(wHGE);
						double hGE = iP.checkFile("health|gender.txt");
						sBExpectants.add(hGE);
						int minIndex2 = sBExpectants.indexOf(Collections.min(sBExpectants));
						System.out.println(minIndex2);
						switch(minIndex2){
						case 0: sBOutcome.setText("The second optimal question is education.");
								break;
						case 1: sBOutcome.setText("The second optimal question is workHours.");
								break;	
						case 2: sBOutcome.setText("The second optimal question is health.");
								break;
					}
						
						//---------third branch---------------------
						double eWHGE = iP.checkFile("edu|wh|g.txt");
						tBExpectants.add(eWHGE);
						double hWHGE = iP.checkFile("health|wh|g.txt");
						tBExpectants.add(hWHGE);
						int minIndex3 = tBExpectants.indexOf(Collections.min(tBExpectants));
						System.out.println(minIndex3);
						switch(minIndex3){
						case 0: tBOutcome.setText("The third optimal question is education.");
								break;
						case 1: tBOutcome.setText("The third optimal question is health.");
								break;
					}
					}
				});
		grid.add(calculate, 0, 1);
		
		//--------add text to grid-----------------------
		grid.add(fBOutcome, 0, 2);
		grid.add(sBOutcome, 0, 3);
		grid.add(tBOutcome, 0, 4);
		
		//--------add button to grid-----------------------
		Button next = new Button();
		next.setOnAction(
				new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event){
						GraphScene newGraph = new GraphScene();
						primaryStage.setScene(newGraph.createScene(personList));
					}
				});
		next.setText("Next");
		grid.add(next, 1, 2);
		
		root.getChildren().add(grid);
		return new Scene(root, 500, 600);
	}
}
