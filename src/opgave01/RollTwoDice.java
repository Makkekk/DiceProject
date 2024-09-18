package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int totalSum = 0; //Tilføjet statisk felt for at gemme summen af alle kast
    private static int sameEyesCount = 0; // Ny variabel til at holde styr på kast med samme øjne
    private static int maxEyes = 0; // Variabel til at gemme det største kast
    private static int[] eyeCount = new int [6]; //Array til at holde styr på antal af hver terningværdi

    public static void main(String[] args) {
        System.out.println("Velkommen til spillet, rul to terninger.");
        printRules ();
        System.out.println();

        playTwoDice();

        System.out.println();
        System.out.println("Tak for at spille, rul to terninger");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Regler for rul to terninger");
        System.out.println("Spilleren ruller to terninger, så længe man lyster.");
        System.out.println("=====================================================");
    }

     private static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rul to terninger? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            int sum = faces[0] + faces [1];

            System.out.println("Du rullede: " + faces[0] + " og " + faces[1]);
            System.out.println("Summen af kastet er: " + (faces[0] + faces[1]));
            System.out.println();

            //If sætning til at vise hvis begge terninger har samme antal øjne
            if (faces[0] == faces[1]) {
                System.out.println("Begge terninger viser det samme antal øjne");
            }

            updateStatistics(faces, sum);

            System.out.println("Rul to ternininger? ('ja/nej') ");
            answer = scanner.nextLine();
        }

        printStatistics();
    }
    private static int[] rollDice() {
        int die1 = (int) (Math.random() * 6 + 1);
        int die2 = (int) (Math.random() * 6 + 1);
        return new int[]{die1,die2}; // Retunere array med resultater for de to terninger
    }

    private static void updateStatistics(int[] faces, int sum) {
        rollCount++;
        totalSum += sum; // Opdatere den totale sum med summen af terningerne

        if (faces[0] == faces[1]) {
            sameEyesCount++; // Opdatere tælleren for kast med samme antal øjne.
        }
        if (sum > maxEyes) {
            maxEyes = sum;

        }

        // Opdaterere antallet af forekomster for hver værdi af 1-6.
        eyeCount[faces[0] - 1]++; // Tæller den første terning
        eyeCount[faces[1] - 1]++; // Tæller den anden terning.
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Antal rul:", rollCount);
        System.out.printf("%17s %4d\n", "Total sum:", totalSum); // Udskriver den totale sum
        System.out.printf("%17s %4d\n", "Antal ens:", sameEyesCount); // Udskriver antallet af kast med samme øjne
        System.out.printf("%17s %4d\n", "Største sum i ét kast:", maxEyes); // Udskriver det største kast

        //Udskriver antallet af forekomster imellem 1-6
        System.out.println("\nAntal af hver terningværdi:");
        for (int i = 0; i < eyeCount.length; i++) {
            System.out.printf("%17s %4d\n", i + 1, eyeCount[i]);
        }
    }
}
