package leetCode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 查看数组中是否有不同
 * author： 张亚飞
 * time：2016/4/3  16:35
 */
// Given an first.leetCode.array of integers, find if the first.leetCode.array contains any duplicates. Your function should return true if any value appears at least twice in the first.leetCode.array,
//   and it should return false if every element is distinct.
public class ContainsDuplicate_217 {
    /**
     * 失败的方法，超时
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        boolean flag = false;
        for (int i = 0; i <nums.length; i++) {
            for (int j = 0; j <i ; j++) {
                if (nums[i]==nums[j]){
                    return true;
                }
            }
        }
        return true;

    }

    /**
     * set方法
     * @param nums
     * @return
     */

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length == 0){
            return false;
        }
        Set<Integer> arraySet = new HashSet<Integer>();
        for (Integer num : nums){
            if (!arraySet.add(num)){
                return true;
            }

        }

        return false;
    }

    /**
     * 第三种排序实现
     * @param nums
     * @return
     */
    public boolean containsDuplicate3(int[] nums) {
        Arrays.sort(nums);
        for(int i =0; i<nums.length; i++){
            if(i+1<nums.length && nums[i]==nums[i+1]){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Set<Integer> arraySet = new HashSet<Integer>();
        arraySet.add(4);

    }
}