package TwoPoints;

/**
 * author： 张亚飞
 * time：2016/5/14  21:25
 */
//Follow up for "Remove Duplicates":
//        What if duplicates are allowed at most twice?
//
//        For example,
//        Given sorted array nums = [1,1,1,2,2,3],
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

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};

        System.out.println(removeDuplicates(a));
    }


}
