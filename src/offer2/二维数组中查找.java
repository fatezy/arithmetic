package offer2;

/**
 * Created by 张亚飞 on 2019/3/13.
 */
//在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
// 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
public class 二维数组中查找 {
    public boolean Find(int target, int [][] array) {
        if (array == null){
            return false;
        }

        int m = array.length;
        int n = array[0].length;
        int i = m-1;
        int j = 0;
        while (i>=0 && j <n){
            if(target == array[i][j]){
                return true;
            }else if(target > array[i][j]){
                j = j +1;
            }else {
                i -= 1;
            }
        }
        return false;
    }
}

 