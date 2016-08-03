package array;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/8/3  16:17
 */
//Given an unsorted integer array, find the first missing positive integer.
//
//        For example,
//        Given [1,2,0] return 3,
//        and [3,4,-1,1] return 2.
//
//        Your algorithm should run in O(n) time and uses constant space.
    //找出第一个丢失的正整数
public class FirstMissingPositive_41 {
    public static int firstMissingPositive(int[] nums) {
        int minest = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            int num = nums[i];
            map.put(num,num);
            if (num>0){
                if (num<minest){
                    secondMin = minest;
                    minest = num;
                }
                if (num>minest&&num<secondMin) secondMin = num;

            }
        }

        if (minest != Integer.MAX_VALUE){
            if (minest>1)
                return 1;
            if (secondMin-minest == 1){
                for (int i = secondMin+1; i <=Integer.MAX_VALUE ; i++) {
                    if (!map.containsKey(i)){
                        return i;
                    }
                }
            }else {

                return minest+1;
            }

        }
        return 1;
    }


    public static void main(String[] args) {

    }
}
