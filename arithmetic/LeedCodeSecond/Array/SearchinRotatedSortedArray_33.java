package Array;

/**
 * author： 张亚飞
 * time：2016/9/17  20:01
 */
/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        You are given a target value to search. If found in the array return its index,
         otherwise return -1.

        You may assume no duplicate exists in the array.*/
    //从一个以一个中心旋转的数组查找某个数，并返回其下标
public class SearchinRotatedSortedArray_33 {
    public static int search(int[] nums, int target) {
        int max = nums.length-1;
        for (int i = 0; i <nums.length-1 ; i++) {
            if (nums[i]>nums[i+1]){
                max = i;
                break;
            }
        }
        if (nums.length-1 == max) return bSearch(nums,0,max,target);
        return target>=nums[0]?bSearch(nums,0,max,target):bSearch(nums,max+1,nums.length-1,target);
    }


    public static int bSearch(int[] nums, int l,int r,int target){

        while (l<=r){
            int mid = (l+r)/2;
            if (target>nums[mid]){
                l = mid + 1;
            }else if (target<nums[mid]){
                r = mid -1;
            }else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,-1};
        System.out.println(search(nums, 3));


    }
}
