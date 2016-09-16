package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/9/16  22:59
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
//找出两个有序数组的中值
    //心得：多个数组同时操作不适用for循环
    //int 转 double 除以或乘以1.0

public class MedianofTwoSortedArrays_4 {
    //同时遍历两个数组挑小的的先遍历
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i= 0;
        int j =0;
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<Integer> list = new ArrayList<>();
        while (i<len1 || j<len2){
            if (i==len1&&j<len2){
                list.add(nums2[j]);
                j++;
                continue;
            }
            if (j==len2 && i<len1){
                list.add(nums1[i]);
                i++;
                continue;
            }
            if (nums1[i]>nums2[j]){
                list.add(nums2[j]);
                j++;
            }else {
                list.add(nums1[i]);
                i++;
            }
        }

        if (list.size()%2 == 1){
            return list.get(list.size()/2);
        }else {
            return list.get(list.size()/2+list.size()/2-1)/2.0;
        }

    }


    public static void main(String[] args) {

    }
}
