package Array;

/**
 * author： 张亚飞
 * time：2016/9/28  21:49
 */
/*Follow up for "Remove Duplicates":
        What if duplicates are allowed at most twice?

        For example,
        Given sorted array nums = [1,1,1,2,2,3],

        Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
        It doesn't matter what you leave beyond the new length.*/
    //最多可以保留一个副本
public class RemoveDuplicatesfromSortedArrayII_80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length<3)  return nums.length;
        int place = 2;
        for (int i = 2; i <nums.length ; i++) {
            if (nums[i]!=nums[place-1]||nums[i]!=nums[place-2]){
                nums[place++] = nums[i];
            }
        }
        return place;
    }

    public static void main(String[] args) {

    }
}
