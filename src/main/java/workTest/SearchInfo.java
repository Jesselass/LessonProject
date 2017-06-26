package workTest;

/**
 * Created by Dell-SSD on 01.06.2017.
 */
public class SearchInfo {

    public String title;
    public int nullSearchValue;
    public int transitionsToPage;
    public int addToBasket;

    public String getTitle() {
        return title;
    }

    public int getNullSearchValue() {
        return nullSearchValue;
    }

    public int getTransitionsToPage() {
        return transitionsToPage;
    }

    public int getAddToBasket() {
        return addToBasket;
    }

    @Override
    public String toString() {
        return "SearchInfo{" +
                "title='" + title + '\'' +
                ", nullSearchValue='" + nullSearchValue + '\'' +
                ", transitionsToPage='" + transitionsToPage + '\'' +
                ", addToBasket='" + addToBasket + '\'' +
                '}';
    }



}
