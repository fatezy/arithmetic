package Array;

/**
 * author： 张亚飞
 * time：2016/9/18  21:21
 */
/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

        You may assume no duplicates in the array.

        Here are few examples.
        [1,3,5,6], 5 → 2
        [1,3,5,6], 2 → 1
        [1,3,5,6], 7 → 4
        [1,3,5,6], 0 → 0*/
    //给你一个有序数组，寻找可以插入的位置
public class SearchInsertPosition_35 {
    //二叉搜索，最后left的位置，及可插入的位置
    public static int searchInsert(int[] nums, int target) {

        return bSearch(nums,target);
    }


    public static int bSearch(int[] nums,int target){
        int l = 0; int r = nums.length -1;
        while (l<=r){
            int mid = (l+r)/2;
            if (target>nums[mid]){
                l = mid +1;
            }else if (target<nums[mid]){
                r = mid -1;
            }else {
                return mid;
            }

        }
        return l;

    }

    public static void main(String[] args) {

    }
}
