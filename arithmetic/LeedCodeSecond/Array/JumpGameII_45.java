package Array;

/**
 * author： 张亚飞
 * time：2016/9/20  17:50
 */
/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

        Each element in the array represents your maximum jump length at that position.

        Your goal is to reach the last index in the minimum number of jumps.

        For example:
        Given array A = [2,3,1,1,4]

        The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

        Note:
        You can assume that you can always reach the last index.*/
    //给你一个数组代表你在当前位置可以跳的步数，问到达终点，至少要
    //跳几次
public class JumpGameII_45 {
    //贪心法,即遍历数组，当前一步去哪个位置的下个位置可到达最远
    public static int jump(int[] nums) {
        int res = 0;
        int maxGo = 0;
        if (nums.length == 0|| nums.length == 1) return 0;
        for (int i = 0; i <nums.length ; i++) {
            res++;
            if (nums[i]+i>=nums.length-1)
                return res;
            int length= nums[i];
            int itemp = i;
            for (int j = 1; j <=length ; j++) {
                int temp = itemp+j+nums[itemp+j];
                if (temp > maxGo) {
                    maxGo = temp;
                    i = itemp+j-1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,1,1,3,1,1,1};
        System.out.println(jump(nums));

    }
}
