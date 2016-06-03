package Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/6/3  20:44
 */
//Given a collection of numbers that might contain duplicates, return all possible unique permutations.
//
//        For example,
//        [1,1,2] have the following unique permutations:
//        [1,1,2], [1,2,1], and [2,1,1].
public class PermutationsII_47 {
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<Integer> src = new ArrayList<>();
        for (int i=0; i<num.length; i++) {
            src.add(num[i]);
        }

        List<Integer> l = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(l);
        Set<List<Integer>> set = new HashSet<>();
        return permute(set,list, src);
    }
    //输入为（1，2，3）时，遍历的顺序为（1，2，3）（1，3，2）。。。。。
    private static List<List<Integer>> permute(Set<List<Integer>> set,List<List<Integer>> list, List<Integer> src) {
        if (src.isEmpty())
            return list;

        List<List<Integer>> total = new ArrayList<>();

        for (int i=0; i<src.size(); i++) {
            int num = src.get(i);
            List<Integer> newSrc = new ArrayList<>(src);
            newSrc.remove(i);
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> l : list) {
                List<Integer> copy = new ArrayList<Integer>(l);
                copy.add(num);
                if (set.add(copy)){
                newList.add(copy);
                }
            }

                total.addAll(permute(set,newList, newSrc));



        }

        return total;
    }
    public static void main(String[] args) {
        int[] a = {1,1,2};
        permuteUnique(a);
    }
}
