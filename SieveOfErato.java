import java.util.Scanner;

public class SieveOfErato {

	
	public static void main(String[] args) {
		//variables
		int startValue = 0;				//where the sieve will start
		int stopValue = 0;				//size of array-1
		long startTime = System.nanoTime();		//to count how long program takes in ns
		
		
		//greeting
		System.out.println("\n***********************************"
				+ "\n* Welcome to Eratosthenes's Sieve *"
				+ "\n***********************************");
		
		
		//check for commandline parameter
		if (args.length == 1) {
			startValue = Integer.parseInt(args[0]);
			System.out.println("\nEnter a stop value: ");
			Scanner a = new Scanner(System.in);
			stopValue = a.nextInt();
			a.close();
		}
		if (args.length == 2) {
			startValue = Integer.parseInt(args[0]);
			stopValue = Integer.parseInt(args[1]);
		}
		//if none, get input
		else {
			Scanner b = new Scanner(System.in);
			
			System.out.println("\nEnter a start value: ");
			startValue = b.nextInt();
			System.out.println("\nEnter a stop value: ");
			stopValue = b.nextInt();
			b.close();
		}
		
		/**start of program**/
		System.out.println("\nStart value is: " + startValue + "\nStop value is: " 
				+ stopValue);
		
		//calculate primes + display in the method.
		sieveAlgorithm(startValue, stopValue);
		
		//calculate time elasped.
		long endTime = System.nanoTime();
		System.out.println("Took " + ((endTime - startTime)/ Math.pow(10, 9)) + " s");
		
	}
	/*************************
	 * sieveAlgorithm Method *
	 *************************/
	//uses a boolean array set to true and marks off non prime numbers.
	//Displays total number of primes at the end.
	public static void sieveAlgorithm(int startValue, int stopValue) {
		
		boolean[] sieveArray = new boolean[stopValue + 1];		//bool array to store true/false values
		int totalPrimes = 0; 						//counter for num of primes 
		
		//set every value to true
		for (int i = 2; i <= stopValue; i++ ) {
			sieveArray[i] = true;
		}
		
		//calculate, starting at 2
		for (int i = 2; i * i <= stopValue; i++) {
			
			//if value is unmarked, find the multiples of i and mark them off
			if(sieveArray[i] == true) {
				for (int j = i * i; j <= stopValue; j += i) {
					sieveArray[j] = false;
				}
			}
		}
			
		//count how many prime numbers there are starting at startValue.
		for (int i = startValue; i <= stopValue; i++) {
			if (sieveArray[i] == true) {
				totalPrimes++;
			}
		}
		
		System.out.println("Total number of primes: " + totalPrimes);
	}
	
	/************************
	 * validateStart Method *
	 ************************/
	//checks that startValue isn't less than or equal to 1
	public static int validateStart(int startValue) {
		
		if (startValue <= 1) {
			while(startValue <= 1) {
				System.out.println("Invalid input.\nEnter a start value: ");
				Scanner input = new Scanner(System.in);
				startValue = input.nextInt();
				input.close();
			}
		}
		return startValue;
	}

	
}
