import java.util.Random;
import java.util.Scanner;

public class DiceRolling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = 0;
        int totalPointPlayer1 = 0;
        int totalPointPlayer2 = 0;
        int totalPointPlayer3 = 0;

        while (targetNumber < 1 || targetNumber > 99) {
            System.out.print("Enter target number (1-99): ");
            targetNumber = scanner.nextInt();
        }

        int round = 1;
        while (round <= targetNumber) {
            int dice1 = random.nextInt(1, 6);
            int dice2 = random.nextInt(1, 6);
            int dice3 = random.nextInt(1, 6);

            int roundPoint = 0;

            System.out.println("Round\tPlayer 1\tPlayer 2\tPlayer 3\tTotal Point 1\t Total Point 2\t Total Point 3");

            if (dice1 == dice2 && dice2 == dice3) {
                roundPoint = dice1;
                totalPointPlayer1 += roundPoint;
                totalPointPlayer2 += roundPoint;
                totalPointPlayer3 += roundPoint;

            } else if (dice1 == dice2 || dice2 == dice3 || dice1 == dice3) {
                if (dice1 == dice2) {
                    roundPoint = dice1 * 2;
                    totalPointPlayer1 += roundPoint;
                    totalPointPlayer2 += roundPoint;
                    totalPointPlayer3 += dice3;

                } else if (dice2 == dice3) {
                    roundPoint = dice2 * 2;
                    totalPointPlayer1 += dice1;
                    totalPointPlayer2 += roundPoint;
                    totalPointPlayer3 += roundPoint;

                } else if (dice1 == dice3) {
                    roundPoint = dice1 * 2;
                    totalPointPlayer1 += roundPoint;
                    totalPointPlayer2 += dice2;
                    totalPointPlayer3 += roundPoint;
                }
            } else {
                totalPointPlayer1 += dice1;
                totalPointPlayer2 += dice2;
                totalPointPlayer3 += dice3;
            }
            System.out.println(round + "\t" + "\t" + "\t" + dice1 + "\t" + "\t" + "\t" + dice2 + "\t" + "\t" + "\t" + dice3 + "\t" + "\t" + "\t" + totalPointPlayer1 + "\t" + "\t" + "\t" + "\t" + totalPointPlayer2 + "\t" + "\t" + "\t" + "\t" + totalPointPlayer3);
            if (round == targetNumber) {
                System.out.println("Target number of rounds is reached.Game over.");
                break;
            }
            round++;
        }
    }
}

