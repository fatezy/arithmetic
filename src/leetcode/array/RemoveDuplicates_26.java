package leetcode.array;

/**
 * author： 张亚飞
 * time：2016/4/3  13:12
 */
//Given a sorted first.leetCode.array, remove the duplicates in place such that each element appear only once and return the new length.
//
//        Do not allocate extra space for another first.leetCode.array, you must do this in place with constant memory.
//
//        For example,
//        Given input first.leetCode.array nums = [1,1,2],
//
//        Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
public class RemoveDuplicates_26 {
    /**
     * 从有序数组中移除相同的数据
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int num = 1;
        for(int i = 0; i < nums.length-1; ++i){
            if(nums[i] == nums[i+1]){
                continue;
            }else{
                nums[num] = nums[i+1];
                num++;
            }
        }
        return num;


    }

    public static void main(String[] args) {
        RemoveDuplicates_26 test = new RemoveDuplicates_26();
        int[] nums = {1,2,2,3,3,4,5};
        System.out.println(test.removeDuplicates(nums));

    }
}
