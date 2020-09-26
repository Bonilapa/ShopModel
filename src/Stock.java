import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Stock {

    private Category stockCategory;
    private List<Pair> listOfPairs;

    public Stock(Category category) {
        this.stockCategory = category;
        this.listOfPairs = new ArrayList<>();
    }

    public Category getCategory() {

        return stockCategory;
    }

    public void setCategory(Category category) {

        this.stockCategory = category;
    }

    public List<Pair> getListOfPairs() {

        return listOfPairs;
    }

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
            return -2; // does not match with the stock category
        }
    }

    public int add(Category inventoryCategory, String name, double price, Date date, int amount) {

        if (inventoryCategory == stockCategory) {
            if (inventoryCategory == Category.Food) {
                listOfPairs.add(new Pair(new Food(name, price, date), amount));
                return 0;
            } else if (inventoryCategory == Category.Pharmacy) {
                listOfPairs.add(new Pair(new Pharmacy(name, price, date), amount));
                return 0;
            } else {
                return -1; // no match with known category
            }
        } else {
            return -2; // does not match with the stock category
        }
    }

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
                return null;   // no matches
            }
        } else {

            System.out.println("No match with category of the stock");
            return null; // not match with stock category
        }
    }


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