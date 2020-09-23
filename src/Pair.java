public class Pair {

    private Inventory inventory;
    private int amount;

    public Pair(Inventory inventory, int amount) {

        this.inventory = inventory;
        this.amount = amount;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
