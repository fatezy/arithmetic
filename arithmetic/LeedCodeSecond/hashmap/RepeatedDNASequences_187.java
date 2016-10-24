package hashmap;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/10/24  23:22
 */
/*All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

        Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

        For example,

        Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

        Return:
        ["AAAAACCCCC", "CCCCCAAAAA"].*/
    //找出所有重复为10的子串
public class RepeatedDNASequences_187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        Set<String> set =new HashSet<>();
        List<String> list = new ArrayList<>();

        if (s.length()<=10) return list;

        for (int i = 0; i <=s.length()-10 ; i++) {
            if (!set.add(s.substring(i,i+10))&&!list.contains(s.substring(i,i+10))){
                list.add(s.substring(i,i+10));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }
}
