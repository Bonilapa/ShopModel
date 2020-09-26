import java.util.Date;

public class Expirable extends Inventory{

    protected Date expirationDate;

    public Expirable(String name, double price, Date expirationDate) {

        super(name, price);
        this.expirationDate = expirationDate;
    }

    public Date getExpirationDate() {

        return expirationDate;
    }

    protected boolean checkExpirationDate(Date date){

        return expirationDate.compareTo(date) >= 0;
    }
}
