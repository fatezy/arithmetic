package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/29  21:52
 */
//Given a collection of distinct numbers, return all possible permutations.
//
//        For example,
//        [1,2,3] have the following permutations:
//        [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
    //获取数组的所有排序
public class Permutations_46 {
    public List<List<Integer>> permute(int[] num) {
        List<Integer> src = new ArrayList<>();
        for (int i=0; i<num.length; i++) {
            src.add(num[i]);
        }

        List<Integer> l = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(l);

        return permute(list, src);
    }

    private List<List<Integer>> permute(List<List<Integer>> list, List<Integer> src) {
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
                newList.add(copy);
            }

            total.addAll(permute(newList, newSrc));

        }

        return total;
    }
}
