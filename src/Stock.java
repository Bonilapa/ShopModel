import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/*
 * Class for stock entity.
 * Stock stores a list of appropriate goods
 * according to its category.
 */
public class Stock {

    private Category stockCategory;
    private List<Pair> listOfPairs;


    /*
     * Class constructor with category initialization
     */
    public Stock(Category category) {
        this.stockCategory = category;
        this.listOfPairs = new ArrayList<>();
    }


    /*
     * Stock category getter
     */
    public Category getCategory() {

        return stockCategory;
    }


    /*
     * Stock category setter
     */
    public void setCategory(Category category) {

        this.stockCategory = category;
    }


    /*
     * Stock list of pairs inventory - amount getter
     */
    public List<Pair> getListOfPairs() {

        return listOfPairs;
    }


    /*
     * Method adds an inventory - amount pair
     * to the list of the stock.
     *
     * Method with value parameter, that
     * can be taken as an integer value of
     * expiration date or a clothes size.
     *
     * 0 .. successful
     * -1 .. category not found
     * -2 .. does not match with the stock category
     */
    public int add(Category inventoryCategory, String name, double price, int value, int amount) {

        if (inventoryCategory == stockCategory) {
            if (inventoryCategory == Category.Clothes) {
                listOfPairs.add(new Pair(new Clothes(name, price, value), amount));
                return 0;
            } else if (inventoryCategory == Category.Food) {
                listOfPairs.add(new Pair(new Food(name, price, new Date(value)), amount));
                return 0;
            } else if (inventoryCategory == Category.Pharmacy) {
                listOfPairs.add(new Pair(new Pharmacy(name, price, new Date(value)), amount));
                return 0;
            } else {
                return -1;
            }
        } else {
            return -2;
        }
    }

    /*
     * Method adds an inventory - amount pair
     * to the list of the stock.
     *
     * Method with date parameter, that
     * can be taken as expiration date only.
     *
     * 0 .. successful
     * -1 .. category not found
     * -2 .. does not match with the stock category
     */
    public int add(Category inventoryCategory, String name, double price, Date date, int amount) {

        if (inventoryCategory == stockCategory) {
            if (inventoryCategory == Category.Food) {
                listOfPairs.add(new Pair(new Food(name, price, date), amount));
                return 0;
            } else if (inventoryCategory == Category.Pharmacy) {
                listOfPairs.add(new Pair(new Pharmacy(name, price, date), amount));
                return 0;
            } else {
                return -1;
            }
        } else {
            return -2;
        }
    }

    /*
     * Method finds an inventory - amount pair
     * in the list of the stock.
     *
     * Method with value parameter, that
     * can be taken as an integer value of
     * expiration date or a clothes size.
     *
     * Pair .. successful
     * null .. error. could not find an
     * appropriate pair
     */
    public Pair takeFrom(Category inventoryCategory, String name, double price, int value, int amount) {

        if (inventoryCategory == stockCategory) {

            if (inventoryCategory == Category.Clothes) {
                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {
                    Pair pair = iterator.next();
                    Clothes pairClothes = (Clothes) pair.getInventory();

                    if ((pairClothes.getName().equals(name))
                            && (pairClothes.getPrice() == price)
                            && (pairClothes.getSize() == value)
                            && (pair.getAmount() >= amount)) {

                        pair.setAmount(pair.getAmount() - amount);
                        return new Pair(new Clothes(name, price, value), amount); // there is clothes of exact size and enough amount
                    }
                }

                System.out.println("No matches of goods, price or amount");
                return null;
            } else {

                System.out.println("No matches with categories");
                return null;
            }
        } else {

            System.out.println("No match with category of the stock");
            return null;
        }
    }

    /*
     * Method finds an inventory - amount pair
     * in the list of the stock.
     *
     * Overloaded method without special parameter.
     * Expirable entities are compared with a
     * current date themselves and clothes can be
     * ordered without specifying a size.
     *
     * Pair .. successful
     * null .. error. could not find an
     * appropriate pair
     */
    public Pair takeFrom(Category inventoryCategory, String name, double price, int amount) {

        if (inventoryCategory == stockCategory) {

            if (inventoryCategory == Category.Clothes) {
                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {
                    Pair pair = iterator.next();

                    Clothes pairClothes = (Clothes) pair.getInventory();

                    if ((pairClothes.getName().equals(name))
                            && (pairClothes.getPrice() == price)
                            && (pair.getAmount() >= amount)){

                        pair.setAmount(pair.getAmount() - amount);
                        return new Pair(new Clothes(name,price, pairClothes.getSize()), amount); // there is clothes of exact size and enough amount
                    }
                }
                System.out.println("No matches of goods, price or amount");
                return null;
            } else if (inventoryCategory == Category.Food) {

                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {

                    Pair pair = iterator.next();
                    Food pairFood = (Food) pair.getInventory();

                    if ((pairFood.getName().equals(name))
                            && (pairFood.getPrice() == price)
                            && (pairFood.checkExpirationDate(new Date()))
                            && (pair.getAmount() >= amount)) {

                        pair.setAmount(pair.getAmount() - amount);
                        return new Pair(new Food(name, price, pairFood.getExpirationDate()), amount); // there is food with unexpired expiration date and enough amount
                    }
                }
                System.out.println("No matches of goods, price or amount");
                return null;
            } else if (inventoryCategory == Category.Pharmacy) {

                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {

                    Pair pair = iterator.next();
                    Pharmacy pairPharmacy = (Pharmacy) pair.getInventory();
                    if ((pairPharmacy.getName().equals(name))
                            && (pairPharmacy.getPrice() == price)
                            && (pairPharmacy.checkExpirationDate(new Date()))
                            && (pair.getAmount() >= amount)){

                        pair.setAmount(pair.getAmount() - amount);
                        return new Pair(new Pharmacy(name, price, pairPharmacy.getExpirationDate()), amount); // there is pharmacy with unexpired expiration date and enough amount
                    }
                }

                System.out.println("No matches of goods, price or amount");
                return null;
            } else {
                System.out.println("No matches with categories");
                return null;   // no matches
            }
        } else {

            System.out.println("No match with category of the stock");
            return null; // not match with stock category
        }
    }

