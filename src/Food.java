import java.util.Date;

/*
 * Class with Expirable behavior.
 * have no new or different behavior.
 */
public class Food extends Expirable{

    /*
     * Class constructor with full initialization
     */
    public Food(String name, double price, Date expirationDate) {
        super(name, price, expirationDate);
    }
}