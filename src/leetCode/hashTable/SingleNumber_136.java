package leetCode.hashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/4/23  20:09
 */
//Given an first.leetCode.array of integers, every element appears twice except for one. Find that single one.
    //找到没有重复的那个数
public class SingleNumber_136 {
    //该方法超时，叫你烂
    public int singleNumber(int[] nums) {
         Arrays.sort(nums);
        if (nums.length==0)
            return 0;
        if (nums.length==1)
            return nums[0];
        for (int i = 0; i <nums.length ; i=i+2) {
            if (nums[i]!=nums[i+1]){
                return nums[i];
            }


        }

       return 0;
    }

//虽然效率不高，但是出结果通过了
    public int singleNumber3(int[] nums) {
        int sum = 0;
        for (int i:
             nums) {
            sum+=i;
        }
        Set<Integer> set = new HashSet<>();
        for (int i:
             nums) {
            set.add(i);
        }
        Integer sum2 =0 ;
        Iterator iterator  = set.iterator();
        while (iterator.hasNext()){
            sum2 += (int)iterator.next();
        }
        return sum2*2-sum;

    }


    //运算符逆天版
    //转化为二进制，相同返回0，不同返回1
    public int singleNumber2(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }

}
