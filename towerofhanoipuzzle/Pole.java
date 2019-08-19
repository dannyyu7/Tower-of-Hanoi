public class Pole {

    private final int maxDiskCapacity;
    private final String poleChar = "|";
    private int currentNumberOfDisks;
    private final Disk[] disks;

    private final int poleWidth;
    private final int poleHeight;

    public Pole(int maxDiskCapacity) {
        this.maxDiskCapacity = maxDiskCapacity;
        currentNumberOfDisks = 0;
        disks = new Disk[maxDiskCapacity];
        poleHeight = maxDiskCapacity + 1;
        int i = 0, n = 1;
        while (i < maxDiskCapacity + 1) {
            n += 2;
            i++;
        }
        poleWidth = n;
    }

    public Disk[] getDisks() {
        return disks;
    }

    public int getNumberOfDisks() {
        return currentNumberOfDisks;
    }

    public boolean addDisk(Disk disk) {
        if (currentNumberOfDisks == maxDiskCapacity) {
            System.out.println("Disk cannot be moved");
            return false;
        } else if (currentNumberOfDisks == 0) {
            disks[currentNumberOfDisks] = disk;
            currentNumberOfDisks++;
            return true;
        } else if (disk.getSize() < disks[currentNumberOfDisks - 1].getSize()) {
            disks[currentNumberOfDisks] = disk;
            currentNumberOfDisks++;
            return true;
        } else {
            System.out.println("Disk cannot be moved");
            return false;
        }
    }

    public Disk peekTopDisk() {
        if (currentNumberOfDisks == 0) {
            return null;
        } else {
            return disks[currentNumberOfDisks - 1];
        }
    }

    public void removeDisk() {
        disks[currentNumberOfDisks - 1] = null;
        currentNumberOfDisks--;
    }

    @Override
    public String toString() {
        StringBuilder poleState = new StringBuilder();
        int i = 0;
        while (i < (poleHeight - currentNumberOfDisks)) {
            poleState.append("\n").append(StringUtils.center(poleChar, poleWidth));
            i++;
        }

        i = currentNumberOfDisks - 1;
        while (i >= 0) {
            poleState.append("\n").append(StringUtils.center(disks[i].toString(), poleWidth));
            i--;
        }
        
        i = 0;
        StringBuilder base = new StringBuilder();
        while (i < poleWidth) {
            base.append('=');
            i++;
        }
        
        poleState.append("\n").append(base.toString());
        return poleState.toString();
    }

}
