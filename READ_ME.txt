Please read the following file for a description of the application.
Project Title: Decision Tree Data Mining Project
Author(s): Alex Cortes, Ricardo Delahoz, Allen Chen

Purpose: 
		 The purpose of this project is to import an excel file that contains data (attributes) pertaining to 
		 an individual. In this case those attributes are: gender, income, education, health and study/work hours. 
		 This program determines the best questions to ask in successive order to determine the income of an individual.
		 
Preliminary Setup:
		 The excel file that is imported by the program must be in the following format:
		 - There must be a worksheet that contains the original data starting from the cell A1
		 - Pivot tables are necessary to be created from the original data set
		 - As the program calculates the expectant values, additional pivot tables will be created
		 
Libraries Used:
		 The program uses the Apache POI API to import and read excel files. The API is necessary to dissect the data 
		 contained in each row, column, etc. Additionally, the JavaFx Library within the JRE System Library was used 
		 to construct a friendly user interface that conveniently guides the user through the algorithm that determines
		 the decision tree and ultimately provides a schematic, in the form of a tree, that shows a proper dissection of 
		 the individuals in the data set.
		 
User Interface:
		 There are 3 general scene types being used by the application. The first, ImportScene, allows a user to import
		 an excel file of their choice that contains the data being mined. The second, QuestionScene, performs an analysis
		 on pivot tables found in subsequent worksheets and determines what question is to be asked next. The final, 
		 GraphScene, depicts a tree in which instances of the data set are seperated based upon the questions determined
		 by the algorithm.

Files within Application:
		 - Driver.java
		 - excelReader.java
		 - informationParser.java
		 - Person.java
		 - ImportScene.java
		 - QuestionScene.java
		 - GraphScene.java
		 - READ_ME.txt
		 - edu|wh|g.txt
		 - education.txt
		 - education|gender.txt
		 - gender.txt
		 - health.txt
		 - health|gender.txt
		 - health|wh|g.txt
		 - pivotTables.txt
		 - workhours.txt
		 - workHours|gender.txt
		 
Program Flow:
		 - Import Scene contains a button. When clicked, the user is prompted for a file. In this case, the file to be 
		   chosen is dataset.xsl
		 - When the file has been chosen, the user will be directed to questionScene, where the excel file table will be 
		   shown along with a button that says calculate, three texts that say first, second, and third branch, and finally,
		   a button that says next.
		 - To calculate the optimal decision order of questions, click calculate.
		 - Once pressed, the user will notice the three texts to change:
		 	a) The first optimal question is gender
		 	b) The second optimal question is workHours
		 	c) The third optimal question is health.
		 - Additionally, the question scene uses informationParser to calculate information measures between attributes.
		   The text files contain the pivot tables obtained from the excel sheet in text format. These files are given to 
		   the informationParser class and the expectants are calculated from those files. Additional descriptions can be
		   found in the method headers in the informationParser class. 
		 - Once the measures have been taken the user may click next
		 - Clicking next will take the user to the last scene which is a graphical representation of the decision
		   tree for this data set. This tree separates the instances in the data tree, according to gender, workHours,
		   and health in that order.
		   
Incomplete Work:
		 Unfortunately, due to time constraints the following was unfinished:
		 	- In GraphScene the graph is incomplete. Because the list of instances is incorrect, the graphical
		 	  representation is unable display the graph.
		 	- In ImportScene, the button is incorrectly formatted and placed in the top right corner.
		 
Future Endeavors:
		 Ultimately, the application must become flexible enough to import an excel file with the same setup as mentioned 
		 above and possess the capability of analyzing the data set within the file, regardless of the number of attributes 
		 and the number of instances in the data set. 
		 	