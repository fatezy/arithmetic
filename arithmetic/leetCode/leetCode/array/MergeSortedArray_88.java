package leetCode.array;

/**
 * 合并两个有序数组
 * author： 张亚飞
 * time：2016/4/3  15:55
 */
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted leetCode.array.
//
// Note:
//      You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
//      The number of elements initialized in nums1 and nums2 are m and n respectively.
public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m>0&&n>0){
            if (nums1[m-1]>nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            }else {
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        while (n>0){
            nums1[m+n-1] = nums2[n-1];
            n--;
        }

    }

    public static void main(String[] args) {
        int[] a = new int[10];
        a[0] =2;a[1] = 3;
        int[] b = {0,1,5};
        MergeSortedArray_88 mergeSortedArray88 = new MergeSortedArray_88();
        mergeSortedArray88.merge(a,2,b,3);
        System.out.println("d");

    }
}
