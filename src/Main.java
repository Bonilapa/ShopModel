import java.sql.DataTruncation;
import java.sql.Time;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        Date temp = new Date();
        Date temp2 = new Date(temp.getTime() - 461000);
        //d1.setTime(d1.getTime()+60000);

        Shop shop = new Shop("New York store", "Manholland Drive 502");
        shop.addInventoryToStock(Category.Clothes, "Shirt", 1000, 52, 3);
//        shop.addInventoryToStock(Category.Food, "Banana", 50.40, new Date(temp.getTime() + 4000), 5);
//        shop.addInventoryToStock(Category.Food, "Banana", 50.40, new Date(temp.getTime()), 2);
        shop.addInventoryToStock(Category.Food, "Banana", 50.40, temp2, 5);
        shop.addInventoryToStock(Category.Pharmacy, "Nergovirin", 19299, new Date(temp.getTime() + 4000), 2);
        shop.addInventoryToStock(Category.Clothes, "Pants", 10, 38, 90);
        for (Stock stock:
                shop.getInventoryStocks()) {
            for (Pair pair:
                    stock.getListOfPairs()) {
                System.out.println(pair.getInventory().getName());
                System.out.println(pair.getInventory().getPrice());
                System.out.println(pair.getAmount());
            }
        }
        shop.removeInventoryFromStocks(Category.Clothes, "Shirt", 1000, 52, 3);

        shop.removeInventoryFromStocks(Category.Food, "Banana", 50.40, temp2, 5);

        for (Stock stock:
                shop.getInventoryStocks()) {
            for (Pair pair:
                    stock.getListOfPairs()) {
                System.out.println(pair.getInventory().getName());
                System.out.println(pair.getInventory().getPrice());
                if(pair.getInventory() instanceof Expirable)
                    System.out.println(((Expirable)(pair.getInventory())).getExpirationDate());
                System.out.println(pair.getAmount());
            }
        }

        shop.addConsumer("kolya", 29, 0);
        shop.addConsumer("pavel", 79, 0);
        shop.addConsumer("dosya", 9, 0);
        shop.addConsumer("epifstafii", 189, 0);
        shop.addConsumer("semen", -1, 0);

        shop.addCustomer("ziliboba", 15, 2);
        System.out.println(shop.getConsumer(2).createOrder(Category.Pharmacy, "Nergovirin", 19299, 2, "LubovIvanovna", 56, 2));

    }
}
