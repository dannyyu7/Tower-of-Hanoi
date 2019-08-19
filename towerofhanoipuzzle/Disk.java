public class Disk {
    private int size;
    private char shape = '*';

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(shape);
        }
        return sb.toString();
    }
}
