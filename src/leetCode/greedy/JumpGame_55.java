package leetCode.greedy;

/**
 * author： 张亚飞
 * time：2016/7/20  20:21
 */
//Given an first.leetCode.array of non-negative integers, you are initially positioned at the first index of the first.leetCode.array.
//
//        Each element in the first.leetCode.array represents your maximum jump length at that position.
//
//        Determine if you are able to reach the last index.
//
//        For example:
//        A = [2,3,1,1,4], return true.
//
//        A = [3,2,1,0,4], return false.

    //判断最后是否可以到达终点
    //贪心思想
    //获取当前状态的最佳值，就是找到可以到达的下一步他能到达的最远点，就是最佳状态
public class JumpGame_55 {
    public static boolean canJump(int[]nums) {

        for (int i = 0; i <nums.length ; i++) {
            if (i+nums[i]>=nums.length-1)
                return true;
            if (i==nums.length-2||nums[i]==0){
                return false;
            }
            int max =nums[i+1]+i+1;
            int temp = i+1;
            for (int j = 1; nums[i]!=0&&j <=nums[i]; j++) {
                if (nums[i+j]+i+j>=max){
                    max = nums[i+j]+i+j;
                    temp = i+j;

                }
            }
            i = temp-1;
        }

        return false;
    }


    public static void main(String[] args) {
        int[] nums = {5,4,0,2,0,1,0,1,0};
        System.out.println(canJump(nums));

    }
}
