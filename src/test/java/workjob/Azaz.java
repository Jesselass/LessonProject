package workjob;

import org.testng.annotations.Test;

import java.util.*;
import java.util.LinkedHashSet;
/**
 * Created by Dell-SSD on 23.06.2017.
 */

    public class Azaz {
        List<Long> result = new ArrayList<>();

        Set<String> frankieDataSet = new LinkedHashSet<>();
        @Test
        public void tryIt(){
            String a = "119";
            String b = "120";
            String c = "128";
            String d = "121";
            String e = "127";
            frankieDataSet.add(c);
            frankieDataSet.add(e);
            frankieDataSet.add(d);
            frankieDataSet.add(b);
            frankieDataSet.add(a);



            Iterator<String> firstItem = frankieDataSet.iterator();
            long tmp = Long.parseLong(firstItem.next());
            Iterator<String> label = frankieDataSet.iterator();
            long difference;
            while (label.hasNext()){
              //  String s = label.next();

                if(tmp==Long.parseLong(label.next())){
                    tmp = tmp-1;
                    System.out.println(tmp+"try1");
                }else{
                    difference = tmp - Long.parseLong(label.next());
                    if(difference == 1 ){
                        result.add(tmp);
                        tmp = tmp-1;
                        System.out.println(tmp+" try2");}
                    else if (difference>1){
                        for (int i = (int)difference; i >0 ; i--) {
                            result.add(tmp);
                            System.out.println(tmp+" try3");
                            tmp = tmp-1;
                        }
                    }
                }
            }
            System.out.println(result.toString());
        }
    }

