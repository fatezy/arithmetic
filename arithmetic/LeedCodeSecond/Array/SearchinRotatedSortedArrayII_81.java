package Array;

/**
 * author： 张亚飞
 * time：2016/9/29  20:14
 */
/*Follow up for "Search in Rotated Sorted Array":
        What if duplicates are allowed?

        Would this affect the run-time complexity? How and why?

        Write a function to determine if a given target is in the array.*/
//确定是否有目标值，在一个旋转的有序数组
public class SearchinRotatedSortedArrayII_81 {
    public static boolean search(int[] nums, int target) {
        int max = nums.length-1;
        for (int i = 0; i <nums.length-1 ; i++) {
            if (nums[i]>nums[i+1]){
                max = i;
                break;
            }
        }
        if (nums.length-1 == max) return bSearch(nums,0,max,target)!=-1;
        target =  target>=nums[0]?bSearch(nums,0,max,target):bSearch(nums,max+1,nums.length-1,target);
        return target!=-1;
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
}
