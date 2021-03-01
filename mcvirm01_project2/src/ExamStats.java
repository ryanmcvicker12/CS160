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

	//variables that hold the minimum and maximum score
	static double minimumScore;
	static double maximumScore;

	//hold total of all valid scores
	static double totalCount;
	
	//holds the average for all valid scores
	static double averageScore;

	//variables that hold the occurences of each letter grade
	static int ACount;
	static int BCount;
	static int CCount;
	static int DCount;
	static int FCount;

	//variables for holding the percentage of certain grade letters
	static double APercentage;
	static double BPercentage;
	static double CPercentage;
	static double DPercentage;
	static double FPercentage;

	public static void main(String[] args){
		

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

				
			}


			//Calculate the standard deviation

			double stdSum = 0;

			for( double scoreListValue : scoreList ){ 

				stdSum += Math.pow((averageScore - scoreListValue), 2);

			}

			double std = Math.sqrt((stdSum / totalCount)); 
			//use print stream to tell the JVM to pipe all output into a file named "output.txt"
			
			PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

			System.setOut(out);

			System.out.println("Exam stats\n");	
			
			//cast the totalCount into an int to prevent tracing x.0000000

			System.out.printf("Number of Scores: %d\n", (int)totalCount);
			System.out.printf("Average Score : %.2f\n", averageScore);
			System.out.printf("Standard deviation: %.2f\n", std);
			//test out the percentages and make sure they are correct

			System.out.printf("A count: %d   %.2f%%\n",ACount,APercentage);
			System.out.printf("B count: %d   %.2f%%\n",BCount,BPercentage);
			System.out.printf("C count: %d   %.2f%%\n",CCount,CPercentage);
			System.out.printf("D count: %d   %.2f%%\n",DCount,DPercentage);
			System.out.printf("F count: %d   %.2f%%\n",FCount,FPercentage);

			//print out min and max

			System.out.printf("Minimum Score : %.2f\nMaximum Score: %.2f\n",minimumScore,maximumScore); 

			}catch(Exception ex){

				System.err.println("Enter valid filename");

			}

			
			
	
	

	}

}
