package mcvirm01_package1;
import java.util.*;
import java.lang.Math;

/*
* Ryan McVicker
* Project 1 : CAFE Compliance Analyzer 
* 
* Description : This project calculates if two vehicles match the 2011 cafe compliance requirement
*/ 


public class CafeComplianceAnalyzer{
	
	//declare all named constants 
	public static double MAX_FUEL_ECONOMY = 30.4;
	public static double MIN_FUEL_ECONOMY = 21.7; 
	public static double MIDWAY_FOOTPRINT = 47.74;
	public static double RATE = 4.65;
	//main method 
	public static void main(String[] args){
		//print out the welcome message 
		System.out.println("Welcome to the 2016 CAFE Compliance Analyer for CS Motors");
		//get user inputs for the equation		
		
		//user input scanner object for reading input
		Scanner userInput = new Scanner(System.in);

		//get the vehicle input 

		System.out.print("Enter vehicle footprint: " );
		double vehicleFootprint = userInput.nextDouble();

		// Data for vehicle 1

		System.out.println("Enter model name for model 1: ");
		String modelName = userInput.next(); 
		
		System.out.println("Enter production amount for model 1: ");
		int productionAmount = userInput.nextInt(); 
		
		System.out.println("Enter mpg rating for model 1: ");
		double mpgRating = userInput.nextDouble();
		
		// Data for vehicle 2	
			
		System.out.println("Enter model name for model 2: ");
		String modelName2 = userInput.next(); 
		
		System.out.println("Enter production amount for model 2: ");
		int productionAmount2 = userInput.nextInt(); 
		
		System.out.println("Enter mpg rating for model 2: ");
		double mpgRating2 = userInput.nextDouble();
		
		//Data for vehicle 3
			
		System.out.println("Enter model name for model 3: ");
		String modelName3 = userInput.next(); 
		
		System.out.println("Enter production amount for model 3: ");
		int productionAmount3 = userInput.nextInt(); 
		
		System.out.println("Enter mpg rating for model 3: ");
		double mpgRating3 = userInput.nextDouble();
		
		// calculate the cafe compliance analysis  
			
		double targetFuelEconomy  = 1/(1/MAX_FUEL_ECONOMY + (1/MIN_FUEL_ECONOMY - 1/MAX_FUEL_ECONOMY)*(Math.exp(vehicleFootprint - MIDWAY_FOOTPRINT)/ RATE) / 
		(1 + Math.exp(vehicleFootprint - MIDWAY_FOOTPRINT)/RATE)); 

		
		// Calculate fleet fuel economy
		double FleetFuelEconomy = (productionAmount + productionAmount2 + productionAmount3 ) / ((productionAmount / mpgRating) + (productionAmount2 / mpgRating2) + (productionAmount3 / mpgRating3));



		//Print out the banner message 
		System.out.println("Cafe Compliance Analysis Report for CS motors");
		System.out.println("---------------------------------------------");

		System.out.printf("Vehicle Footprint : %f sq. ft. \nTarget Fuel Economy :  %f mpg\n\n ", vehicleFootprint, targetFuelEconomy);
	
		//prints out the analysis using formatting 
		System.out.printf("Model\tProduction\tMPG\n-----\t----------\t---\n%s\t%d\t%f\n%s\t%d\t%f\n%s\t%d\t%f\n Fleet fuel Economy: %f mpg.\n", 
		modelName,productionAmount,mpgRating, modelName2, productionAmount2, mpgRating2, modelName3,productionAmount3,mpgRating3, FleetFuelEconomy);

	}
}
