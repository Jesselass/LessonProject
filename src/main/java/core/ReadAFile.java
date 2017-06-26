package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dell-SSD on 12.06.2017.
 */
public class ReadAFile {
   public static List <String> fileData = new ArrayList<String>();

    public  static void getDataFromTxt(String path) {

        try{
            File myFile = new File(path);
            FileReader fileReader = new FileReader(myFile);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = null;
            while ((line = reader.readLine())!=null){
                System.out.println(line);
                fileData.add(line);

            }
            reader.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    public static Object[][] listToDataProvider(List<?> list){
        Object [][] objArray = new Object[list.size()][];
        for(int i=0;i< list.size();i++){
            objArray[i] = new Object[1];
            objArray[i][0] = list.get(i);
        }
        return objArray;
    }
}
