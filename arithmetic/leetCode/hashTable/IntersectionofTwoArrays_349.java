package hashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * author： 张亚飞
 * time：2016/7/17  11:25
 */
//Given two arrays, write a function to compute their intersection.
//
//        Example:
//        Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
//
//        Note:
//        Each element in the result must be unique.
//        The result can be in any order.
    //求两个数组的交集
public class IntersectionofTwoArrays_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i <nums1.length ; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i <nums2.length ; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }

        }
        int[] res = new int[result.size()];
        int j = 0;
        for (int val:
             result) {
            res[j] = val;
            j++;
        }


        return res;
    }



    public static void main(String[] args) {
        int[] num1 = {1,2,3};
        int[] num2 = {3,4,5};
        intersection(num1,num2);

    }
}