    /*
     * Method removes an exact inventory - amount pair
     * from the list of the stock.
     *
     * Method with value parameter, that
     * can be taken as an integer value of
     * expiration date or a clothes size.
     *
     * 0 .. successful
     * -1 .. exact matching with goods not found
     * -2 .. matching with category not found
     * -3 .. does not match to the stock category
     */
    public int remove(Category inventoryCategory, String name, double price, int value, int amount) {

        if (inventoryCategory == stockCategory) {

            if (inventoryCategory == Category.Clothes) {
                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {
                    Pair pair = iterator.next();
                    Clothes pairClothes = (Clothes) pair.getInventory();
                    if ((pairClothes.getName().equals(name))
                            && (pairClothes.getPrice() == price)
                            && (pairClothes.getSize() == value)
                            && (pair.getAmount() == amount)) {

                        listOfPairs.remove(pair);
                        System.out.println("deleted");
                        return 0;
                    }
                }

                System.out.println("No matches of goods, price or amount");
                return -1;

            } else if (inventoryCategory == Category.Food) {
                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {
                    Pair pair = iterator.next();
                    Food pairFood = (Food) pair.getInventory();

                    if ((pairFood.getName().equals(name))
                            && (pairFood.getPrice() == price)
                            && (pairFood.getExpirationDate() == new Date(value))
                            && (pair.getAmount() == amount)) {

                        listOfPairs.remove(pair);
                        System.out.println("deleted");
                        return 0;
                    }
                }

                System.out.println("No matches of goods, price or amount");
                return -1;
            } else if (inventoryCategory == Category.Pharmacy) {
                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {
                    Pair pair = iterator.next();
                    Pharmacy pairPharmacy = (Pharmacy) pair.getInventory();

                    if ((pairPharmacy.getName().equals(name))
                            && (pairPharmacy.getPrice() == price)
                            && (pairPharmacy.getExpirationDate() == new Date(value))
                            && (pair.getAmount() == amount)) {

                        listOfPairs.remove(pair);
                        System.out.println("deleted");
                        return 0;
                    }
                }

                System.out.println("No matches of goods, price or amount");
                return -1;
            } else {

                System.out.println("No matches with categories");
                return -2;   // no matches
            }
        } else {

            System.out.println("No match with category of the stock");
            return -3; // not match with stock category
        }
    }


    /*
     * Method removes an exact inventory - amount pair
     * from the list of the stock.
     *
     * Method with date parameter, that
     * can be taken as an expiration date only.
     *
     * 0 .. successful
     * -1 .. exact matching with goods not found
     * -2 .. matching with category not found
     * -3 .. does not match to the stock category
     */
    public int remove(Category inventoryCategory, String name, double price, Date date, int amount) {

        if (inventoryCategory == stockCategory) {

            if (inventoryCategory == Category.Food) {
                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {
                    Pair pair = iterator.next();
                    Food pairFood = (Food) pair.getInventory();

                    if ((pairFood.getName().equals(name))
                            && (pairFood.getPrice() == price)
                            && (pairFood.getExpirationDate() == date)
                            && (pair.getAmount() == amount)) {

                        listOfPairs.remove(pair);
                        System.out.println("deleted");
                        return 0;
                    }
                }

                System.out.println("No matches of goods, price or amount");
                return -1;
            } else if (inventoryCategory == Category.Pharmacy) {
                for (Iterator<Pair> iterator = listOfPairs.iterator(); iterator.hasNext(); ) {
                    Pair pair = iterator.next();
                    Pharmacy pairPharmacy = (Pharmacy) pair.getInventory();

                    if ((pairPharmacy.getName().equals(name))
                            && (pairPharmacy.getPrice() == price)
                            && (pairPharmacy.getExpirationDate() == date)
                            && (pair.getAmount() == amount)) {

                        listOfPairs.remove(pair);
                        System.out.println("deleted");
                        return 0;
                    }
                }

                System.out.println("No matches of goods, price or amount");
                return -1;
            } else {

                System.out.println("No matches with categories");
                return -2;   // no matches
            }
        } else {

            System.out.println("No match with category of the stock");
            return -3; // not match with stock category
        }
    }
}