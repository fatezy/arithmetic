package Array;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/9/19  21:19
 */
/*Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.

        Each number in C may only be used once in the combination.

        Note:
        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.
        For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
        A solution set is:
        [
        [1, 7],
        [1, 2, 5],
        [2, 6],
        [1, 1, 6]
        ]*/
    //给你一个数组，找出所有可以得到目标和的集合
public class CombinationSumII_40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> sets = new HashSet<>();
        List<List<Integer>>  lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combination(lists,sets,candidates,list,target,0);
        return lists;
    }

    public static void combination(List<List<Integer>> res,Set<List<Integer>> sets,int[] candidates,List<Integer> curr,int target,int start){
        if (target >0){
            for (int i = start; i <candidates.length&&target>=candidates[i] ; i++) {
                curr.add(candidates[i]);
                combination(res,sets,candidates,curr,target-candidates[i],i+1);
                curr.remove(curr.size()-1);
            }

        }else if (target == 0){
           if (sets.add(new ArrayList<>(curr))){
               res.add(new ArrayList<>(curr));
           }
        }
    }


    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        System.out.println(combinationSum2(nums, 8));

    }

}
