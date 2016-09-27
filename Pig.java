// Dylan Balata
// CS 152L-001
// Lab 3
import java.util.Scanner;

public class Pig {


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int playerOneScore = 0;
		int playerTwoScore = 0;
		int playerOneRoundScore = 0;
		int playerTwoRoundScore = 0;
		int diceRoll;
		// end game conditions
		while (playerOneScore < 100 && playerTwoScore < 100) {

			playerOneRoundScore = 0;
			playerTwoRoundScore = 0;

			// should be redundant loop break
			if (playerOneScore > 100 || playerTwoScore > 100) {
				break;
			}
			// player one roll decision input
			System.out
					.println("It is Player one's turn, would you like to roll? y/n");
			String playerOneAnswer = sc.nextLine();

			// loop: checks win condition, rng 1-6 for dice, adds to (2-6) or
			// deletes (1) round score
			while ((playerOneAnswer.equals("y")) && (playerOneScore < 100)
					&& (playerTwoScore < 100)) {

				diceRoll = (int) (Math.random() * 6 + 1);
				System.out.println("You rolled " + diceRoll + ".");
				if (diceRoll == 1) {
					playerOneRoundScore = 0;
					break;
				} else {
					playerOneRoundScore = diceRoll + playerOneRoundScore;
				}
				if ((playerOneScore >= 100) || (playerOneRoundScore >= 100)) {
					break;
				}
				System.out.println("Player one's round score is now "
						+ playerOneRoundScore
						+ ". Would you like to roll again? y/n");
				playerOneAnswer = sc.nextLine();

			}

			playerOneScore = playerOneScore + playerOneRoundScore;

			if ((playerOneScore >= 100) || (playerOneRoundScore >= 100)) {
				break;
			}

			System.out.println("The score is " + playerOneScore + "v"
					+ playerTwoScore);

			System.out
					.println("It is Player two's turn, would you like to roll? y/n");
			String playerTwoAnswer = sc.nextLine();
			// same as first loop but for player 2
			while (playerTwoAnswer.equals("y") && playerOneScore < 100
					&& playerTwoScore < 100) {

				diceRoll = (int) (Math.random() * 6 + 1);
				System.out.println("Player two rolled " + diceRoll + ".");
				if (diceRoll == 1) {
					playerTwoRoundScore = 0;
					break;
				} else {
					playerTwoRoundScore = diceRoll + playerTwoRoundScore;
				}

				if ((playerTwoScore >= 100) || (playerTwoRoundScore >= 100)) {
					break;
				}
				System.out.println("Player two's round score is now "
						+ playerTwoRoundScore
						+ ". Would you like to roll again? y/n");
				playerTwoAnswer = sc.nextLine();
			}

			playerTwoScore = playerTwoScore + playerTwoRoundScore;

			System.out.println("The score is " + playerOneScore + "v"
					+ playerTwoScore);

		}
		// end game print outs
		if (playerOneScore >= 100) {
			System.out.println("Player One has won with a score of "
					+ playerOneScore + " to " + playerTwoScore);
		} else {
			System.out.println("Player Two has won with a score of "
					+ playerOneScore + " to " + playerTwoScore);
			sc.close();

		}
	}
}
