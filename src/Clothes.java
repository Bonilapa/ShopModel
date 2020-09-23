public class Clothes extends Inventory{

    protected int size;

    public Clothes(String name, double price, int size) {
        super(name, price);
        this.size = size;
    }
}
