package mcvirm01_project3;
import java.util.*;
import java.io.*;
/*
 * Name : Ryan McVicker
 * Description : Project for banks to give out transfers of different currencies 
 * Date: 3.29.21
 */

/**Asks the user for which currency they want to trade and which bank they want to use*/
class CurrencyExchange{

	public static Scanner input = new Scanner(System.in);
	public static void main(String args[]){
		Bank bank1 = new Bank("Bank1.txt");
		Bank bank2 = new Bank("Bank2.txt");
		
		do{
			System.out.print("Would you like to buy or sell? : ");
			String buyOrSell = input.nextLine();
			if ( buyOrSell.equals("sell")){
				//sell code here

				System.out.println("Which currency?: ");
				String userCurrency = input.nextLine();
				int banksThatSupport = 0;
				
				if(bank1.supportCurrency(userCurrency)){
					banksThatSupport++;
						
					}if (bank2.supportCurrency(userCurrency)){
							banksThatSupport++;
						}
				if(banksThatSupport == 0){
					System.out.printf("No banks support %s\n", userCurrency);
				}else{
					System.out.printf("%d banks support %s\n", banksThatSupport, userCurrency);
					System.out.println("How many currency?");
					String howManyCurrency = input.nextLine();
					System.out.println(bank1.quoteSell(bank1.bankName.toString(),userCurrency, Float.parseFloat(howManyCurrency)).toString());
					System.out.println(bank2.quoteSell(bank2.bankName.toString(),userCurrency, Float.parseFloat(howManyCurrency)).toString());
					}
					

				



			}else if (buyOrSell.equals("buy")){
				//buy code here
				System.out.println("Which currency?: ");
				String userCurrency = input.nextLine();
				int banksThatSupport = 0;
				if(bank1.supportCurrency(userCurrency)){
					banksThatSupport++;
					if (bank2.supportCurrency(userCurrency)){
							banksThatSupport++;
					}
				}

				if(banksThatSupport == 0){
					System.out.printf("No banks support %s\n", userCurrency);
				}else{
					System.out.printf("%d banks support %s\n", banksThatSupport, userCurrency);

					System.out.println("How many currency?");
					String howManyCurrency = input.nextLine();
					System.out.println(bank1.quoteBuy(bank1.bankName.toString(),userCurrency, Float.parseFloat(howManyCurrency)).toString());
					System.out.println(bank2.quoteBuy(bank2.bankName.toString(),userCurrency, Float.parseFloat(howManyCurrency)).toString());
				}

			}else{
				System.out.println("Please try again");
				System.out.println(buyOrSell);
			}

			System.out.println("would you like to continue? : ");
			String userChoice = input.nextLine();
			if (userChoice.equals("no")){
				System.exit(0);
			}
		}while(true);
	}

}
/** Class for representing each bank the user wants to use */
class Bank{

	public String bankName;
	private float commisionRate;
	private Currency currencyExchangeOne;
	private Currency currencyExchangeTwo;
	private Currency currencyExchangeThree;
	//map for keeping track of currencies and their exchange rates
	private static Map<String,Float> currencyMap = new HashMap<String, Float>();

	public Bank(String bankFileName){
		//open the bank file 
		try{
			FileReader bankFileReader = new FileReader(bankFileName);
			BufferedReader buffReader = new BufferedReader(bankFileReader);
			
			int objCounter = 1;

			for (int i = 1; i < 3; i++){
				if ( i == 1){
					bankName = buffReader.readLine();
				}else{

				   commisionRate = Float.parseFloat(buffReader.readLine());
				}
			}
			for(int i = 1; i < 4; i++){
				String fileLine = buffReader.readLine();

				//System.out.println(fileLine);
				String[] splitString = fileLine.split("\\s+");
				
				switch(objCounter){

					case 1: currencyExchangeOne = new Currency(splitString[0], Float.parseFloat(splitString[1]));
									currencyMap.put(splitString[0], Float.parseFloat(splitString[1]));
									break;

					case 2: currencyExchangeTwo = new Currency(splitString[0], Float.parseFloat(splitString[1]));
									
									currencyMap.put(splitString[0], Float.parseFloat(splitString[1]));
									break;

					case 3: currencyExchangeThree = new Currency(splitString[0], Float.parseFloat(splitString[1]));

									currencyMap.put(splitString[0], Float.parseFloat(splitString[1]));
									break;
					default:
									break;
				}
				objCounter++;
			}
		}catch(IOException e){
			System.out.println("err");
		}
	
	}		

	public boolean supportCurrency(String currencyCode){

		//list of Currency objects 
		//check the list of currencies in the currencyMap

		if(currencyMap.containsKey(currencyCode)){
			return true;
		}
		
		return false;	

	}

	public Quote quoteBuy(String bankName,String currencyCode, double foreignCurrency){
		double dollarsOwed = foreignCurrency * getRate(currencyCode);
		double commision = dollarsOwed * commisionRate;
		double totalCost = dollarsOwed + commision;
		Quote bankQuote = new Quote(bankName,currencyCode, (float)foreignCurrency,"USD", (float)totalCost, (float)commision);
		return bankQuote;
	}

	public Quote quoteSell(String bankName, String currencyCode, double foreignCurrency){
		double base = foreignCurrency / getRate(currencyCode); 
		double commision = commisionRate * base;
		double totalPay = base - commision;	
		Quote bankQuote = new Quote(bankName,currencyCode, (float)foreignCurrency,"USD", (float)totalPay, (float)commision);
		return bankQuote;
	}

	public float getRate(String currencyCode){

		//takes in a string, returns the currency exchange rate if valid, if not the function will return -1.0
		if(currencyMap.containsKey(currencyCode)){
			return currencyMap.get(currencyCode);
		}
		return (float)-1.0;
			
		
	}
}

/** Class which supports the functionality to document the currency exchange rates from each bank and currency code */
class Currency{

	private String currencyRate;
	private float exchangeRate;

	public Currency(String curRate, float exRate){
		currencyRate = curRate;
		exchangeRate = exRate;

	}

	public String getCurrencyCode(){

		return currencyRate;
	}

	public float getExchangeRate(){
		return exchangeRate;
	}


}

class Quote{


	public String BankName;
	private String codeToBank;
	private float amtToBank;
	private String codeFromBank;
	private float amtFromBank;
	private float chargedCommision;
	private String pattern = "##.00";

	public Quote(String bankName, String CodeToBank, float AmtToBank, String CodeFromBank, float AmtFromBank, float ChargedCommision){
			BankName = bankName;
			codeToBank = CodeToBank;
			amtToBank = AmtToBank;
			codeFromBank = CodeFromBank;
			amtFromBank = AmtFromBank;
			chargedCommision = ChargedCommision;
	}

	public String toString(){
		//returns message
		return String.format("%s will give you %f %s for %f %s, after collecting a commision of %f USD\n",BankName,amtFromBank,codeFromBank,amtToBank,codeToBank, chargedCommision);
	}
}
