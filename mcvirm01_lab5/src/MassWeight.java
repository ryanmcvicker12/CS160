package mcvirm01_lab5;
import java.util.*;


public class MassWeight{

	public static void main(String[] args){
		//scanner for user input 
		Scanner sc = new Scanner(System.in);
		//variables for counting 
		int itemCounter = 0;
		int validCounter = 0;
		double validWeightCounter = 0;
		double validWeightAverage; 
		while(true){
			
			//ask for the objects name
			System.out.print("Enter the objects name: ");
			//add to itemCounter
			itemCounter++;

			String objectName = sc.next();
			
			System.out.print("Enter the objects mass: ");
			//ask user for objects mass
			double objectMass = sc.nextDouble();
			//if the user enters -5 the program exits
			if((int) objectMass == -5){
				break;
			}
			//add to item counter 
			//variable for storing the objects weight
			double objectWeight = objectMass * 9.8;

			//compare objects weight
			if ( objectWeight > 1000){
				System.out.printf("\n%s is too heavy!\n", objectName);
			}else if( objectWeight < 10){

				System.out.printf("\n%s is too light!\n", objectName);
			}else{
				System.out.printf("\n%s's weight is %.2f Newtons.\n", objectName,objectWeight);
				//add to valid counter
				validCounter++;
				//add objects mass to validWeightCounter
				validWeightCounter += objectWeight;
			}

		}
		validWeightAverage = validWeightCounter / (double) validCounter;
		System.out.printf("------\nTotal input count: %d\nTotal valid count : %d\nTotal valid weight input: %.2f\nAverage valid weight: %.2f\n",itemCounter,validCounter,validWeightCounter,validWeightAverage);
	}

}
