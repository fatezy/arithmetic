/**
 * Created by 张亚飞 on 2019/3/17.
 */

//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，
// 输出旋转数组的最小元素。 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的
// 所有元素都大于0，若数组大小为0，请返回0。
public class 旋转数组的最小数字 {
    public int minNumberInRotateArray(int [] array) {
        if (array == null){
            return -1;
        }
        if (array.length == 1){
            return array[0];
        }
        for (int i = 0; i <array.length-1 ; i++) {
            if (array[i]>array[i+1]){
                    return array[i+1];
            }
        }

        return array[0];

    }
}

