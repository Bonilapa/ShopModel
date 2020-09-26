import java.util.Date;

/*
 * Class of Order Entity.
 * have no other behavior than get() and set()
 */
public class Order {

    private Date date;
    private Inventory inventory;
    private Consumer consumer;
    private Customer customer;
    private double price;
    private int Amount;

    /*
     * Class constructor with full initialization.
     * Entity can be created only with all fields.
     */
    public Order(Date date, Inventory inventory, Consumer consumer, Customer customer, double price, int amount) {

        this.date = date;
        this.inventory = inventory;
        this.consumer = consumer;
        this.customer = customer;
        this.price = price;
        Amount = amount;
    }

    /*
     * Disabled default constructor.
     * Entity can be created only with all fields.
     */
    private Order(){}

    /*
     * Order date getter
     */
    public Date getDate() {
        return date;
    }

    /*
     * Order date setter
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /*
     * Order inventory getter
     */
    public Inventory getInventory() {
        return inventory;
    }

    /*
     * Order inventory setter
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    /*
     * Order consumer getter
     */
    public Consumer getConsumer() {
        return consumer;
    }

    /*
     * Order consumer setter
     */
    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    /*
     * Order customer getter
     */
    public Customer getCustomer() {
        return customer;
    }

    /*
     * Order customer setter
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /*
     * Order price getter
     */
    public double getPrice() {
        return price;
    }

    /*
     * Order price setter
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /*
     * Order inventory amount getter
     */
    public int getAmount() {
        return Amount;
    }

    /*
     * Order inventory amount setter
     */
    public void setAmount(int amount) {
        Amount = amount;
    }
}