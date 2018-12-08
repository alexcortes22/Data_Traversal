import javafx.beans.property.SimpleIntegerProperty;

public class Person {
	public SimpleIntegerProperty id;
	public SimpleIntegerProperty gender;
	public SimpleIntegerProperty income;
	public SimpleIntegerProperty education;
	public SimpleIntegerProperty studyHours;
	public SimpleIntegerProperty health;
	
	
	/*
	 * Title: Person
	 * Purpose: Constructor for Person Object
	 * Parameters: 5 int values
	 * Precondition: Valid int values must be given as parameters
	 * Postcondition: A new Person object is created with 6 Simple
	 * Integer Properties.
	 */
	public Person(int newId, int newGender, int newIncome, 
					int newEducation, int newStudyHours, 
						int newHealth){
		this.id = new SimpleIntegerProperty(newId);
		this.gender = new SimpleIntegerProperty(newGender);
		this.income = new SimpleIntegerProperty(newIncome);
		this.education = new SimpleIntegerProperty(newEducation);
		this.studyHours = new SimpleIntegerProperty(newStudyHours);
		this.health = new SimpleIntegerProperty(newHealth);
		
	}
	public int getId(){
		return id.get();
	}
	public void setId(int newId){
		id.set(newId);
	}
	public int getGender(){
		return gender.get();
	}
	public void setGender(int newGender){
		gender.set(newGender);;
	}
	public int getIncome(){
		return income.get();
	}
	public void setIncome(int newIncome){
		income.set(newIncome);;
	}
	public int getEducation(){
		return education.get();
	}
	public void setEducation(int newEducation){
		education.set(newEducation);;
	}
	public int getStudyHours(){
		return studyHours.get();
	}
	public void setStudyHours(int newStudyHours){
		studyHours.set(newStudyHours);
	}
	public int getHealth(){
		return health.get();
	}
	public void setHealth(int newHealth){
		health.set(newHealth);;
	}
	
	/*
	 * Title: PrintPerson
	 * Purpose: Give a summary report of a Person Object
	 * Parameters: None
	 * Preconditions: A valid person object must be called
	 * Postconditions: A string giving a detailed report on the
	 * person object is returned. This includes all the properties of the person.
	 * 
	 */
	public String printPerson(){
		String pReport = "Person Id: " + this.getId() + "\n" +
						"Person Gender: " + this.getGender() + "\n" +
						"Person Education: " + this.getEducation() + "\n" +
						"Person Income: " + this.getIncome() + "\n" +
						"Person Study Hours: " + this.getStudyHours() + "\n" +
						"Person Health: " + this.getHealth();
		return pReport;
	}
}
