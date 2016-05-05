package bitManipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/5/3  23:39
 */
//Given a set of distinct integers, nums, return all possible subsets.
//
//        Note:
//        Elements in a subset must be in non-descending order.
//        The solution set must not contain duplicate subsets.
    //求子集，返回结果单个子集合必须递增
    //可以把每一个子集看成一个boolean类型的数组，共有len个子集
public class Subsets_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int len = (int) Math.pow(2,nums.length) - 1;
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i <=len ; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <nums.length ; j++) {
                //看看是否包含nums[j]
                if (((i>>j)&1) == 1 ){
                    list.add(nums[j]);
                }
            }
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3};
        List<List<Integer>> lists = subsets(a);
        System.out.println("ok");
    }


}
