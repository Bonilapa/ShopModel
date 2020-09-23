import java.util.ArrayList;
import java.util.List;

public class Stock {

    private Category category;
    private List<Pair> listOfPairs;

    public Stock(Category category) {
        this.category = category;
        this.listOfPairs = new ArrayList<>();
    }

    public Category getCategory() {

        return category;
    }

    public void setCategory(Category category) {

        this.category = category;
    }

    public List<Pair> getListOfPairs() {

        return listOfPairs;
    }

    public int add(List<Pair> listOfPairs) {
        this.listOfPairs = listOfPairs;
        //TODO
        return 0;
    }

    public int takeFrom() {
        //TODO

        return 0;
    }
}
