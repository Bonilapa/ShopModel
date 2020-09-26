import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/*
 * Shop entity class.
 * Contains lists of customers, consumers, orders and stocks
 * Bthavior of shop manager.
 */
public class Shop {

    private String name;
    private String location;
    private List<Consumer> listOfConsumers;
    private List<Customer> listOfCustomers;
    private List<Stock> inventoryStocks;
    private List<Order> listOfOrders;

    /*
     * Class constructor with nesessary initialization.
     * Lists are created here.
     */
    public Shop(String name, String location) {

        this.name = name;
        this.location = location;
        listOfCustomers = new ArrayList<>();
        listOfOrders = new ArrayList<>();
        inventoryStocks = new ArrayList<>();
        inventoryStocks.add(new Stock(Category.Clothes));
        inventoryStocks.add(new Stock(Category.Food));
        inventoryStocks.add(new Stock(Category.Pharmacy));
        listOfConsumers = new ArrayList<>();
    }

    /*
     * Inventory stocks list getter
     */
    public List<Stock> getInventoryStocks() {
        return inventoryStocks;
    }

    /*
     * Method creates a consumer entity
     * and adds it to the consumers list
     *
     * 0 .. successful
     * -1 .. creations or adding error
     */
    public int addConsumer(String name, int age, int gender){

        Consumer consumer = new Consumer(name, age, gender, this);
        if(consumer != null) {
            listOfConsumers.add(consumer);
            return 0;
        }else {
            System.out.println("Consumer not added");
            return -1;
        }
    }

    /*
     * Method creates a customer entity
     * and adds it to the customers list
     *
     * 0 .. successful
     * -1 .. creations or adding error
     */
    public int addCustomer(String name, int age, int gender){
        Customer customer = new Customer(name, age, gender);
        if(customer != null) {
            listOfCustomers.add(customer);
            return 0;
        } else {
            System.out.println("Customer not added");
            return -1;
        }
    }


    /*
     * Method creates a inventory entity,
     * chooses appropriate stock,
     * creates Pair entity
     * and adds it to the in a stock inventory list
     *
     * Method with value parameter, that
     * can be taken as clothes size or
     * integer value of expiration date.
     *
     * 0 .. successful
     * -1 .. creations or adding error
     */
    public int addInventoryToStock(Category category, String name, double price, int value, int amount){

        for(Iterator iterator = inventoryStocks.iterator(); iterator.hasNext();){
            Stock stock = (Stock) iterator.next();  // why iterator does not see public methods...

            if (category == stock.getCategory()) {
                stock.add(category, name, price, value, amount);
                return 0;
            }
        }
        return -1;
    }


    /*
     * Method creates a inventory entity,
     * chooses appropriate stock,
     * creates Pair entity
     * and adds it to the in a stock inventory list
     *
     * Overloaded method with date parameter,
     * except for integer value, that
     * can be taken as expiration date only.
     *
     * 0 .. successful
     * -1 .. creations or adding error
     */
    public int addInventoryToStock(Category category, String name, double price, Date date, int amount){

        for(Iterator iterator = inventoryStocks.iterator(); iterator.hasNext();){
            Stock stock = (Stock) iterator.next();  // why iterator does not see public methods...

            if (category == stock.getCategory()) {
                stock.add(category, name, price, date, amount);
                return 0;
            }
        }
        return -1;
    }


    /*
     * Method adds order entity to the
     * list of orders
     *
     * 0 .. successful
     * -1 .. adding error
     */
    public int addOrder(Order order){
        if(order != null){
            listOfOrders.add(order);
            return 0;
        }else{
            return -1;
        }
    }


    /*
     * Method removes an inventory - amount pair
     * from the list of appropriate stock.
     *
     * Method with value parameter, that
     * can be taken as an integer value of
     * expiration date or a clothes size.
     *
     * 0 .. successful
     * -1 .. remove error
     */
    public int removeInventoryFromStocks(Category category, String name, double price, int value, int amount){

        for(Iterator iterator = inventoryStocks.iterator(); iterator.hasNext();){
            Stock stock = ((Stock) iterator.next());
            if (category == stock.getCategory()) {
                return stock.remove(category, name, price, value, amount);
            }
        }
        return -1;
    }


    /*
     * Method removes an inventory - amount pair
     * from the list of appropriate stock.
     *
     * Method with date parameter,
     * except for integer value, that
     * can be taken as expiration date only.
     *
     * 0 .. successful
     * -1 .. remove error
     */
    public int removeInventoryFromStocks(Category category, String name, double price, Date date, int amount){

        for(Iterator iterator = inventoryStocks.iterator(); iterator.hasNext();){
            Stock stock = ((Stock) iterator.next());
            if (category == stock.getCategory()) {
                return stock.remove(category, name, price, date, amount);
            }
        }
        return -1;
    }


    /*
     * Getter of i-th consumer from the list
     */
    public Consumer getConsumer(int i){
        return listOfConsumers.get(i);
    }
}