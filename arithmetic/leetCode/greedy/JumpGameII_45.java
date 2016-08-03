package greedy;

/**
 * author： 张亚飞
 * time：2016/8/3  20:44
 */
//Given an array of non-negative integers, you are initially positioned at
// the first index of the array.
//
//        Each element in the array represents your maximum jump length at that position.
//
//        Your goal is to reach the last index in the minimum number of jumps.
//
//        For example:
//        Given array A = [2,3,1,1,4]
//
//        The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1,
// then 3 steps to the last index.)
    //标准的贪心问题
public class JumpGameII_45 {
    public static int jump(int[] nums) {
        int step = 0;
        int arr = 0;
        int index = 0;
        if (nums.length == 1) return 0;
        for (int i = 0; i <nums.length ; i++) {
            int len = nums[i];
            if (i+len>=nums.length-1) {
                return step + 1;
            }
            for (int j = i+1; j <=i+len ; j++) {
               if (j+nums[j]>arr){
                   arr = j+nums[j];
                   index = j;
               }
            }
            step++;
            i = index-1;

        }
        return step;

    }


    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
