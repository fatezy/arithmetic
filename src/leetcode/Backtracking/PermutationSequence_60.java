package leetCode.Backtracking;

import java.util.ArrayList;

import java.util.List;

/**
 * author： 张亚飞
 * time：2016/7/20  21:19
 */
//The set [1,2,3,…,n] contains a total of n! unique permutations.
//
//        By listing and labeling all of the permutations in order,
//        We get the following sequence (ie, for n = 3):
//
//        "123"
//        "132"
//        "213"
//        "231"
//        "312"
//        "321"
//        Given n and k, return the kth permutation sequence.
//
//        Note: Given n will be between 1 and 9 inclusive.


    //给你个数n，得到它的全排列，然后得到第k个排列

public class PermutationSequence_60 {


    public static String getPermutation(int n, int k) {
        int pos = 0;
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n+1];
        StringBuilder sb = new StringBuilder();

        // create an first.leetCode.array of factorial lookup
        int sum = 1;
        factorial[0] = 1;
        for(int i=1; i<=n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        // factorial[] = {1, 1, 2, 6, 24, ... n!}

        // create a list of numbers to get indices
        for(int i=1; i<=n; i++){
            numbers.add(i);
        }
        // numbers = {1, 2, 3, 4}

        k--;

        for(int i = 1; i <= n; i++){
            int index = k/factorial[n-i];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k-=index*factorial[n-i];
        }

        return String.valueOf(sb);
    }






    //方法2超时
    public static String getPermutation2(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i <n ; i++) {
            nums[i] = i+1;
        }
        List<List<Integer>> lists = permute(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <lists.size() ; i++) {
            if (k == i+1){
                list = lists.get(i);
            }
        }
        String s ="";
        for (int i = 0; i <list.size() ; i++) {
            s += list.get(i);
        }
        return s;
    }


    public static List<List<Integer>> permute(int[] num) {
        List<Integer> src = new ArrayList<>();
        for (int i=0; i<num.length; i++) {
            src.add(num[i]);
        }

        List<Integer> l = new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        list.add(l);

        return permute(list, src);
    }
    //输入为（1，2，3）时，遍历的顺序为（1，2，3）（1，3，2）。。。。。
    private static List<List<Integer>> permute(List<List<Integer>> list, List<Integer> src) {
        if (src.isEmpty())
            return list;

        List<List<Integer>> total = new ArrayList<>();

        for (int i=0; i<src.size(); i++) {
            int num = src.get(i);
            List<Integer> newSrc = new ArrayList<>(src);
            newSrc.remove(i);
            List<List<Integer>> newList = new ArrayList<>();
            for (List<Integer> l : list) {
                List<Integer> copy = new ArrayList<Integer>(l);
                copy.add(num);
                newList.add(copy);
            }

            total.addAll(permute(newList, newSrc));

        }

        return total;
    }
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 5));
    }

}
