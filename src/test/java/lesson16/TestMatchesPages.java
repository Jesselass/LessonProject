package lesson16;

import core.BrowserFactory;
import org.testng.annotations.Test;
import pageObject.MatchesPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dell-SSD on 12.06.2017.
 */
public class TestMatchesPages extends BrowserFactory {
    MatchesPage matchesPage = new MatchesPage();
    Map<String,Integer> duplicatedMap = new HashMap<>();
    @Test
    public void matches (){
        new TestLogIn().tryToLogIn();
        matchesPage.open();
        System.out.println(matchesPage.getCurrentUserId());
        List<String> dilikedUsersList = matchesPage.dislikeUsers(10);
        System.out.println(dilikedUsersList);
        for (String uid: dilikedUsersList) {
            if (duplicatedMap.containsKey(uid)){
                duplicatedMap.put(uid,duplicatedMap.get(uid)+1);
            }else {
                duplicatedMap.put(uid,1);
            }
        }
        System.out.println(duplicatedMap);

    }
}
