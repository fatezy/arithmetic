package leetCode.Backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
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
    public static List<List<Integer>> permute(int[] num) {
        List<Integer> src = new ArrayList<>();
        for (int i=0; i<num.length; i++) {
            src.add(num[i]);
        }

        List<Integer> l = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(l);

        return permute(list, src);
    }
//输入为（1，2，3）时，遍历的顺序为（1，2，3）（1，3，2）。。。。。
    private static List<List<Integer>> permute(List<List<Integer>> list, List<Integer> src) {
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



    public static List<List<Integer>> permute2(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : num) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a = {1,2,3};
        System.out.println(permute(a));
    }
}
