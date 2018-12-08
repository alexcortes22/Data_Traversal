import java.io.*;
import java.lang.reflect.Array;
import java.util.Scanner;


public class informationParser {
	
	//empty constructor
	public informationParser(){
	
	}
	
	/*
	 * Title: fileReader
	 * Purpose: The purpose of this method is to read in a 
	 * string and find the file that corresponds to that string.
	 * Once found, fileReader has the ability to transform the
	 * text data to a 2D array
	 * Parameters: String inFile
	 * Preconditions: A valid string must be given
	 * Postconditions: A 2D array is returned
	 * Exceptions: IOException to check the validity of the file
	 * 
	 */
	public int[][] fileReader(String inFile) throws IOException{
		File inputFile = new File(inFile);
		Scanner iFS = new Scanner(inputFile);
		Scanner iFS2 = new Scanner(inputFile);
		Scanner iFS3 = new Scanner(inputFile);
		
		int row = 0;
		while(iFS.hasNextLine()){
			row++;
			iFS.nextLine();
		}
	
		int column = 0;
		String numbers = iFS2.nextLine();
		String[] splitN = numbers.trim().split("\\s+");
		column = Array.getLength(splitN);
		
		int count = 0;
		int[] allVal = new int[row * column];
		while(iFS3.hasNext()){
			allVal[count++] = iFS3.nextInt();
		}
		iFS.close();
		iFS2.close();
		iFS3.close();

		int[][] pivotTable = new int[row][column];
		int c = 0;
		for (int i = 0; i < row; i++){
			for(int j = 0; j < column; j++){
				pivotTable[i][j] = allVal[c++];
			}
		}
		return pivotTable;
	}
	/*
	 * Title: expectantCalculator
	 * Purpose: The purpose of this method is to read in a 
	 * 2D array and calculate information measures for that 
	 * particular attribute.
	 * Parameters: 2D integer array
	 * Preconditions: a valid pivot table must be contained within
	 * the 2D array
	 * Postconditions: The expectant value for that attribute is 
	 * returned.
	 * Exceptions: None
	 * 
	 */
	public double expectantCalculator(int[][] pivotTable){
		double expectant = 0;
		double genderExpectant = 0;
		//total count of all data instances
		double totalCount = (double)pivotTable[pivotTable.length - 1][pivotTable[0].length - 1];
		//for each row(gender, education, workHour, health bracket)
		for (int i = 0; i < pivotTable.length - 1; i++){
			//for each income bracket
			for (int j = 0; j < pivotTable[0].length - 1; j++){
				//the count of the gender is at the end of the row
				int genderCount = pivotTable[i][pivotTable[0].length - 1];
				//the current value 
				if(pivotTable[i][j] != 0){
					int current = pivotTable[i][j];
					//System.out.println(current);
				
					double numerator = current/totalCount;
					//System.out.println("Top part of fraction: " + formatter.format(numerator));
					double denominator = genderCount/totalCount;
					//System.out.println("Bottom part of fraction: " + formatter.format(denominator));
					double logPart = (Math.log(denominator/numerator))/(Math.log(2));
				
					//total expectant
					if(((numerator/denominator)*logPart) >= 0){
						genderExpectant += ((numerator/denominator)*logPart);
					}else{
						genderExpectant += ((numerator/denominator)*logPart) * -1;
					}
					//System.out.println("Current expectant: " + genderExpectant);
				}
			}
			expectant += genderExpectant;
			//System.out.println("Expectant for a type of gender: " + expectant);
		}
		return expectant;
	}
	
	/*
	 * Title: checkFile
	 * Purpose: To process a file with a try catch block and determine
	 * whether any exceptions are thrown. Additionally this method prints
	 * out the expectant value found within the pivot table.
	 * Parameters: String inFile
	 * Preconditions: A valid string must be given(one of the text files)
	 * Postconditions: Expectant value for attribute is printed
	 * Exceptions: IOException to check the validity of the file
	 * 
	 */
	public double checkFile(String inFile){
		double genderExpectant = 0.0;
		try{
			int[][] genderValues = fileReader(inFile);
			genderExpectant = expectantCalculator(genderValues);
			System.out.println("Expectant for " + inFile + ": "  + genderExpectant);
		} catch(IOException e){
			System.out.print("Error reading file: gender");
		}
		return genderExpectant;
	}
	
}

	
