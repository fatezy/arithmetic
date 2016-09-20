package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/9/18  23:37
 */
/*Given an unsorted integer array, find the first missing positive integer.

        For example,
        Given [1,2,0] return 3,
        and [3,4,-1,1] return 2.*/
    //找出第一个缺失的正数
public class FirstMissingPositive_41 {
    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0 ) return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i <nums.length ; i++) {
            map.put(nums[i],nums[i]);
        }

        for (int i = 1; i <=nums.length ; i++) {
            if (!map.containsKey(i)){
                return i;
            }
        }
        return nums.length;
    }



    public static int firstMissingPositive2(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private  static void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        firstMissingPositive2(nums);

    }
}
