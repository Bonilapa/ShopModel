/*
 * Class of Clothes entity with its behavior
 */
public class Clothes extends Inventory{

    protected int size;

    /*
     * Size getter
     */
    public int getSize() {
        return size;
    }

    /*
     * Class constructor
     */
    public Clothes(String name, double price, int size) {
        super(name, price);
        this.size = size;
    }
}