import java.util.Scanner;

public class TowerOfHanoiPuzzle {

    private int minimumNumberOfMoves;
    private int currentNumberOfMoves = 0;
    private int numberOfDisks;

    public static void main(String[] args) {
        new TowerOfHanoiPuzzle();
    }

    private TowerOfHanoiPuzzle() {
        displayWelcomeMessage();
        numberOfDisks = getNumberOfDisks();
        TowerOfHanoi hanoi = new TowerOfHanoi(numberOfDisks);
        displayHowToPlayInstructions();
        playGame(hanoi);
    }

    public void displayWelcomeMessage() {
        System.out.println("Welcome to the Tower of Hanoi Game! \n 2019 Danny (Chen-Jung) Yu \n All rights reserved");
    }

    private int getNumberOfDisks() {
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("How many disks would you like to play with? (3-64)");

            String userDisks = keyboard.nextLine();
            try {
                numberOfDisks = Integer.parseInt(userDisks);
            } catch (Exception e) {
                continue;
            }

        } while (numberOfDisks<3 || numberOfDisks>64);
        double minMoves = Math.pow(numberOfDisks, 2) - 1;
        minimumNumberOfMoves = (int)Math.round(minMoves);
        return numberOfDisks;
    }

    public void displayHowToPlayInstructions() {
        
        System.out.println("The goal is to move all " + numberOfDisks
                + " disks from pole 1 to 3 \nThe least number of moves for "
                + numberOfDisks + " disks is " + minimumNumberOfMoves + "\n");
    }

    private boolean isGameOver(TowerOfHanoi hanoi) {
        Pole[] poles = hanoi.getPoles();
        int numOfDisks = poles[2].getNumberOfDisks();
        return numOfDisks == numberOfDisks;
    }

    private int[] getMoveRequest() {
        int[] move = new int[2];
        Scanner keyboard = new Scanner(System.in);
        do {
            System.out.println("Move disk from: ");
            String moveA = keyboard.nextLine();
            try {
                move[0] = Integer.parseInt(moveA);
            } catch (Exception e) {
                continue;
            }
        } while (move[0] < 1 || move[0] > 3);

        do {
            System.out.println("Move disk to: ");
            String moveB = keyboard.nextLine();
            try {
                move[1] = Integer.parseInt(moveB);
            } catch (Exception e) {
                continue;
            }
        } while (move[1] < 1 || move[1] > 3);

        return move;
    }

    private void playGame(TowerOfHanoi hanoi) {
        while (true) {
            currentNumberOfMoves++;
            int[] moveRequest = getMoveRequest();
            hanoi.moveDisk(moveRequest[0], moveRequest[1]);
            hanoi.printGame();
            if (isGameOver(hanoi)) {
                System.out.println("Congratulations");
                System.out.println("You finished in " + currentNumberOfMoves + " moves");
                System.exit(0);
            }
        }
    }

}
