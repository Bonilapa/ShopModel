/*
 * Class connects Inventory entity
 * to a its integer amount entity.
 * Without standard key - value notation
 */
public class Pair {

    private Inventory inventory;
    private int amount;

    /*
     * Pair constructor with full initialization
     */
    public Pair(Inventory inventory, int amount) {

        this.inventory = inventory;
        this.amount = amount;
    }

    /*
     * Pair inventory getter
     */
    public Inventory getInventory() {
        return inventory;
    }

    /*
     * Pair inventory setter
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /*
     * Pair amount getter
     */
    public int getAmount() {
        return amount;
    }

    /*
     * Pair amount setter
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
}