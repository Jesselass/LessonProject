package pageObject;

import core.Elem;
import core.MethodsFactory;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-SSD on 12.06.2017.
 */
public class MatchesPage extends MethodsFactory {
    Elem likeBtn = new Elem (By.cssSelector("[value = '3']"),"Like Button");
    Elem dislikeBtn = new Elem(By.cssSelector("[value = '1']"),"Dislike Button");
    Elem userIdElem = new Elem(By.cssSelector(".matches-carousel [data-uid]"),"");

    public void open(){
        get("http://kismia.com/matches");
    }

    public String getCurrentUserId(){
      return userIdElem.getAttribute("data-uid");
    }
    public List <String> dislikeUsers (int count){
        List <String> userIdsList = new ArrayList<>();

        for (int i = 0; i < count; i++ ){
            String currentUserId = getCurrentUserId();
            userIdsList.add(currentUserId);
            dislikeBtn.click();
        }
        return userIdsList;
    }
}
