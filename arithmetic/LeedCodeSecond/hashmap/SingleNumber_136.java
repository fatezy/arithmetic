package hashmap;

/**
 * author： 张亚飞
 * time：2016/10/20  23:38
 */
/*Given an array of integers, every element appears twice except for one. Find that single one.

        Note:
        Your algorithm should have a linear runtime complexity. Could you implement
         it without using extra memory?*/
    //找出唯一一个出现一次的
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        int i =0;
        int res = 0;
        while (i<nums.length){
            res = res^nums[i];
            i++;
        }
        return res;
    }
}
