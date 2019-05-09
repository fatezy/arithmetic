package interview;

//给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//        [1,2,3],
//        [1,3,2],
//        [2,1,3],
//        [2,3,1],
//        [3,1,2],
//        [3,2,1]
//        ]
//


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 全排列 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(res,temp,nums);
        return res;
    }

    public void helper(List<List<Integer>> res,List<Integer> temp,int[] nums){
        if (temp.size() == nums.length){
            List<Integer> l = new ArrayList<>();
            l.addAll(temp);
            res.add(l);
            return;
        }
        for (int i = 0; i <nums.length ; i++) {
            if (!temp.contains(nums[i])){
                temp.add(nums[i]);
                helper(res,temp,nums);
                temp.remove(temp.size()-1);
            }

        }

    }



    List<List<Integer>> list;

    public List<List<Integer>> permute2(int[] nums) {

        list = new ArrayList<>();
        ArrayList<Integer> perm = new ArrayList<Integer>();
        backTrack(perm,0,nums);
        return list;
    }

    void backTrack (ArrayList<Integer> perm,int i,int[] nums){

        //Permutation completes
        if(i==nums.length){
            list.add(new ArrayList(perm));
            return;
        }

        ArrayList<Integer> newPerm = new ArrayList<Integer>(perm);

        //Insert elements in the array by increasing index
        for(int j=0;j<=i;j++){
            newPerm.add(j,nums[i]);
            backTrack(newPerm,i+1,nums);
            newPerm.remove(j);
        }

    }


    public static void main(String[] args) {
        全排列 test =new 全排列();
        int[] a = {1,2,3};
        System.out.println(test.permute(a));
    }
}

 