package BinarySearch;

/**
 * author： 张亚飞
 * time：2016/4/30  22:49
 */
//Suppose a sorted array is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        You are given a target value to search. If found in the array return its index, otherwise return -1.
    //题目解释：给你一个数组，但是你不知道是在哪一个位子进行了反转，给你一个目标值，出找出他的位置
public class SearchRotatedSortedArray_33 {
    //非二分法
    //虽然此种方法可以通过，但是并不符合出题人的二分的思想
    public int search(int[] nums, int target) {
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==target){
                return i;

            }

        }
        return -1;
    }

        //二分查找法
    public int search2(int[] nums, int target) {
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]==target){
                return i;

            }

        }
        return -1;
    }


}
