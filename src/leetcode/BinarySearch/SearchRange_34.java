package leetcode.BinarySearch;

/**
 * author： 张亚飞
 * time：2016/4/27  16:01
 */
//Given a sorted first.leetCode.array of integers, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the first.leetCode.array, return [-1, -1].
//
//        For example,
//        Given [5, 7, 7, 8, 8, 10] and target value 8,
//        return [3, 4].
public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int begin = -1; int end = -1;
        int count = -1; boolean flag = false;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==target){
                if (flag == false) {
                    begin = i;
                    flag = true;
                }
                count++;

            }

        }
        if (count!=-1) {
            end = begin + count;
        }

        int[] ret = new int[2];
        ret[0] = begin;
        ret[1] = end;
        return ret;
    }
}
