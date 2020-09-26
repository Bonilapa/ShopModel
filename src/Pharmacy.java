import java.util.Date;

/*
 * Class with Expirable behavior.
 * have no new or different behavior.
 */
public class Pharmacy extends Expirable{

    /*
     * Class constructor with full initialization
     */
    public Pharmacy(String name, double price, Date expirationDate) {
        super(name, price, expirationDate);
    }
}
