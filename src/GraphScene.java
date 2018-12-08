import java.util.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class GraphScene{
	//the root node
	TreeItem<String> rootItem = new TreeItem<String>("DataSet");
	TreeItem<String> fLeaf = new TreeItem<String>("Female");
	TreeItem<String> mLeaf = new TreeItem<String>("Male");
	TreeItem<String> oLeaf = new TreeItem<String>("Other");
	TreeItem<String> naLeaf = new TreeItem<String>("Not Available");
	TreeItem<String> iLeaf = new TreeItem<String>("Less than 25K");
	TreeItem<String> i2Leaf = new TreeItem<String>("Up to 49k");
	TreeItem<String> i3Leaf = new TreeItem<String>("Up to 99k");
	TreeItem<String> i4Leaf = new TreeItem<String>("Up to 149K");
	TreeItem<String> i5Leaf = new TreeItem<String>("Up to 199K");
	TreeItem<String> i6Leaf = new TreeItem<String>("More than 200K");
	TreeItem<String> e1Leaf = new TreeItem<String>("High School");
	TreeItem<String> e2Leaf = new TreeItem<String>("Some College");
	TreeItem<String> e3Leaf = new TreeItem<String>("Associates");
	TreeItem<String> e4Leaf = new TreeItem<String>("Bachelors");
	TreeItem<String> e5Leaf = new TreeItem<String>("Some Graduate");
	TreeItem<String> e6Leaf = new TreeItem<String>("Graduate");
	TreeItem<String> w1Leaf = new TreeItem<String>("1-5 Hours");
	TreeItem<String> w2Leaf = new TreeItem<String>("16-35 Hours");
	TreeItem<String> w3Leaf = new TreeItem<String>("36-50 Hours");
	TreeItem<String> w4Leaf = new TreeItem<String>("More than 50 hours");
	TreeItem<String> h1Leaf = new TreeItem<String>("Excellent");
	TreeItem<String> h2Leaf = new TreeItem<String>("Very Good");
	TreeItem<String> h3Leaf = new TreeItem<String>("Good");
	TreeItem<String> h4Leaf = new TreeItem<String>("Fair");
	TreeItem<String> h5Leaf = new TreeItem<String>("Bad");
	protected Scene createScene(ArrayList<Person> personList){
		
		//for every person in the personList
		for(Person person: personList){
			int id = person.getId();
			int gender = person.getGender();
			int education = person.getEducation();
			int studyHours = person.getStudyHours();
			int health = person.getHealth();
			int income = person.getIncome();
			
			TreeItem<String> fLeaf = new TreeItem<String>(Integer.toString(id));
//			switch(gender){
//			case 567:
//				switch(studyHours){
//				case 571:
//					TreeItem<String> fLeaf = new TreeItem<String>("Female");
//					break;
//				case 572:
//					TreeItem<String> fLeaf = new TreeItem<String>("Male");
//					break;
//				case 573:
//					TreeItem<String> fLeaf = new TreeItem<String>("Other");
//					break;
//				case 574:
//					TreeItem<String> naLeaf = new TreeItem<String>("Not Available");
//					break;
//				case 575:
//					TreeItem<String> fLeaf = new TreeItem<String>("Not Available");
//						break;
//				case 740:
//					TreeItem<String> naLeaf = new TreeItem<String>("Not Available");
//					break;
//				}
//			case 568:
//				TreeItem<String> mLeaf = new TreeItem<String>("Male");
//				break;
//			case 569:
//				TreeItem<String> oLeaf = new TreeItem<String>("Other");
//				break;
//			case 570:
//				TreeItem<String> naLeaf = new TreeItem<String>("Not Available");
//				break;
			//}
		}
		
		TreeView<String> tree = new TreeView<String> (rootItem);
		Group root = new Group();
		root.getChildren().add(tree);
		return new Scene(root, 500, 500);
	}

}
