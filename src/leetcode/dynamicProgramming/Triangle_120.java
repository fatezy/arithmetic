package leetcode.dynamicProgramming;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/7/24  21:10
 */
//Given a triangle, find the minimum path sum from top to bottom.
// Each step you may move to adjacent numbers on the row below.
//
//        For example, given the following triangle
//        [
//        [2],
//        [3,4],
//        [6,5,7],
//        [4,1,8,3]
//        ]
//        The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
//
//        Note:
//        Bonus point if you are able to do this using only O(n) extra space,
    //从三角形的顶部到底部的最短路径和
// where n is the total number of rows in the triangle.
public class Triangle_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        //用于存储到三角形每个点的最小路径值
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <triangle.size() ; i++) {
            int size = triangle.get(i).size();
            //存放每一行的路径和
            List<Integer> list = new ArrayList<>();
            List<Integer> tlever = triangle.get(i);


            for (int j = 0; j <size ; j++) {
                if (i == 0 && j == 0) {
                    list.add(tlever.get(j));
                }else if (i !=0 && j ==0){
                    List<Integer> lLastLever = lists.get(i-1);
                    list.add(lLastLever.get(j)+tlever.get(j));
                }else if (i!=0 && j!= 0 && j != size-1){
                    List<Integer> lLastLever = lists.get(i-1);
                    Integer val = Math.min(lLastLever.get(j-1)+tlever.get(j),lLastLever.get(j)+tlever.get(j));
                    list.add(val);

                }else if (i!=0 && j == size-1){
                    List<Integer> lLastLever = lists.get(i-1);
                    list.add(lLastLever.get(j-1)+tlever.get(j));
                }

            }

            lists.add(list);
        }

         Collections.sort(lists.get(lists.size()-1));



        return lists.get(lists.size()-1).get(0);

    }



    public int minimumTotal2(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();
       List<Integer> list = new ArrayList<>();
        list.add(2);
        lists.add(list);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);


        List<Integer> list3= new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);

        List<Integer> list4= new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);

        lists.add(list2);
        lists.add(list3);
        lists.add(list4);

        System.out.println(minimumTotal(lists));
        System.out.println("ok");










    }
}
