public class Senior implements Comparable<Senior> {

    private final int ID;
    private int numberOfCoins;

    public Senior(int ID, int numberOfCoins) {
        this.ID = ID;
        this.numberOfCoins = numberOfCoins;
    }

    @Override
    public int compareTo(Senior o) {
        int cmp = this.getNumberOfCoins() - o.getNumberOfCoins();
        if (cmp != 0) {
            return cmp;
        }
        return o.getID() - this.getID();
    }

    public int getID() {
        return ID;
    }

    public int getNumberOfCoins() {
        return numberOfCoins;
    }

    public void setNumberOfCoins(int numberOfCoins) {
        this.numberOfCoins = numberOfCoins;
    }

    @Override
    public String toString() {
        return "Senior[ID=" + ID + ", numberOfCoins=" + numberOfCoins + ']';
    }
}
