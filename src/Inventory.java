/*
 * Base class for Food, Pharmacy and Clothes classes.
 * Contains basic common behavior.
 */
public class Inventory {

    protected String name;
    protected double price;

    /*
     * Disabled default class constructor.
     * No ability to create empty inventory entity.
     */
    private Inventory(){

    }

    public Inventory(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /*
     * Name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /*
     * Price setter
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /*
     * Name getter
     */
    public String getName() {
        return name;
    }

    /*
     * Price getter
     */
    public double getPrice() {
        return price;
    }
}