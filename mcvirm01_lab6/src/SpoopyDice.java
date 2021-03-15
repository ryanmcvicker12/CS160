package mcvirm01_lab6;
import java.util.*;
import java.io.*;
import javax.swing.*;
/*
 Name : Ryan McVicker
 Description : Dice game against computer given how many rolls the user specifies
 Date : 3.15.2021
*/

public class SpoopyDice{

	//method the roll dice 

	static boolean rollDice(){

		//use the random object above the main method to roll the dice

		int rollOne = rd.nextInt(6 - 1 + 1) + 1; 

		int rollTwo= rd.nextInt(6 - 1 + 1) + 1; 

		// determine if both of the dice matched	
		
		if (rollOne == rollTwo){
			return true;
		}else{
			return false;
		}

		
			

	}
	static int determinePlay(){

		//method to check the users input 

		//bring up OptionPane for user

		int user_input = JOptionPane.showConfirmDialog(null,"would you like to play?");

		return user_input;	
		
		
	}

	static void playGame(int pg){

		//method to roll the dice and play the game

		System.out.println("game starts here");

		String rolls = JOptionPane.showInputDialog(null,"How many rolls?");

		System.out.printf("number of rolls: %s\n\n", rolls);

		//call roll dice

		boolean gameRoll = rollDice();

		for (int i = 0; i < Integer.parseInt(rolls);i++){
			
			// if rollDice() returns "true" the player wins, else = Computer wins

			if(gameRoll == true){

				//the user wins 

				System.out.println("Player wins!");

				System.exit(0);
			
			}	
		}
		
		System.out.println("Oh No! you have been baked into a spoopy pie!");
		
		System.exit(0);

	}

	public static Random rd = new Random();

	public static void main(String[] args){

			int pg = determinePlay();

			//coditional to check the users input 

			if(pg != -5){

				playGame(pg);

			}
			
	}
}

