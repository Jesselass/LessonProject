package lesson5HomeWork;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;

import static java.lang.Double.parseDouble;

/**
 * Created by Dell-SSD on 02.05.2017.
 */
public class BankImprove {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.privat24.ua");
        String privat = driver.getPageSource();

        int indexPrivat = privat.indexOf("ДОЛ");
        int indexReg = privat.indexOf("ЄВРО");
        String privatCourse = privat.substring(indexPrivat, indexReg);

        String privatCourseBuy = privat.substring(indexPrivat+48, indexPrivat+54);
        double privatBuy = Double.parseDouble(privatCourseBuy);
        String privatCourseSell = privat.substring(indexPrivat+58,indexPrivat+64);
        double privatSell = Double.parseDouble(privatCourseSell);


        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        String ukrsibb = driver.getPageSource();
        int ukrsibIndex = ukrsibb.indexOf("доллар США");
        int urksibIndexReg = ukrsibb.indexOf("евро");
        String ukrsibbCourse = ukrsibb.substring(ukrsibIndex, urksibIndexReg);
        String ukrsibbCourseBuy = ukrsibb.substring(ukrsibIndex+19, ukrsibIndex+26);
        String ukrsibbCourseSell = ukrsibb.substring(ukrsibIndex+35, ukrsibIndex+42);
        ukrsibbCourseBuy = ukrsibbCourseBuy.replace(",",".");
        ukrsibbCourseSell = ukrsibbCourseSell.replace(",", ".");
        double ukrsibbBuy = Double.parseDouble(ukrsibbCourseBuy);
        double ukrsibbSell = Double.parseDouble(ukrsibbCourseSell);


        driver.get("https://www.aval.ua/ru/personal/everyday/exchange/exchange/");
        String aval = driver.getPageSource();
        int avalIndex = aval.indexOf("Доллары");
        int avalIndexReg = aval.indexOf("Евро", avalIndex);
        String avalCourse = aval.substring(avalIndex,avalIndexReg);
        String avalCourseBuy = aval.substring(avalIndex+34,avalIndex+40);
        String avalCourseSell = aval.substring(avalIndex+63, avalIndex+69);
        avalCourseBuy = avalCourseBuy.replace(",",".");
        avalCourseSell = avalCourseSell.replace(",",".");
        double avalBuy = Double.parseDouble(avalCourseBuy);
        double avalSell = Double.parseDouble(avalCourseSell);

        driver.get("http://www.oschadbank.ua/ua/");
        String oschad = driver.getPageSource();
        int oschadIndex = oschad.indexOf("buy-USD");
        int oschadIndexReg = oschad.indexOf("EUR");
        String oschadCourse = oschad.substring(oschadIndex,oschadIndexReg);

        String oschadCourseBuy = oschad.substring(oschadIndex+19, oschadIndex+26);
        String oschadCourseSell = oschad.substring(oschadIndex+83, oschadIndex+90);
        oschadCourseBuy = oschadCourseBuy.replace(",",".");
        oschadCourseSell = oschadCourseSell.replace(",",".");
        double oschadBuy = Double.parseDouble(oschadCourseBuy);
        double oschadSell = Double.parseDouble(oschadCourseSell);

        driver.get("https://bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        String nbu = driver.getPageSource();
        int nbuIndex = nbu.indexOf("Долар");
        String nbuCourse = nbu.substring(nbuIndex);

        String nbuCourseBuy = nbu.substring(nbuIndex+45, nbuIndex+54);
        double nbuBuy = Double.parseDouble(nbuCourseBuy);
        double nbuBuyToCompare = nbuBuy/100;
        System.out.println(nbuBuyToCompare);

        driver.quit();
        double averageBuy = (privatBuy+ukrsibbBuy+avalBuy+oschadBuy+nbuBuyToCompare)/5;
        double averageSell = (privatSell+avalSell+oschadSell+ukrsibbSell)/4;
        System.out.println("Средний курс покупки" + " " + averageBuy);
        System.out.println("Средний курс продажи" + " " + averageSell);
        if ((privatBuy<=ukrsibbBuy)&&(privatBuy<=avalBuy)&&(privatBuy<=oschadBuy)&&(privatBuy<=nbuBuyToCompare)) {
            System.out.println("Самый низкий курс покупки Приват!");
        } else if ((ukrsibbBuy<=privatBuy)&&(ukrsibbBuy<=avalBuy)&&(ukrsibbBuy<=oschadBuy)&&(ukrsibbBuy<=nbuBuy)) {
            System.out.println("Самый низкий курс покупки УкрСиб!");
        } else if ((avalBuy<=privatBuy)&&(avalBuy<=ukrsibbBuy)&&(avalBuy<=oschadBuy)&&(avalBuy<=nbuBuy)) {
            System.out.println("Самый низкий курс покупки Райфайзен!");
        } else if ((oschadBuy<=privatBuy)&&(oschadBuy<=avalBuy)&&(oschadBuy<=ukrsibbBuy)&&(oschadBuy<=nbuBuy)) {
            System.out.println("Самый низкий курс покупки Ощадбанк!");
        } else if ((nbuBuy<=privatBuy)&&(nbuBuy<=avalBuy)&&(nbuBuy<=oschadBuy)&&(nbuBuy<=ukrsibbBuy)) {
            System.out.println("Самый низкий курс покупки НБУ!");
        }
        if ((privatSell>=ukrsibbSell)&&(privatSell>=avalSell)&&(privatSell>=oschadSell)) {
            System.out.println("Самый высокий курс продажи Приват!");
        } else if ((ukrsibbSell>=privatSell)&&(ukrsibbSell>=avalSell)&&(ukrsibbSell>=oschadSell)) {
            System.out.println("Самый высокий курс продажи УкрСиб!");
        } else if ((avalSell>=privatSell)&&(avalSell>=ukrsibbSell)&&(avalSell>=oschadSell)) {
            System.out.println("Самый высокий курс продажи Райфайзен!");
        } else if ((oschadSell>=privatSell)&&(oschadSell>=avalSell)&&(oschadSell>=ukrsibbSell)) {
            System.out.println("Самый высокий курс продажи Ощадбанк!");
        }


    }


}

