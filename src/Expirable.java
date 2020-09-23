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

    public boolean exripationDateExpired(){

        return checkExpirationDate(new Date());
    }

    protected boolean checkExpirationDate(Date date){

        return date.compareTo(expirationDate) >= 0;
    }
}
