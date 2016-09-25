package Array;

/**
 * author： 张亚飞
 * time：2016/9/25  21:49
 */
/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

        Each element in the array represents your maximum jump length at that position.

        Determine if you are able to reach the last index.

        For example:
        A = [2,3,1,1,4], return true.

        A = [3,2,1,0,4], return false.*/
    //经典贪心算法
public class JumpGame_55 {
    public static boolean canJump(int[] nums) {
        int maxG0 = 0;
        if (nums.length<=1) return true;
        for (int i = 0; i <nums.length-1; i++) {
            if (nums[i]+i >=nums.length-1) return true;
            if (i==nums.length-2||nums[i]==0){
                return false;
            }
            int tempNum = i;
            for (int j = 1; j <=nums[tempNum] ; j++) {
                int tempGo = nums[tempNum+j]+tempNum+j;
                if (tempGo>=maxG0){
                    maxG0 = tempGo;
                    i = tempNum+j-1;
                }
            }

        }
       return false;
    }


    public static void main(String[] args) {
        int[] nums = {5,4,0,2,0,1,0,1,0};
        System.out.println(canJump(nums));
    }

}
