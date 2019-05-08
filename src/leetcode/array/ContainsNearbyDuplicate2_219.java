package leetCode.array;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/4/25  16:15
 */
//Given an first.leetCode.array of integers and an integer k,
//        find out whether there are two distinct indices i and j in the
// first.leetCode.array such that nums[i] = nums[j] and the difference between i and j is at most k.
    //给你一个数组，找出里面是否存在间隔最大为k且相等两个数
public class ContainsNearbyDuplicate2_219 {
    //超时
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length&&j<k+i;j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
    //超时
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1) {return false;}
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            //注，用value找key果然要跪
            if (map.containsValue(i)&&i-map.get(nums[i])<=k){
                return true;
            }else {
                map.put(nums[i],i);
            }

        }
        return false;
    }
    //key找value才是王道
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        if(nums.length <= 1) {return false;}
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            if (map.containsKey(nums[i])&&i-map.get(nums[i])<=k){
                return true;
            }else {
                map.put(nums[i],i);
            }

        }
        return false;
    }
    //优秀解法
    public boolean containsNearbyDuplicate4(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) {
                hs.remove(nums[i-k-1]);
            }
            if(!hs.add(nums[i])) return true;
        }
        return false;
    }


    @Test
    public void test(){
        int[] a ={99,99};
        System.out.println(containsNearbyDuplicate(a,2));

    }
}
