import java.util.Date;
import java.util.Iterator;

public class Consumer extends Person {

    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Consumer(String name) {
        super(name);
    }

    public Consumer(String name, int age, int gender, Shop shop) {
        super(name, age, gender);
        this.shop = shop;
    }

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
