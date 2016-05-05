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


    public List<String> findRepeatedDnaSequences2(String s) {
        Set<Integer> firstTime = new HashSet<Integer>();
        Set<Integer> secondTime = new HashSet<Integer>();
        List<String> list = new ArrayList<String>();

        char[] map = new char[26];
        int len = s.length();

        map['A' - 'A'] = 0; // A = 00
        map['C' - 'A'] = 1; // B = 01
        map['G' - 'A'] = 2; // C = 10
        map['T' - 'A'] = 3; // D = 11

        for(int i=0; i<= len - 10; i++) {
            int sequence = 0;
            //构建hash值
            for(int j=i; j< i+10; j++) {
                sequence = sequence << 2;
                sequence = sequence | map[s.charAt(j) - 'A'];
            }
            //firstTime添加成功，则短路第二次
            //第二次添加时，firsttime添加失败
            if(!firstTime.add(sequence) && secondTime.add(sequence)) {
                list.add(s.substring(i, i+10));
            }
        }
        return list;
    }


}
