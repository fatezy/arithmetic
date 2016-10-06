package Array;

/**
 * author： 张亚飞
 * time：2016/10/6  17:27
 */
//Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
    //合并两个有序数组
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
            nums1[n-1] = nums2[n-1];
            n--;
        }

        return;
    }

    public static void main(String[] args) {

    }
}
