package leetCode.Backtracking;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/6/3  17:11
 */
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//        Each number in C may only be used once in the combination.
//
//        Note:
//        All numbers (including target) will be positive integers.
//        Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
//        The solution set must not contain duplicate combinations.
//        For example, given candidate set 10,1,2,7,6,1,5 and target 8,
//        A solution set is:
//        [1, 7]
//        [1, 2, 5]
//        [2, 6]
//        [1, 1, 6]
public class CombinationSumII_40 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        Set<List<Integer>> sets = new HashSet<>();
        combination(lists, sets,new ArrayList<Integer>(), candidates, target, 0);
        return lists;
    }

    public static void combination(List<List<Integer>> result,Set<List<Integer>> sets,List<Integer> cur,int[] candidetes,int target,int start){
        if (target>0){
            for (int i = start;i<candidetes.length&&target >= candidetes[i];i++){
                cur.add(candidetes[i]);
                combination(result,sets,cur,candidetes,target - candidetes[i],i+1);
                cur.remove(cur.size() - 1);

            }
        }else if (target == 0){
            if (sets.add(new ArrayList<Integer>(cur))) {
                result.add(new ArrayList<Integer>(cur));
            }
        }


    }


}
