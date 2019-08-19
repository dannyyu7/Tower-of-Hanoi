import java.util.Scanner;

public class TowerOfHanoi {

    private final Pole[] poles = new Pole[3];
    private final int maxNumberOfDisks;

    public TowerOfHanoi(int maxNumberOfDisks) {
        this.maxNumberOfDisks = maxNumberOfDisks;
        createPoles(maxNumberOfDisks);
        initializeGame();
        printGame();
    }

    public void createPoles(int maxNumberOfDisks) {
        poles[0] = new Pole(maxNumberOfDisks);
        poles[1] = new Pole(maxNumberOfDisks);
        poles[2] = new Pole(maxNumberOfDisks);
    }

    public void initializeGame() {
        for (int i = 0; i < maxNumberOfDisks; i++) {
            Disk disk = new Disk();
            disk.setSize((maxNumberOfDisks * 2 + 1) - 2 * i);
            poles[0].addDisk(disk);
        }

    }

    public void moveDisk(int from, int to) {
        boolean move = poles[to - 1].addDisk(poles[from - 1].peekTopDisk());
        if (move) {
            System.out.println("Disk moved.");
            poles[from - 1].removeDisk();
        }
    }

    public Pole[] getPoles() {
        return poles;
    }

    public void printGame() {
        StringBuilder sb = new StringBuilder();
        Scanner tower1 = new Scanner(poles[0].toString());
        Scanner tower2 = new Scanner(poles[1].toString());
        Scanner tower3 = new Scanner(poles[2].toString());
        while (tower1.hasNextLine()) {
            sb.append(tower1.nextLine()).append(tower2.nextLine()).append(tower3.nextLine());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
