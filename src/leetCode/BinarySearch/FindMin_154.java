package leetCode.BinarySearch;

/**
 * author： 张亚飞
 * time：2016/5/1  16:43
 */
//Follow up for "Find Minimum in Rotated Sorted LeedCodeSecond.Array":
//        What if duplicates are allowed?
//
//        Would this affect the run-time complexity? How and why?
//        Suppose a sorted first.leetCode.array is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        Find the minimum element.
//
//        The first.leetCode.array may contain duplicates.
    //找出最小的值
public class FindMin_154 {
    public int findMin(int[] nums) {
        int low = Integer.MAX_VALUE;
        for (int i =0;i<nums.length;i++){
            if (low >nums[i]){
                low  = nums[i] ;
            }
        }
        return low;
    }

}
