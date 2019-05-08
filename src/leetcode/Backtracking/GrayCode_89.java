package leetCode.Backtracking;

import java.util.ArrayList;

/**
 * author： 张亚飞
 * time：2016/7/24  15:35
 */
//The gray code is a binary numeral system where two successive values differ in only one bit.
//
//        Given a non-negative integer n representing the total number of bits in the code,
// print the sequence of gray code. A gray code sequence must begin with 0.
//
//        For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
//
//        00 - 0
//        01 - 1
//        11 - 3
//        10 - 2
//        Note:
//        For a given n, a gray code sequence is not uniquely defined.
//
//        For example, [0,2,3,1] is also a valid gray code sequence
// according to the above definition.
    //下一个数和上一个数仅有一bit的不同，给你个n，求格雷码
public class GrayCode_89 {
    public ArrayList<Integer> grayCode(int n) {
        if(n==0) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(0);
            return result;
        }

        ArrayList<Integer> tmp = grayCode(n-1);
        int addNumber = 1 << (n-1);
        ArrayList<Integer> result = new ArrayList<Integer>(tmp);
        for(int i=tmp.size()-1;i>=0;i--) {
            result.add(addNumber + tmp.get(i));
        }
        return result;
    }
}
