package leetcode.BinarySearch;

/**
 * author： 张亚飞
 * time：2016/4/27  16:30
 */
//Suppose a sorted first.leetCode.array is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        Find the minimum element.
//
//        You may assume no duplicate exists in the first.leetCode.array.
public class FindMin_153 {
    public int findMin(int[] nums) {
        if (nums.length==0)
            return 0;
        int min = nums[0];
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]<min){
                min = nums[i];
            }


        }
        return min;
    }
}
