package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.NumberFormat;
import java.util.concurrent.TimeUnit;




/**
 * Created by Dell-SSD on 07.04.2017.
 */
public class HomeWork5 {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.privat24.ua");
       String privat = driver.findElement(By.xpath("//*[@class='section-content rate']")).getText(); // вернет текст элемента
       String privatCourse[] = privat.split("\\/");
       String privatCourseBuy = privatCourse[0];
       String privatCourseSell = privatCourse[1];






        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        String ukrsibCourseBuy = driver.findElement(By.xpath("//table[@class='stripeMe content_tbl2']/*/tr[1]/td[3]" )).getText();
        String ukrsibCourseSell = driver.findElement(By.xpath("//table[@class='stripeMe content_tbl2']/*/tr[1]/td[4] ")).getText();
        ukrsibCourseBuy = ukrsibCourseBuy.replace(',','.');
        ukrsibCourseSell = ukrsibCourseSell.replace(',','.');
        //String ukrsibCourse = ukrsibCourseBuy + "/" +  ukrsibCourseSell;

        driver.get("https://www.aval.ua/ru/personal/everyday/exchange/exchange/");
        String raifaisenCourseBuy = driver.findElement(By.xpath("//table[@class = 'body-currency']/*/tr[2]/td[2]")).getText();
        String raifaisenCourseSell = driver.findElement(By.xpath("//table[@class = 'body-currency']/*/tr[2]/td[3]")).getText();
        raifaisenCourseBuy = raifaisenCourseBuy.replace(',','.');
        raifaisenCourseSell = raifaisenCourseSell.replace(',','.');
        //String raifaisenCourse = raifaisenBuy + "/" + raifaisenSell;


        driver.get("http://www.oschadbank.ua/ua/");
        String oschadCourseBuy = driver.findElement(By.xpath("//*[@class='buy-USD']")).getText();
        String oschadCourseSell = driver.findElement(By.xpath("//*[@class='sell-USD']")).getText();
        oschadCourseBuy = oschadCourseBuy.replace(',','.');
        oschadCourseSell = oschadCourseSell.replace(',','.');

        //String oschadCourse = oschadBuy + "/" + oschadSell;

        driver.get("https://bank.gov.ua/control/uk/index");
        String nbuCourse = driver.findElement(By.xpath("//td[@nowrap='nowrap']")).getText();
        nbuCourse = nbuCourse.replace(',','.');

        driver.quit();
        Thread.sleep(5000);


        double privatBuy = Double.valueOf(privatCourseBuy);
        double privatSell = Double.valueOf(privatCourseSell);
        double urksibBuy = Double.valueOf(ukrsibCourseBuy);
        double urksibSell = Double.valueOf(ukrsibCourseSell);
        double raifaisenBuy = Double.valueOf(raifaisenCourseBuy);
        double raifaisenSell = Double.valueOf(raifaisenCourseSell);
        double oschadBuy = Double.valueOf(oschadCourseBuy);
        double oschadSell = Double.valueOf(oschadCourseSell);
        double nbuBuy100 = Double.valueOf(nbuCourse);
        double nbuBuy = nbuBuy100/100;

        //double nbuBuy = (double)intNbuBuy;




        double averageBuy = (privatBuy+urksibBuy+raifaisenBuy+oschadBuy+nbuBuy)/5;
        double averageSell = (privatSell+raifaisenSell+oschadSell+urksibSell)/4;
        System.out.println("Средний курс покупки" + " " + averageBuy);
        System.out.println("Средний курс продажи" + " " + averageSell);
        if ((privatBuy<=urksibBuy)&&(privatBuy<=raifaisenBuy)&&(privatBuy<=oschadBuy)&&(privatBuy<=nbuBuy)) {
            System.out.println("Самый низкий курс покупки Приват!");
        } else if ((urksibBuy<=privatBuy)&&(urksibBuy<=raifaisenBuy)&&(urksibBuy<=oschadBuy)&&(urksibBuy<=nbuBuy)) {
            System.out.println("Самый низкий курс покупки УкрСиб!");
        } else if ((raifaisenBuy<=privatBuy)&&(raifaisenBuy<=urksibBuy)&&(raifaisenBuy<=oschadBuy)&&(raifaisenBuy<=nbuBuy)) {
            System.out.println("Самый низкий курс покупки Райфайзен!");
        } else if ((oschadBuy<=privatBuy)&&(oschadBuy<=raifaisenBuy)&&(oschadBuy<=urksibBuy)&&(oschadBuy<=nbuBuy)) {
            System.out.println("Самый низкий курс покупки Ощадбанк!");
        } else if ((nbuBuy<=privatBuy)&&(nbuBuy<=raifaisenBuy)&&(nbuBuy<=oschadBuy)&&(nbuBuy<=urksibBuy)) {
            System.out.println("Самый низкий курс покупки НБУ!");
        }
        if ((privatSell>=urksibSell)&&(privatSell>=raifaisenSell)&&(privatSell>=oschadSell)) {
            System.out.println("Самый высокий курс продажи Приват!");
        } else if ((urksibSell>=privatSell)&&(urksibSell>=raifaisenSell)&&(urksibSell>=oschadSell)) {
            System.out.println("Самый высокий курс продажи УкрСиб!");
        } else if ((raifaisenSell>=privatSell)&&(raifaisenSell>=urksibSell)&&(raifaisenSell>=oschadSell)) {
            System.out.println("Самый высокий курс продажи Райфайзен!");
        } else if ((oschadSell>=privatSell)&&(oschadSell>=raifaisenSell)&&(oschadSell>=urksibSell)) {
            System.out.println("Самый высокий курс продажи Ощадбанк!");
        }
        }


        }








       /* System.out.println("Средний курс покупки" + " " + averageBuy);
        System.out.println("Средний курс продажи" + " " + averageSell);
        System.out.println(urksibBuy);
        System.out.println(urksibSell);
        System.out.println(raifaisenBuy);
        System.out.println(raifaisenSell);
        System.out.println(oschadBuy);
        System.out.println(oschadSell);
        System.out.println(nbuBuy);*/




