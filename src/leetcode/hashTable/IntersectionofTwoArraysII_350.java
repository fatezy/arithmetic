package leetcode.hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/7/17  16:05
 */
//Given two arrays, write a function to compute their intersection.
//
//        Example:
//        Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
//
//        Note:
//        Each element in the result should appear as many times as it shows in both arrays.
//        The result can be in any order.
//        Follow up:
//        What if the given first.leetCode.array is already sorted? How would you optimize your algorithm?
//        What if nums1's size is small compared to nums2's size? Which algorithm is better?
//        What if elements of nums2 are stored on disk, and the memory is limited such that
// you cannot load all elements into the memory at once?
    //求两个数组的交集
public class IntersectionofTwoArraysII_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <nums1.length ; i++) {
            if (map1.containsKey(nums1[i])){
                map1.replace(nums1[i],map1.get(nums1[i])+1);
            }else {
                map1.put(nums1[i],1);
            }

        }

        for (int i = 0; i <nums2.length ; i++) {
            if (map2.containsKey(nums2[i])){
                map2.replace(nums2[i],map2.get(nums2[i])+1);
            }else {
                map2.put(nums2[i],1);
            }

        }

        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)){
                if (map1.get(key)>map2.get(key)){
                    for (int i = 0; i <map2.get(key) ; i++) {
                        list.add(key);
                    }
                }else {
                    for (int i = 0; i <map1.get(key) ; i++) {
                        list.add(key);
                    }
                }
            }

        }
        int[] res  = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            res[i] = list.get(i);

        }

        return res;
    }

    public static void main(String[] args) {

    }
}
