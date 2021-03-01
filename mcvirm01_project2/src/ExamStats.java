package mcvirm01_project2;
import java.util.*;
import java.io.*;

/*
 * Name : Ryan McVicker
 * Project Name : mcvirm01_project2
 */

/** Name: Ryan McVicker
 * Description: This project analyzes a text file from the user; Calculating the mean, median, and
 * standard deviation.
 */

public class ExamStats{
	
	//scanner object for recieving data
	
	static Scanner sc = new Scanner(System.in);
	
	//variables that hold the minimum values for each letter grade
	
	static final double minA = 90;
	static final double minB = 80;
	static final double minC = 70;
	static final double minD = 60;

	public static void main(String[] args){
		
		//variables that hold the minimum and maximum score
		double minimumScore;
		double maximumScore;

		//hold total of all valid scores
		double totalCount;
		
		//holds the average for all valid scores
		double averageScore;

		//variables that hold the occurences of each letter grade
		double ACount;
		double BCount;
		double CCount;
		double DCount;
		double FCount;

		//variables for holding the percentage of certain grade letters
		double APercentage;
		double BPercentage;
		double CPercentage;
		double DPercentage;
		double FPercentage;

		//string variable for holding the file name the user provides, assuming they add the appropriate file extension
		String filename;

		//File object used for verifying the existence of the file the user provided 
		File dataFile;

		try{

			//while loop that breaks when dataFile.isFile() is true

			while(true){

				System.out.print("Enter the file name: ");

				filename = sc.nextLine();

				dataFile = new File(filename);

				//check if file exists
				
				if(dataFile.isFile()){

					break;

				}else{

					System.err.println("File does not exist.");

				}
			}

			//read the file using a scanner object

			Scanner testFile = new Scanner(dataFile);			

			//ArrayList for storing the converted Strings from testFile

			ArrayList<Double> scoreList = new ArrayList<Double>();

			//iterate through the file, remove any invalid numbers

			while(testFile.hasNextLine()){

				// add all values to the arrayList, then remove invalid numbers
				
				String line = testFile.nextLine();
				
				//split the input from line into an array of strings

				String[] stringArray = line.split(" ");

				//for loop to iterate through String list, adds them to scoreList 

				for(String scoreValue : stringArray){

					//scoreToDouble is a variable that converts scoreValue into a(n) double
					
					double scoreToDouble = Double.parseDouble(scoreValue);

					//check if scoreValue is a valid double to add to scoreList

					if ( scoreToDouble >= 0 && scoreToDouble <= 100){

						//add value to scoreList

						scoreList.add(scoreToDouble);

						//add to totalCount

						totalCount++;

						//switch statement that counts which letter grade scoreToDouble is

					

						if( scoreToDouble >= 90){

							//Add to "A" count

							ACount++;

						}
						else if(scoreToDouble >= 80 && scoreToDouble < 90){ 

							//Add to "B" count

							BCount++;
						}

						else if(scoreToDouble >= 70 && scoreToDouble < 80){

							//Add to "C" count

							CCount++;
						}	
						else if(scoreToDouble >= 60 && scoreToDouble < 70){

							//Add to "D" count

							DCount++;

						}else{
							
							//Add to "F" count

							FCount++;

						}	

						
					}
				}


				//Get the minimum and maximum scores using Collections

				minimumScore = Collections.min(scoreList);

				maximumScore = Collections.max(scoreList);

				//iterate through scoreList and calculate the average
				
				double sumOfScores = 0;

				for ( Double scoreListScore : scoreList ){
					
					sumOfScores += scoreListScore;							
					
				}

				averageScore = sumOfScores / totalCount;
					
				//Calculate the percentage of each score, remember to print these out 

				//to two decimal spaces with System.out.printf("%.2f");

				APercentage = (ACount / totalCount) * 100;
				BPercentage = (BCount / totalCount) * 100;
				CPercentage = (CCount / totalCount) * 100;
				DPercentage = (DCount / totalCount) * 100;
				FPercentage = (FCount / totalCount) * 100;
				
				//output

				System.out.println("Exam stats\n");	
				System.out.printf("Number of Scores: %f\n", totalCount);
				System.out.printf("Average Score : %.2f\n", averageScore);
				//test out the percentages and make sure they are correct
				System.out.printf("A count: %f   %.2f%%\n",ACount,APercentage);
				System.out.printf("B count: %f   %.2f%%\n",BCount,BPercentage);
				System.out.printf("C count: %f   %.2f%%\n",CCount,CPercentage);
				System.out.printf("D count: %f   %.2f%%\n",DCount,DPercentage);
				System.out.printf("F count: %f   %.2f%%\n",FCount,FPercentage);
				//print out min and max

				System.out.printf("Minimum Score : %.2f\nMaximum Score: %.2f\n",minimumScore,maximumScore); 
			}

			//exit the application

			System.exit(0);	

		} catch(Exception ex){

			System.err.println("Enter valid filename");

			System.exit(0);

		}
			

	}

}
