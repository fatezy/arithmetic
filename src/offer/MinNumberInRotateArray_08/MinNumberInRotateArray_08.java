package offer.MinNumberInRotateArray_08;

/**
 * author： 张亚飞
 * time：2016/5/16  22:59
 */
//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
// 输入一个非递减序列的一个旋转，输出旋转数组的最小元素。
// 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
public class MinNumberInRotateArray_08 {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0){
            return 0;
        }
        int min = array[0];
        for (int i = 0; i <array.length ; i++) {
            if (array[i]<min){
                min = array[i];
                return min;
            }

        }
        return min;
    }
}
