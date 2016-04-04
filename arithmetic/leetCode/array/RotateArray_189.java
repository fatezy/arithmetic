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
    //TODO  奇数可以，偶数不可以
public class RotateArray_189 {
    /**
     * 所有的数据向右移动k位
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int temp = nums[0];
        int temp2 = 0;
        int t = 0;
        for (int i = 0; t<nums.length ; i=i+k) {
            temp2 = nums[(i+k)%nums.length];
            nums[(i+k)%nums.length] = temp;
            temp = temp2;
            t++;

        }
    }

    public static void main(String[] args) {
        RotateArray_189 rotate = new RotateArray_189();
        int[] test = {1,2,3,4,5,6};
        rotate.rotate(test,2);
        System.out.println(test.toString());

    }

}
