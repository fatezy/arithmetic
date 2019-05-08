package leetCode.array;

/**
 * 给出一个数组移除指定的数字，并返回移除后的长度
 * author： 张亚飞
 * time：2016/4/3 11:19
 */
//Given an first.leetCode.array and a value, remove all instances of that value in place and return the new length.
//
//        Do not allocate extra space for another first.leetCode.array, you must do this in place with constant memory.
//
//        The order of elements can be changed. It doesn't matter what you leave beyond the new length.
//
//        Example:
//        Given input first.leetCode.array nums = [3,2,2,3], val = 3
//
//        Your function should return length = 2, with the first two elements of nums being 2.
//
//        Show Hint

public class RemoveElement {
    /**
     * 移除指定的数字，并返回长度
     * @param nums 数组
     * @param val  参数
     * @return 长度
     */
    public int removeElement(int[] nums, int val) {
        if(nums == null){
            return 0;
        }
        int[] nums2 = new int[nums.length];
        int flag = 0;
        /**将需要的值付给nums2*/
        for (int num : nums) {
            if (val != num) {
                nums2[flag]=num;
                flag++;
            }

        }
        for (int i = 0; i <nums2.length ; i++) {
            nums[i] = nums2[i];
        }
        return flag;


    }
    public static void main(String[] args) {
        int[] nums= {3,2,2,3};
        RemoveElement a = new RemoveElement();
        System.out.println(a.removeElement(nums,3));

    }
}
