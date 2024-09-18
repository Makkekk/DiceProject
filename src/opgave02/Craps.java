import java.util.Scanner;
import java.util.Random;


public class Craps {
    public static void main(String[] args) {
        displayRules();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tryk enter for at starte spillet");
        scanner.nextLine(); // Vemt på tastetryk.
        playCraps(); //Start spillet

    }

    public static void displayRules() {
        System.out.println("Velkommen til Craps!");
        System.out.println("Spillets regler:");
        System.out.println("1. Du kaster to terninger.");
        System.out.println("2. Hvis det første kast er 7 eller 11, vinder du med det samme.");
        System.out.println("3. Hvis det første kast er 2, 3 eller 12, taber du med det samme.");
        System.out.println("4. Hvis du kaster 4, 5, 6, 8, 9 eller 10, bliver det dit 'point'.");
        System.out.println("5. Du fortsætter derefter med at kaste terningerne, indtil du kaster dit 'point' igen og vinder, eller du kaster en 7 og taber.");
        System.out.println();
    }

    public static void playCraps() {  //Metoden/Reglerne til at starte spillet
        Random random = new Random();
        int die1 = rollDie(random); //Kast første terning.
        int die2 = rollDie(random); //Kast anden terning.
        int sum = die1 + die2; // Beregn summen

        System.out.println("Summen af kastet " + sum);

        //Vind eller tab regler efter første kast
        if (sum == 7 || sum == 11) {
            System.out.println("Du vandt");
        } else if (sum == 2 || sum == 3 || sum == 12) {
            System.out.println("Du tabte");
        } else {
            System.out.println("Points " + sum);

            boolean resultat  = rollforPoint(sum, random);
            if (resultat) {
                System.out.println("Du vandt!");
            } else {
                System.out.println("Du tabte!");
            }

        }

    }

    //Metode til at kaste terninger indtil point eller 7 bliver kastet
    public static boolean rollforPoint(int point, Random random) {
        int sum = 0;

        //Kast terningen indtil pointet rammes eller 7
        while (sum != 7 && sum != point) {
            int die1 = rollDie(random);
            int die2 = rollDie(random);
            sum = die1 + die2;
            System.out.println("Du kastede " + sum);
        }
        return sum == point; // Retunerer true hvis point blev kastes
    }

    //metode til få terningen kastet
    public static int rollDie(Random random) {
        return random.nextInt(6) + 1; //returner et tal imellem 1 og 6
    }

}
