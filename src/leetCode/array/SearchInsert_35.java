package leetCode.array;

/**
 * author： 张亚飞
 * time：2016/4/26  17:09
 */
//Given a sorted first.leetCode.array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
//        You may assume no duplicates in the first.leetCode.array.
//
//        Here are few examples.
//        [1,3,5,6], 5 → 2
//        [1,3,5,6], 2 → 1
//        [1,3,5,6], 7 → 4
//        [1,3,5,6], 0 → 0
    //找插入点

public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (len==0){
            return 0;
        }
        if (nums[0]>=target)
            return 0;
        if (nums[len-1]==target)
            return len-1;
        if (nums[len-1]<target)
            return len;
        for (int i = 0; i <len ; i++) {
            if (nums[i]<target&&i<len-1&&nums[i+1]>target){
                return i+1;
            }
            if (nums[i]==target){
                return i;
            }



        }
        return 0;

    }
}
