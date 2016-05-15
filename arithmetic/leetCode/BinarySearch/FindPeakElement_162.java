package BinarySearch;

/**
 * author： 张亚飞
 * time：2016/5/15  15:27
 */
//A peak element is an element that is greater than its neighbors.
//
//        Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
//
//        The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
//
//        You may imagine that num[-1] = num[n] = -∞.
//
//        For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
    //找出最大的数的位置
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {

        if (nums.length == 0 )
            return Integer.MIN_VALUE;
        int max =  Integer.MIN_VALUE;
        int result = -1;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i]>=max){
                max = nums[i];
                result = i;
            }

        }
        return result;

    }

    public int findPeakElement2(int[] nums) {
        int N = nums.length;
        if (N == 1) {
            return 0;
        }

        int left = 0, right = N - 1;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (left == N - 1 || nums[left] > nums[left + 1]) ? left : right;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }

}
