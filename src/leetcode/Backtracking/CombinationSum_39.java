package leetCode.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/6/3  16:27
 */
//Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//        The same repeated number may be chosen from C unlimited number of times.
//
//        Note:
//        All numbers (including target) will be positive integers.
//        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//        The solution set must not contain duplicate combinations.
//        For example, given candidate set 2,3,6,7 and target 7,
//        A solution set is:
//        [7]
//        [2, 2, 3]
//给你一组数，一个目标值，找出所有的这些数相加等于目标值的组合。
public class CombinationSum_39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        combination(lists, new ArrayList<Integer>(), candidates, target, 0);
        return lists;
    }

    public static void combination(List<List<Integer>> result,List<Integer> cur,int[] candidetes,int target,int start){
        if (target>0){
            for (int i = start;i<candidetes.length&&target >= candidetes[i];i++){
                cur.add(candidetes[i]);
                combination(result,cur,candidetes,target - candidetes[i],i);
                cur.remove(cur.size() - 1);

            }
        }else if (target == 0){
            result.add(new ArrayList<Integer>(cur));
        }


    }


    public static void main(String[] args) {
        int[] a = {2,2,3,6};
        combinationSum(a,7);
    }

}
