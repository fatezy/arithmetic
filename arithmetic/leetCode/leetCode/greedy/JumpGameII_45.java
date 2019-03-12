package leetCode.greedy;

/**
 * author： 张亚飞
 * time：2016/8/3  20:44
 */
//Given an leetCode.array of non-negative integers, you are initially positioned at
// the first index of the leetCode.array.
//
//        Each element in the leetCode.array represents your maximum jump length at that position.
//
//        Your goal is to reach the last index in the minimum number of jumps.
//
//        For example:
//        Given leetCode.array A = [2,3,1,1,4]
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

    public static int jump2(int[] A) {
        //代表步数
        int sc = 0;
        //代表当前这步可以到达的最远距离
        int e = 0;
        int max = 0;
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump2(nums));
    }
}
