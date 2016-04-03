package array;

/**
 * author： 张亚飞
 * time：2016/4/3  12:43
 */
//Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
//        You may assume that each input would have exactly one solution.
//
//        Example:
//        Given nums = [2, 7, 11, 15], target = 9,
//
//        Because nums[0] + nums[1] = 2 + 7 = 9,
//        return [0, 1].
//        UPDATE (2016/2/13):
//        The return format had been changed to zero-based indices. Please read the above updated description carefully.
//
//        Subscribe to see which companies asked this question
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] results = new int[2];
        for (int i = 0; i <nums.length ; i++) {
            for (int j = 0; j <i ; j++) {
                if (nums[i]+nums[j]==target) {
                    results[0] = i;
                    results[1] = j;
                    return results;
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        TwoSum a = new TwoSum();
        int[] b = (a.twoSum(nums,9));
        for (int i:
             b) {
            System.out.println(i);
        }

    }
}
