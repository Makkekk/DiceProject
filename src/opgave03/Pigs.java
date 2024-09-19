package opgave03;

import java.util.Scanner;

public class Pigs {
    public static int Winning_score = 100; //Det man skal ramme for at vinde


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

    public static void playPig(int rollDie) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = Scanner.nextLine();

        while (!answer.equals("nej")) {
            System.out.println("Du rullede: " + rollDie());



            System.out.println();

        boolean isPlayer1Turn = true;
        int player1_Score = 0;
        int player2_Score = 0;

        while (true) {
            if (isPlayer1Turn) {
                System.out.println("Spiller 1's tur");
                player1_Score = player1_Score;
                if (player1_Score == Winning_score) {
                    System.out.println("Spiller 1 vinder med 100 point. ");
                    return;
                }
            } else {
                System.out.println("Spiller 2's tur");
                player2_Score = player2_Score;
                if (player2_Score == Winning_score) {
                    System.out.println("Spiller 2 vinder med 100 point");
                    return;

                }
            }
        }

    }

    public static int rollDie() {
        return (int)(Math.random() * 6 + 1); //Retunere et tal imellem 1 og 6
    }
}
