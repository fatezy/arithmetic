package leetCode.array;

/**
 * author： 张亚飞
 * time：2016/4/22  21:15
 */
//Given an leetCode.array of n integers where n > 1, nums, return an leetCode.array output such that output[i] is equal to the product of all the elements of nums except nums[i].
//
//        Solve it without division and in O(n).
//
//        For example, given [1,2,3,4], return [24,12,8,6].
    //求数组中的乘机除了第i个数之外的
public class ProductExceptSelf_238{
    public int[] productExceptSelf(int[] nums) {
        if (nums.length==0){
            return nums;
        }

        int pow = 1;
        int flag = 0;
        for (int ele: nums) {
            if (ele!=0) {
                pow = ele * pow;

            }
            if (ele==0){
                flag++;
            }
            if (flag == 2){
                for (int i = 0; i < nums.length; i++) {
                        nums[i] = 0;
                }
                return nums;
            }
        }

        if (flag == 1){
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0){
                    nums[i] = pow;
                }else {
                    nums[i] = 0;
                }
            }
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
                if (nums[i]!=0){
                nums[i] = pow / nums[i];
                }else {
                    nums[i] = pow;
                }
            }


        return nums;


    }

    public static void main(String[] args) {
        ProductExceptSelf_238 productExceptSelf_238 = new ProductExceptSelf_238();
        productExceptSelf_238.productExceptSelf(new int[]{2, 0, 3});
    }

}
