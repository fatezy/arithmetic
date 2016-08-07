package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/14  21:53
 */
//Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
//        For example,
//        If n = 4 and k = 2, a solution is:
//
//        [
//        [2,4],
//        [3,4],
//        [2,3],
//        [1,2],
//        [1,3],
//        [1,4],
//        ]
    //求出所有的结合
    //回溯
public class Combinations_77 {
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> lists = new ArrayList<>();
//        for (int i=1;i<=n;i++){
//            for (int j = i; j <=n-k+1; j++) {
//                List<Integer> list = new ArrayList<>();
//                for (int l = i ; l < i+k-1; l++) {
//                    list.add(l);
//                }
//                list.add(j+k-1);
//                lists.add(list);
//
//            }
//        }
//        return lists;
//
//    }

    public  static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (k > n || k < 0) {
            return result;
        }
        if (k == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        result.addAll(combine(n - 1, k));
        return result;
    }

    public static void main(String[] args) {
        combine(3,2);
    }


}
