package leetcode.divideandConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/7/28  17:03
 */

//There are two sorted arrays nums1 and nums2 of size m and n respectively.
//
//        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
//
//        Example 1:
//        nums1 = [1, 3]
//        nums2 = [2]
//
//        The median is 2.0
//        Example 2:
//        nums1 = [1, 2]
//        nums2 = [3, 4]
//
//        The median is (2 + 3)/2 = 2.5

    //给你两个数组，找到两个数组中的中间值
public class MedianofTwoSortedArrays_4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int sizeOfNum1 = nums1.length;
        int sizeOfNum2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i<sizeOfNum1 || j<sizeOfNum2){
            if (i == sizeOfNum1&& j<sizeOfNum2){
                list.add(nums2[j]);
                j++;
                continue;
            }

            if (i<sizeOfNum1 && j==sizeOfNum2){
                list.add((nums1[i]));
                i++;
                continue;
            }
            if (nums1[i]>nums2[j]){
                list.add(nums2[j]);
                j++;
            }else {
                list.add((nums1[i]));
                i++;
            }
        }
        if (list.size()%2 != 0){
            return list.get(list.size()/2);
        }else {
            System.out.println(list.get(list.size()/2));
            System.out.println(list.get(list.size()/2-1));
            return (list.get(list.size()/2)+list.get(list.size()/2-1))/2.0;
        }

    }

    public static void main(String[] args) {
        int[] a ={1,2};
        int[] b ={3,4};
        System.out.println(findMedianSortedArrays(a, b));

    }
}
