import java.sql.Time;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws InterruptedException{

        Date temp = new Date();
        temp.setTime(temp.getTime() + 5000);
        Expirable ex = new Expirable("Gomel", 80, temp);
        Thread.sleep(6000);
        System.out.println(ex.exripationDateExpired());
        //d1.setTime(d1.getTime()+60000);
    }
}
