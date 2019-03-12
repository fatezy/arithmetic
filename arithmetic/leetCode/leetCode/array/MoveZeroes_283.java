package leetCode.array;

/**就地移动数组中的0到最后
 * author： 张亚飞
 * time：2016/4/3  14:19
 */
//Given an leetCode.array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//        For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
//
//        Note:
//        You must do this in-place without making a copy of the leetCode.array.
//        Minimize the total number of operations.
public class MoveZeroes_283 {
    public void moveZeroes(int[] nums) {
        if(nums.length<2){
            return;
        }
        int num = 0;
        for (int i=0;i<nums.length;i++){
          if(nums[i]!=0){
              nums[num]=nums[i];
              num++;

          }
        }
        for (int i=num;i<nums.length;i++){
            nums[i]= 0;
        }

    }


    public static void main(String[] args) {
        MoveZeroes_283 move = new MoveZeroes_283();
        int[] nums = {0,1,0,3,12};
        move.moveZeroes(nums);
        System.out.println("ok");

    }

}
