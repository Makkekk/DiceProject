package opgave03;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Pigs {
    public static int Winning_score = 100; //Det man skal ramme for at vinde
    public static int rollCount = 0;
    public static int player1_Score = 0;
    public static int player2_Score = 0;
    public static int roundScore1 = 0;
    public static int roundScore2 = 0;

    public static void main(String[] args) {

        displayRules();
        playPig(); //START spillet
    }


    public static void displayRules() {
        System.out.println("Velkommen til Pig!");
        System.out.println("Spillets regler:");
        System.out.println("1. To spillere skiftes til at kaste en terning.");
        System.out.println("2. På hver tur kan spilleren vælge at rulle eller holde.");
        System.out.println("3. Hvis spilleren ruller en 1, mister de alle point fra den runde, og turen skifter.");
        System.out.println("4. Hvis spilleren vælger at holde, tilføjes rundens point til deres samlede score.");
        System.out.println("5. Den første spiller, der når 100 point, vinder spillet.");
        System.out.println();
    }

    public static void playPig() {

        Scanner scanner = new Scanner(System.in);


        boolean isPlayer1Turn = true;

        //Vis score for spillere så længe scoren er under 100.
        while (player1_Score < Winning_score && player2_Score < Winning_score) {

            System.out.print("Rul en terning? ('ja/nej') ");
            String answer = scanner.nextLine();

            while (!answer.equals("nej")) {

                if (isPlayer1Turn) {
                    roundScore1 = rollDie();
                    System.out.println();
                    System.out.println("Spiller 1 rullede: " + roundScore1);
                    if (roundScore1 == 1) {
                        System.out.println("Ups, du rullede 1, gg");
                        roundScore1 = 0;
                        isPlayer1Turn = false;
                    } else {
                        player1_Score = (player1_Score + roundScore1);
                        System.out.println("Spiller 1's tur. Aktuel score: " + player1_Score);
                        if (player1_Score >= Winning_score) {
                            System.out.println("Spiller 1 vinder med " + player1_Score + " point");
                            return; // End the game if player 1 wins
                        }
                    }
                } else {
                    roundScore2 = rollDie();
                    System.out.println();
                    System.out.println("Spiller 2 rullede: " + roundScore2);

                    if (roundScore2 == 1) {
                        System.out.println("Ups, du rullede 1, gg");
                        isPlayer1Turn = true;
                    } else {
                        player2_Score = (player2_Score + roundScore2);
                        System.out.println("Spiller 2's tur. Aktuel score: " + player2_Score);
                        if (player2_Score >= Winning_score) {
                            System.out.println("Spiller 2 vinder med " + player2_Score + " point");
                            isPlayer1Turn= true;
                            return; // End the game if player 2 wins
                        }
                    }
                }
            } if  (answer.equals("nej")) {
                if (isPlayer1Turn) {
                    player1_Score += roundScore1;
                    roundScore1 = 0; // Nulstil rundescore
                    isPlayer1Turn = false; // Skift til spiller 2
                } else {
                    player2_Score += roundScore2;
                    roundScore2 = 0; // Nulstil rundescore
                    isPlayer1Turn = true; // Skift til spiller 1
                }
            }
        }
    }

    public static int rollDie() {
        return (int) (Math.random() * 6 + 1);
    }
    //Retunere et tal imellem 1 og 6

    private static void updateStatistics() {
        rollCount++;
    }
}
