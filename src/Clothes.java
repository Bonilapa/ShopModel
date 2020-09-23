public class Clothes extends Inventory{

    private int size;

    public Clothes(String name, double price, int size) {
        super(name, price);
        this.size = size;
    }
}
