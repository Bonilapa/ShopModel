import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Shop {

    private String name;
    private String location;
    private List<Consumer> listOfConsumers;
    private List<Customer> listOfCustomers;
    private List<Stock> inventoryStocks;
    private List<Order> listOfOrders;

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

    public List<Stock> getInventoryStocks() {
        return inventoryStocks;
    }

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
    public int addOrder(Order order){
        if(order != null){
            listOfOrders.add(order);
            return 0;
        }else{
            return -1;
        }
    }

    public int removeInventoryFromStocks(Category category, String name, double price, int value, int amount){

        for(Iterator iterator = inventoryStocks.iterator(); iterator.hasNext();){
            Stock stock = ((Stock) iterator.next());
            if (category == stock.getCategory()) {
                return stock.remove(category, name, price, value, amount);
            }
        }
        return -1;
    }

    public int removeInventoryFromStocks(Category category, String name, double price, Date date, int amount){

        for(Iterator iterator = inventoryStocks.iterator(); iterator.hasNext();){
            Stock stock = ((Stock) iterator.next());
            if (category == stock.getCategory()) {
                return stock.remove(category, name, price, date, amount);
            }
        }
        return -1;
    }
    public Consumer getConsumer(int i){
        return listOfConsumers.get(i);
    }
}
