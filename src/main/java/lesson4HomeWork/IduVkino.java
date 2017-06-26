package lesson4HomeWork;

import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.CaptureScreenshot;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;



/**
 * Created by Dell-SSD on 17.04.2017.
 */
public class IduVkino {
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("http://liniakino.com/showtimes/aladdin/");
        String film = driver.findElement(By.xpath("//*[@id='content-inner']/div/ul/li[1]/h1/a")).getText();
        System.out.println("Cеансы на фильм " + film);
        System.out.println("Выберите дату сеанса : " + "1 = Сегодня " + "2 = Завтра " + "3 = Послезавтра");
        //String date = driver.findElement(By.xpath("//*[@id='content-inner']/div/ul/li[1]/div[2]")).getText();
       // System.out.println(date);
        Scanner seans = new Scanner(System.in);
        String sean = seans.nextLine();
        int intSean = Integer.valueOf(sean);
        if (intSean == 1){
            String date1 = driver.findElement(By.xpath("//*[@id='content-inner']/div/ul/li[1]/div[2]/div[1]/div/ul")).getText();
            System.out.println("Cеансы на выбранную дату: " + date1);
        } else if (intSean ==2){
            String date2 = driver.findElement(By.xpath("//*[@id='content-inner']/div/ul/li[1]/div[2]/div[2]/div/ul")).getText();
            System.out.println("Cеансы на выбранную дату: " + date2);
        }else if (intSean ==3){
            String date3 = driver.findElement(By.xpath("//*[@id='content-inner']/div/ul/li[1]/div[2]/div[3]/div/ul")).getText();
            System.out.println("Cеансы на выбранную дату: " + date3);
        } else {
            System.out.println("Нет сеансов на указанную дату ");
        }
        System.out.println("Введите желаемое время сеанса в формате чч:мм : ");
        Scanner chooseTime = new Scanner(System.in);
        String time = chooseTime.nextLine();


        if (intSean == 1) {
            switch (time) {
                case "10:00":
                    //*[@id="content-inner"]/div/ul/li[1]/div[2]/div[2]/div/ul/li[1]/a
                    //*[@id="content-inner"]/div/ul/li[1]/div[2]/div[2]/div/ul/li[2]/a
                    //*[@id="content-inner"]/div/ul/li[1]/div[2]/div[1]/div/ul/li[1]/a
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='10:00']")).click();
                    break;
                case "12:00":
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='12:00']")).click();
                    break;
                case "16:20":
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='16:20']")).click();
                    break;
                case "18:00":
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='18:00']")).click();
                    break;
                case "20:50":
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='20:50']")).click();
                    break;
                case "21:40":
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='21:40']")).click();
                    break;
                case "22:30":
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='22:30']")).click();
                    break;
                case "23:30":
                    driver.findElement(By.xpath("//div/div[1]/div/ul/li/a[text() ='23:30']")).click();
                    break;
                default:
                    System.out.println("На указанное время нет сеанса!!!");
            }
        }else if (intSean==2){
            switch (time) {
                case "10:00":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='10:00']")).click();

                    break;
                case "12:00":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='12:00']")).click();
                    break;
                case "16:20":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='16:20']")).click();
                    break;
                case "18:00":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='18:00']")).click();
                    break;
                case "20:50":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='20:50']")).click();
                    break;
                case "21:40":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='21:40']")).click();
                    break;
                case "22:30":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='22:30']")).click();
                    break;
                case "23:30":
                    driver.findElement(By.xpath("//div/div[2]/div/ul/li/a[text() ='23:30']")).click();
                    break;
                default:
                    System.out.println("На указанное время нет сеанса!!!");
            }
        }else if (intSean==3){
            switch (time) {
                case "10:00":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='10:00']")).click();
                    break;
                case "12:00":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='12:00']")).click();
                    break;
                case "16:20":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='16:20']")).click();
                    break;
                case "18:00":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='18:00']")).click();
                    break;
                case "20:50":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='20:50']")).click();
                    break;
                case "21:40":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='21:40']")).click();
                    break;
                case "22:30":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='22:30']")).click();
                    break;
                case "23:30":
                    driver.findElement(By.xpath("//div/div[3]/div/ul/li/a[text() ='23:30']")).click();
                    break;
                default:
                    System.out.println("На указанное время нет сеанса!!!");
            }
        }
        WebElement iFrame= driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.xpath("//*[@id='hall-scheme-container']")).getText();
        String svbd = driver.findElement(By.xpath("//*[@id='hall-scheme-container']")).getText();
        //String [] svb = svbd.toString();
        List<Pair> svb = new ArrayList<Pair>();
        System.out.println(svb);

        //driver.findElement(By.xpath("//*[@class='seat seat-occupied']")).getText();
       // String znt = driver.findElement(By.xpath("//*[@class='seat seat-occupied']")).getText();
        //String zal = driver.findElement(By.xpath("//*[@id='hall-scheme-container']")).get();
        //System.out.println(znt);
        System.out.println(svbd);

        //driver.findElement(By.xpath("//a[text()='10:00']")).click();


        //driver.quit();
        //*[@id="content-inner"]/div/ul/li[1]/div[2]/div[1]/div/ul/li[1]/a

    }
}
