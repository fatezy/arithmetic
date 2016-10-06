package Array;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/10/6  19:02
 */
/*Given a collection of integers that might contain duplicates, nums, return all possible subsets.

        Note: The solution set must not contain duplicate subsets.

        For example,
        If nums = [1,2,2], a solution is:

        [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
        ]*/
    //找出所有的集合，不包含重复的
public class SubsetsII_90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        subset(set,res,curr,nums,0);
        return res;
    }

    public static void subset(Set<List<Integer>> sets,List<List<Integer>> res,List<Integer> curr,int[] num,int begin){
        if (sets.add(new ArrayList<>(curr))){
            res.add(new ArrayList<>(curr));
        }
        for (int i = begin; i <num.length ; i++) {
            curr.add(num[i]);
            subset(sets,res,curr,num,i+1);
            curr.remove(curr.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] num = {4,4,4,1};
        System.out.println(subsetsWithDup(num));
    }
}
