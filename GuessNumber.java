import java.util.Scanner;

public class GuessNumber {

	public static void main(String[] args) {
		
		//create new scanner object
		Scanner in = new Scanner(System.in);
		
		//ask user name and assign to string variable
		System.out.println("What is your name?");
		String userName = in.nextLine();
		
		//ask user number and assign to int variable
		System.out.println("Hello "+userName+", please pick a number between 1 and 10");
		int userNumber = in.nextInt();
		in.close();
		
		//generate random number between one and ten
		int rNumber = (int)(Math.random()*10)+1;
		
		//congratulate or console user if guess matches/is different than random number
		if (rNumber == userNumber) {
			System.out.println("Congratulations "+userName+". Your guess of "+userNumber+" matched my guess of "+rNumber+".");
		}else {
			System.out.println("Sorry "+userName+". Your guess of "+userNumber+" did not match my guess of "+rNumber+".");
		}
		
	}

}