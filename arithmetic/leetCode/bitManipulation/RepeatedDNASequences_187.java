package bitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/5/5  17:14
 */
//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T,
// for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences
// within the DNA.
    //找出所有重复不止一次的长度为10个字符串
public class RepeatedDNASequences_187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<String>();
        Set<String> resset = new HashSet<String>();
        if(s == null || s.length() <= 10){
            return res;
        }
        Set<String> set = new HashSet<String>();
        int len = s.length();
        for(int i = 0; i <= len - 10; i++){
            String sub = s.substring(i, i + 10);
            if(!set.add(sub)){
                resset.add(sub);
            }
        }
        res.addAll(resset);
        return res;
    }
}
