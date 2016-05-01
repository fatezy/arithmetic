package BinarySearch;

/**
 * author： 张亚飞
 * time：2016/5/1  00:21
 */
//Follow up for "Search in Rotated Sorted Array":
//        What if duplicates are allowed?
//
//        Would this affect the run-time complexity? How and why?
//
//        Write a function to determine if a given target is in the array.

    //可以重复，返回是否包含要查找的数

public class SearchRotatedSortedArrayIII_81 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n==0 || (n==1 && nums[0]!=target)) return false;
        if(n==1 && nums[0]==target) return true;
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
    public boolean bSearch(int low, int high,int target ,int[] nums) {
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else return true;
        }

        return false;
    }


}
