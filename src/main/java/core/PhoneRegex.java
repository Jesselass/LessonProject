package core;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static core.ReadAFile.fileData;
import static core.ReadAFile.getDataFromTxt;
import static core.ReadAFile.listToDataProvider;

/**
 * Created by Dell-SSD on 28.07.2017.
 */
public class PhoneRegex {
    @DataProvider(name = "starsNames")
    public static Object[][] starsNames() {
        getDataFromTxt("C:/starsNames.txt");
        return listToDataProvider(fileData);

    }
    @Test(dataProvider = "starsNames")

    public void hs(String starName){
        String newName  =starName;
        String rex = newName.replaceAll("\\D","");
        System.out.println(rex);
    }
}
