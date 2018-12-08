/**
* Column 1: Gender					567: F, 568:M, 569: Prefer not to answer, 570: Other		
* Column 2: Household income		571:0-25K, 572:25K-49K, 573:50K-99999, 574:100K-149999, 575: 150K-199999, 740:200K and up		
* Column 3: Education level			741:HS Diploma, 742:Some college, 743:2-year college, 744:4-year, 745:some graduate, 746: graduate		
* Column 4: Work/study hours		588:1-5 hours, 589:16-35, 590: 36-50, 591:50+		
* Column 5: Overall health			592:Excellent, 593:Very Good, 594:Good, 595:Fair, 596: Poor		
* 
*/
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class excelReader {
	
	public int cellValue;
	public ArrayList<Person> reader(File newFile) {
		ArrayList<Person> pList = new ArrayList<Person>();
		Person newP;
		//taking in an excel file
		try{
			FileInputStream excelFile = new FileInputStream(newFile);
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			Sheet dataTypeSheet = workbook.getSheet("Sheet1");
			Iterator<Row> iterator = dataTypeSheet.iterator();
			//every row
			while(iterator.hasNext()){
				//get the current rows
				Row currentRow = iterator.next();
				int currentRowNum = currentRow.getRowNum();
				Iterator<Cell> cellIterator = currentRow.iterator();
				//an array of 5 values: gender, income, education, study hours, health; 
				int[] rowArray = new int[5];
				//get the current cell
				while(cellIterator.hasNext()){
					//get current Cell
					Cell currentCell = cellIterator.next();
					//get current cell number
					int currentCellNum = currentCell.getColumnIndex();
					//System.out.println(currentCellNum);
					cellValue = (int)currentCell.getNumericCellValue();
					//putting the value of the cell into the array
					rowArray[currentCellNum] = cellValue;
				}
				newP = new Person(currentRowNum + 1, rowArray[0], 
						rowArray[1], rowArray[2], 
						rowArray[3], rowArray[4]);
				System.out.println(newP.printPerson() + "\n");
				pList.add(newP);
				
			}
			
			for(Person p: pList){
				System.out.println(p.printPerson() + "\n");
			}
			workbook.close();
			excelFile.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		return (pList);

	}

	
}
