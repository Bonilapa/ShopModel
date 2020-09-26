import java.util.Date;

public class Order {

    private Date date;
    private Inventory inventory;
    private Consumer consumer;
    private Customer customer;
    private double price;
    private int Amount;

    public Order(Date date, Inventory inventory, Consumer consumer, Customer customer, double price, int amount) {

        this.date = date;
        this.inventory = inventory;
        this.consumer = consumer;
        this.customer = customer;
        this.price = price;
        Amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}