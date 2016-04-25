package array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/4/25  17:09
 */
//Given numRows, generate the first numRows of Pascal's triangle.
//
//        For example, given numRows = 5,
//        Return
//
//        [
//        [1],
//        [1,1],
//        [1,2,1],
//        [1,3,3,1],
//        [1,4,6,4,1]
//        ]
    //杨辉三角
public class PascalTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> firstLine  = new ArrayList<Integer>();
        firstLine.add(1);
        list.add(firstLine);
        numRows++;
        for (int i = 1; i <numRows ; i++) {
            list.add( new ArrayList<Integer>());
            for (int j = 0;j<i;j++){
                if ((j == 0) || (j == i-1)){
                    list.get(i).add(j,1);
                }else {
                    list.get(i).add(j,list.get(i-1).get(j)+list.get(i-1).get(j-1));
                }
            }
        }
        list.remove(0);
        return list;

    }
    @Test
    public void test(){
        generate(4);

    }


}
