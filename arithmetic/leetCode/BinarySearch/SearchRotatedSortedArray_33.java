package BinarySearch;

import org.junit.Test;

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
        for ( int i = 0; i <nums.length ; i++) {
            if (nums[i]==target){
                return i;

            }

        }
        return -1;
    }

        //二分查找法,这个解法貌似并没怎么提升效率
    public int search2(int[] nums, int target) {
        int n = nums.length;
        if(n==0 || (n==1 && nums[0]!=target)) return -1;
        if(n==1 && nums[0]==target) return 0;
        int i = 0;
        //找到分界点
        for ( i =0;i<n-1;i++){
            if (nums[i]>nums[i+1]){
                break;
            }
        }
        int pivot = i; int low,high;
        if(pivot==n-1) return bSearch(0,n-1,target,nums);
        return target>=nums[0]?bSearch(0,pivot,target,nums):bSearch(pivot+1, n-1,target,nums);

    }

//标准二分搜索
    public int bSearch(int low, int high,int target ,int[] nums) {
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else return mid;
        }
        //上面的if，else语句相当于
//        if (target < nums[mid]) {
//            high = mid - 1;
//        } else {
//            if (target > nums[mid]) {
//                low = mid + 1;
//            } else
//                return mid;
//        }
        return -1;
    }

    @Test
  public void test(){
    int[] nums = {1,3};
    int t = 2;
    search2(nums,2);
    }



}
