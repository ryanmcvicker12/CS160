package mcvirm01_project2;
import java.util.*;
import java.io.*;

/*
 * Ryan McVicker
 * take text input file 
 * - any score that is 0 < x < 100 should not be counted
 *   - get filename from user 
 *   - if file doesnt exist, ask the user until they supply one that does
 */

public class ExamStats{
	
	//variables that hold the minimum score for each letter grade
	static final double minA = 90;
	static final double minB= 80;
	static final double minC = 70;
	static final double minD = 60;

	public static void main(String[] args){
		double minimumScore;
		double maximumScore;
		double totalCount;
		double averageScore;
		//ask until user gives an existing file	
		while(true){
			Scanner sc = new Scanner(System.in);
			try{
				System.out.print("Enter the file name: ");
				String filename = sc.nextLine();
				FileReader fr = new FileReader(filename);
				BufferedReader br = new BufferedReader(fr);
				String score = br.readLine();

				br.close();
				break;
				
			} catch(Exception ex){
				System.out.println("Enter valid filename");
			}
		}	

	}

}
