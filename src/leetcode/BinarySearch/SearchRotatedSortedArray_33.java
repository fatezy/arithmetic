package leetcode.BinarySearch;

import org.junit.Test;

/**
 * author： 张亚飞
 * time：2016/4/30  22:49
 */
//Suppose a sorted first.leetCode.array is rotated at some pivot unknown to you beforehand.
//
//        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
//
//        You are given a target value to search. If found in the first.leetCode.array return its index, otherwise return -1.
    //题目解释：给你一个数组，但是你不知道是在哪一个位子进行了反转，给你一个目标值，出找出他的位置
public class SearchRotatedSortedArray_33 {
    //非二分法
    //虽然此种方法可以通过，但是并不符合出题人的二分的思想
    public int search(int[] nums, int target) {
        for ( int i = 0; i <nums.length ; i++) {
            if (nums[i]==target){
                return i;

            }

        }
        return -1;
    }

        //二分查找法,这个解法貌似并没怎么提升效率
    public int search2(int[] nums, int target) {
        int n = nums.length;
        if(n==0 || (n==1 && nums[0]!=target)) return -1;
        if(n==1 && nums[0]==target) return 0;
        int i = 0;
        //找到分界点
        for ( i =0;i<n-1;i++){
            if (nums[i]>nums[i+1]){
                break;
            }
        }
        int pivot = i; int low,high;
        if(pivot==n-1) return bSearch(0,n-1,target,nums);
        return target>=nums[0]?bSearch(0,pivot,target,nums):bSearch(pivot+1, n-1,target,nums);

    }

//标准二分搜索
    public int bSearch(int low, int high,int target ,int[] nums) {
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (target < nums[mid]) {
                high = mid - 1;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else return mid;
        }

        return -1;
    }


    //递归解法
    public int search3(int[] A, int target) {
        int len = A.length;
        if (len == 0) return -1;
        return binarySearch(A, 0, len-1, target);
    }

    public int binarySearch(int[] A, int left, int right, int target) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (A[left] == target) return left;
        if (A[mid] == target) return mid;
        if (A[right] == target) return right;

        //图示情况一
        if (A[left] < A[right]) {
            if (target < A[left] || target > A[right]) {    //target不在数组范围内
                return -1;
            } else if (target < A[mid]) {                   //target在左边
                return binarySearch(A, left+1, mid-1, target);
            } else {                                        //target在右边
                return binarySearch(A, mid+1, right-1, target);
            }
        }
        //图示情况二
        else if (A[left] < A[mid]) {
            if (target > A[left] && target < A[mid]) {      //target在左边
                return binarySearch(A, left+1, mid-1, target);
            } else {                                        //target在右边
                return binarySearch(A, mid+1, right-1, target);
            }
        }
        //图示情况三
        else {
            if (target > A[mid] && target < A[right]) {     //target在右边
                return binarySearch(A, mid+1, right-1, target);
            } else{                                         //target在左边
                return binarySearch(A, left+1, mid-1, target);
            }
        }
    }

    public int search4(int[] A, int target) {
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == A[mid]) return mid;
            if (A[l] <= A[r]) {
                if (target < A[mid]) r = mid - 1;
                else l = mid + 1;
            } else if (A[l] <= A[mid]) {
                if (target > A[mid] || target < A[l]) l = mid + 1;
                else r = mid - 1;
            } else {
                if (target < A[mid] || target > A[r]) r = mid - 1;
                else l = mid + 1;
            }
        }
        return -1;
    }

    @Test
  public void test(){
    int[] nums = {1,3};
    int t = 2;
    search2(nums,2);
    }



}
