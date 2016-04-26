package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/4/26  22:12
 */
//Given a roman numeral, convert it to an integer.
//
//        Input is guaranteed to be within the range from 1 to 3999.
public class RomanToInt_13 {
    public int romanToInt(String s) {
        HashMap<String, Integer> table = new HashMap<>();
        table.put("I",1);
        table.put("IV",4);
        table.put("V",5);
        table.put("IX",9);
        table.put("X",10);
        table.put("XL",40);
        table.put("L",50);
        table.put("XC",90);
        table.put("C",100);
        table.put("CD",400);
        table.put("D",500);
        table.put("CM",900);
        table.put("M",1000);

        int result = 0;
        int len = s.length();

        for (int i = 0; i <len ; i++) {
            if (i+1<len){
                String ss = s.charAt(i)+""+s.charAt(i+1);
                if (table.containsKey(ss)){
                    result+=table.get(ss);
                    i=i+1;
                    continue;

                }
            }
            String ss = s.charAt(i)+"";
            result+=table.get(ss);


        }

        return result;

    }
}
