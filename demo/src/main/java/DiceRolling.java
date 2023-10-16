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
                int dice1 = random.nextInt(1,6);
                int dice2 = random.nextInt(1,6);
                int dice3 = random.nextInt(1,6);

                System.out.println("Player 1: " + dice1);
                System.out.println("Player 2: " + dice2);
                System.out.println("Player 3: " + dice3);

                int roundPoint = 0;

                if (dice1 == dice2 && dice2 == dice3) {
                    roundPoint = dice1;
                    totalPointPlayer1 += roundPoint;
                    totalPointPlayer2 += roundPoint;
                    totalPointPlayer3 += roundPoint;

                    System.out.println("All players rolled same dice!");

                } else if (dice1 == dice2 || dice2 == dice3 || dice1 == dice3) {
                    if (dice1 == dice2 && dice1>dice3) {
                        roundPoint = dice1 * 2;
                        totalPointPlayer1 += roundPoint;
                        totalPointPlayer2 += roundPoint;
                        totalPointPlayer3 += dice3;
                        System.out.println("Player 1 and Player 2 rolled the same dice, both players " + roundPoint + " adding points.");
                    } else if (dice2 == dice3 && dice2>dice1) {
                        roundPoint = dice2 * 2;
                        totalPointPlayer1 += dice1;
                        totalPointPlayer2 += roundPoint;
                        totalPointPlayer3 += roundPoint;
                        System.out.println("Player 2 and Player 3 rolled the same dice, both players " + roundPoint + " adding points.");
                    } else if(dice1 == dice3 && dice1>dice2){
                        roundPoint = dice1 * 2;
                        totalPointPlayer1 += roundPoint;
                        totalPointPlayer2 += dice2;
                        totalPointPlayer3 += roundPoint;
                        System.out.println("Player 1 and Player 3 rolled the same dice, both players " + roundPoint + " adding points.");
                    }
                } else {
                    totalPointPlayer1 += dice1;
                    totalPointPlayer2 += dice2;
                    totalPointPlayer3 += dice3;
                    System.out.println("All players rolled the difference dice!");
                }

                System.out.println("Round " + round + ":");
                System.out.println("Player 1: " + dice1);
                System.out.println("Player 2: " + dice2);
                System.out.println("Player 3: " + dice3);
                System.out.println("Round Point: " + roundPoint);
                System.out.println("Total Points:");
                System.out.println("Player 1: " + totalPointPlayer1);
                System.out.println("Player 2: " + totalPointPlayer2);
                System.out.println("Player 3: " + totalPointPlayer3);
                System.out.println("---------------");

                if (round == targetNumber) {
                    System.out.println("Target number of rounds is reached.Game over.");
                    break;
                }
                round++;
            }
        }
    }

