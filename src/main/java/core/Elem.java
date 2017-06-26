package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.MethodsFactory.driver;

/**
 * Created by Dell-SSD on 07.06.2017.
 */
public class Elem extends MethodsFactory{

    public Elem (By by, String name){
        this.by = by;
        this.name = name;
    }


    private By by;
    private String name = "";



    public void click(){
       driver.findElement(by).click();
    }
    public void type(String text){find().clear(); find().sendKeys(text);}
    public String getText(){String newText = driver.findElement(by).getText(); return newText;}
    public void finder(){driver.findElement(by);}
    public WebElement find(){return getWebDriverWait(WaitTime.DEFAULT_ELEMENT_WAIT).until(ExpectedConditions.presenceOfElementLocated(by)); }
    public String getAttribute(String attributeName){return find().getAttribute(attributeName);}


}
