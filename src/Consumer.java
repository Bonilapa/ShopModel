import java.util.Date;
import java.util.Iterator;

/*
 * Class of Consumer entity with its behavior
 * that extends behavior of class Person
 */
public class Consumer extends Person {

    private Shop shop;

    /*
     * shop getter
     */
    public Shop getShop() {
        return shop;
    }

    /*
     * Shop setter
     */
    public void setShop(Shop shop) {
        this.shop = shop;
    }

    /*
     * Class constructor with only name initiation
     */
    public Consumer(String name) {
        super(name);
    }

    /*
     * Class constructor with full initialization
     */
    public Consumer(String name, int age, int gender, Shop shop) {
        super(name, age, gender);
        this.shop = shop;
    }

    /*
     * Method creates Order Entity using given parameters
     * and adds it to list of orders in class Shop.
     *
     * version with Value parameter.
     * this parameter can be taken as Clothes size,
     * or Food or Pharmacy expiration date as integer number.
     */
    public int createOrder(Category category, String name, double price, int value, int amount, String customerName, int customerAge, int customerGender) {

        shop.addCustomer(customerName, customerAge, customerGender);
        for (Iterator iterator = shop.getInventoryStocks().iterator(); iterator.hasNext(); ) {
            Stock stock = (Stock) iterator.next();  // why iterator does not see public methods...

            if (category == stock.getCategory()) {

                if (category == Category.Clothes) {
                    Pair pair = stock.takeFrom(category, name, price, value, amount);
                    if (pair != null) {
                        shop.addOrder( new Order(new Date(), new Clothes(name, price, value), this, new Customer(customerName, customerAge, customerGender), price, amount));
                        return 0;
                    }else{
                        System.out.println("Order not created");
                        return -1;
                    }
                } else if (category == Category.Food) {
                    Pair pair = stock.takeFrom(category, name, price, value, amount);
                    if (pair != null) {
                        shop.addOrder(new Order(new Date(), new Food(name, price, new Date(value)), this, new Customer(customerName, customerAge, customerGender), price, amount));
                        return 0;
                    }else{
                        System.out.println("Order not created");
                        return -1;
                    }
                } else if (category == Category.Pharmacy) {
                    Pair pair = stock.takeFrom(category, name, price, amount);
                    if (pair != null) {
                        shop.addOrder(new Order(new Date(), new Pharmacy(name, price, new Date(value)), this, new Customer(customerName, customerAge, customerGender), price, amount));
                        return 0;
                    }else{
                        System.out.println("Order not created");
                        return -1;
                    }
                }
            }
        }
        System.out.println("No such stock category");
        return -2;
    }

    /*
     * Method creates Order Entity using given parameters
     * and adds it to list of orders in class Shop.
     *
     * Overloaded version without Value parameter.
     * Order can be created only for Food or Pharmacy
     */
    public int createOrder(Category category, String name, double price, int amount, String customerName, int customerAge, int customerGender) {

        shop.addCustomer(customerName, customerAge, customerGender);
        for (Iterator iterator = shop.getInventoryStocks().iterator(); iterator.hasNext(); ) {
            Stock stock = (Stock) iterator.next();  // why iterator does not see public methods...

            if (category == stock.getCategory()) {

                if (category == Category.Food) {
                    System.out.println("food");
                    Pair pair = stock.takeFrom(category, name, price, amount);
                    if (pair != null) {
                        shop.addOrder(new Order(new Date(), new Food(name, price, ((Food)pair.getInventory()).getExpirationDate()), this, new Customer(customerName, customerAge, customerGender), price, amount));
                        return 0;
                    }else{
                        System.out.println("Order not created");
                        return -1;
                    }
                } else if (category == Category.Pharmacy) {
                    System.out.println("pharmacy");
                    Pair pair = stock.takeFrom(category, name, price, amount);
                    if (pair != null) {
                        shop.addOrder(new Order(new Date(), new Pharmacy(name, price, ((Pharmacy)pair.getInventory()).getExpirationDate()), this, new Customer(customerName, customerAge, customerGender), price, amount));
                        return 0;
                    }else{
                        System.out.println("Order not created");
                        return -1;
                    }
                }
            }
        }
        System.out.println("No such stock category");
        return -2;
    }
}