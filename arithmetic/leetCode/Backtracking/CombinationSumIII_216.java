package Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/6/3  20:06
 */
//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
//        Ensure that numbers within the set are sorted in ascending order.
//
//Example 1:
//
//        Input: k = 3, n = 7
//
//        Output:
//
//        [[1,2,4]]
//
//        Example 2:
//
//        Input: k = 3, n = 9
//
//        Output:
//
//        [[1,2,6], [1,3,5], [2,3,4]]
    //用1到9之间的数，k个相加为n
public class CombinationSumIII_216 {

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> lists = new ArrayList<>();
        combination(lists,new ArrayList<Integer>(),k,k,n,1);
        return lists;
    }


    public static void combination(List<List<Integer>>  result,List<Integer> cur,int k,int count,int n,int start){
       if (n>0){
           for (int i = start; i <=9&&n>=i ; i++) {
                cur.add(i);
               combination(result,cur,k-1,count,n-i,i+1);
               cur.remove(cur.size() - 1);
           }
       }else if (n==0&&cur.size()==count){
           result.add(new ArrayList<>(cur));
       }

    }

    public static void main(String[] args) {
        combinationSum3(3,9);
    }
}
