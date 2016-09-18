package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/9/18  22:02
 */
/*Given a set of candidate numbers (C) and a target number (T), find all unique
 combinations in C where the candidate numbers sums to T.

        The same repeated number may be chosen from C unlimited number of times.

        Note:
        All numbers (including target) will be positive integers.
        The solution set must not contain duplicate combinations.
        For example, given candidate set [2, 3, 6, 7] and target 7,
        A solution set is:
        [
        [7],
        [2, 2, 3]
        ]*/
    //给你个数组，找出目标值为target的所有的不重复的组合
public class CombinationSum_39 {
    //回溯法
    //回溯法，需动态更新目前遍历的路线
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combination(lists,candidates,list,target,0);
        return lists;

    }

    public static void combination(List<List<Integer>> res,int[] candidates,List<Integer> curr,int target,int start){
        if (target > 0){
            for (int i = start; i <candidates.length ; i++) {
                curr.add(candidates[i]);
                combination(res,candidates,curr,target-candidates[i],i);
                curr.remove(curr.size()-1);
            }
        }else if (target == 0){
            res.add(new ArrayList<>(curr));
        }
    }


    public static void main(String[] args) {

    }
}
