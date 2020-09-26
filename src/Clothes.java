/*
 * Class of Close entity with its behavior
 */
public class Clothes extends Inventory{

    protected int size;

    public int getSize() {
        return size;
    }

    public Clothes(String name, double price, int size) {
        super(name, price);
        this.size = size;
    }
}
