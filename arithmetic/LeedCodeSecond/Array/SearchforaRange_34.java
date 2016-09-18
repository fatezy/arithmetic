package Array;

/**
 * author： 张亚飞
 * time：2016/9/18  10:11
 */
//Given a sorted array of integers, find the starting and ending position of a given target value.
//
//        Your algorithm's runtime complexity must be in the order of O(log n).
//
//        If the target is not found in the array, return [-1, -1].
//
//        For example,
//        Given [5, 7, 7, 8, 8, 10] and target value 8,
//        return [3, 4].
    //给你一个有序的数组，查找目标值处于的区间
public class SearchforaRange_34 {
    //向二分找到一个目标值，再向前，向后遍历查找
    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int val = bSearch(nums,target);
        if (val == -1){
            res[0] = -1;
            res[1] = -1;
            return res;
        }
        int temp = val;
        while (temp != -1 && nums[temp] == target){
            temp--;
        }
        res[0] = temp+1;
        temp = val;
        while (temp!=nums.length && nums[temp] == target){
            temp++;
        }
        res[1] = temp-1;
        return res;
    }

    public static int bSearch(int[] nums,int target){
        int l = 0; int r = nums.length -1;

        while (l<=r){
            int mid = (l+r)/2;
            if (target>nums[mid]){
                l = mid+1;
            }else if (target<nums[mid]){
                r = mid -1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        searchRange(nums,0);
    }
}
