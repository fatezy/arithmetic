package array;

/**
 * 所有的数据向右移动k位
 * author： 张亚飞
 * time：2016/4/4  09:59
 */
//Rotate an array of n elements to the right by k steps.
//
//        For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
//
//        Note:
//        Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
//        Could you do it in-place with O(1) extra space?

public class RotateArray_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray_189 rotate = new RotateArray_189();
        int[] test = {1,2,3,4,5,6};
        rotate.rotate(test,2);
        System.out.println(test.toString());

    }

}
