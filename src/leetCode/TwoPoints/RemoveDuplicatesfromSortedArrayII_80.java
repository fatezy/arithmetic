package leetCode.TwoPoints;

/**
 * author： 张亚飞
 * time：2016/5/14  21:25
 */
//Follow up for "Remove Duplicates":
//        What if duplicates are allowed at most twice?
//
//        For example,
//        Given sorted first.leetCode.array nums = [1,1,1,2,2,3],
//
//        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
    //所有的数据最多只能重复两次
public class RemoveDuplicatesfromSortedArrayII_80 {
    public static int removeDuplicates(int[] nums) {
        //表示目前的值
        int curr = Integer.MIN_VALUE;
        int t = 0;
        int times = 0;
        int[] results = new int[nums.length];
        for (int i = 0; i <nums.length ; i++) {
            if (curr != nums[i]){
                curr = nums [i];
                times =1;
                results[t] = curr;
                t++;
            }else {

                if (times ==1){
                    results[t] = curr;
                    times++;
                    t++;
                }
            }

        }
        for (int i = 0; i <nums.length ; i++) {
            nums[i] = results[i];
        }
        return t;
    }
    //优化了空间复杂度
    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int length = nums.length;
        int start = 0, times = 1;
        for (int i = 1; i < length; i++) {
            if (nums[i] != nums[start]) {
                start++;
                nums[start] = nums[i];
                times = 1;
            } else {
                times++;
                if (times == 2) {
                    start++;
                    nums[start] = nums[start - 1];
                }
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};

        System.out.println(removeDuplicates(a));
    }


}
