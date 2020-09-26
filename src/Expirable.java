import java.util.Date;

/*
 * Class parent for Food and Pharmacy classes
 * since their behavior is the same.
 * extends Inventory behavior.
 */
public class Expirable extends Inventory{

    protected Date expirationDate;

    /*
     * Class constructor with full initialization
     */
    public Expirable(String name, double price, Date expirationDate) {

        super(name, price);
        this.expirationDate = expirationDate;
    }

    /*
     * Expiration date getter
     */
    public Date getExpirationDate() {

        return expirationDate;
    }

    /*
     * Method compares product expiration date with
     * a given. Typically, given date is a current date.
     */
    protected boolean checkExpirationDate(Date date){

        return expirationDate.compareTo(date) >= 0;
    }
}