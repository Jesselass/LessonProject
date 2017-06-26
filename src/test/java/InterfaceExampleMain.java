import core.BrowserFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Dell-SSD on 24.05.2017.
 */
public class InterfaceExampleMain extends BrowserFactory {

    @DataProvider
    public Object [][] pages(){
        return new Object[][]{
                {new KinopoiskSearchPage(driver)},
                {new ImdbSearchPage(driver)}
        };
    }


    @Test(dataProvider = "pages")
    public void testSearch(SearchPage searchPage) {

        searchPage.open();
        searchPage.inputText("Гадкий я");
        searchPage.submit();




    }

}
