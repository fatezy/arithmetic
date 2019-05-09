package interview;

import java.util.Arrays;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 合并两个有序数组 {

    //低级解法
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i <m+n ; i++) {
            nums1[i] = nums2[i-m];
        }

        Arrays.sort(nums1);

        return;
    }

    //高级解法，有序数组从后向前插
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int curr = m+n-1;
        int i = m-1;
        int j = n-1;
        while (i>=0&&j>=0){
            if (nums1[i] > nums2[j]){
                nums1[curr] = nums1[i];
                i--;
            }else {
                nums1[curr] = nums2[j];
                j--;
            }
            curr--;

        }

        if (j>=0){
            for (int k = 0; k <j+1 ; k++) {
                nums1[k] = nums2[k];
            }
        }


    }


}

 