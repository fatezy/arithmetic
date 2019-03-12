package leetCode.divideandConquer;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/5/15  11:18
 */
//Find the kth largest element in an unsorted leetCode.array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
//
//        For example,
//        Given [3,2,1,5,6,4] and k = 2, return 5.
//
//        Note:
//        You may assume k is always valid, 1 ≤ k ≤ leetCode.array's length.
public class FindKthLargest_215 {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

}
