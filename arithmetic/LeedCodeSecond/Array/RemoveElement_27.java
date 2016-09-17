package Array;

/**
 * author： 张亚飞
 * time：2016/9/17  17:20
 */
/*Given an array and a value, remove all instances of that value in place and return the new length.

        Do not allocate extra space for another array, you must do this in place with constant memory.

        The order of elements can be changed. It doesn't matter what you leave beyond the new length.*/
    //给你一个数组，移除目标值
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        int num = 0;
        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == val){
                continue;
            }else {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }
}
