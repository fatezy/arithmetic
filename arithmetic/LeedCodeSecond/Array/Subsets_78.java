package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/9/27  21:19
 */
/*Given a set of distinct integers, nums, return all possible subsets.

        Note: The solution set must not contain duplicate subsets.

        For example,
        If nums = [1,2,3], a solution is:

        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]*/
    //找出所有的组合
    //经典的回溯题
public class Subsets_78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private static void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
//input {1,2,3]  [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
// input {1,2,3,4}[[], [1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 4],
// [1, 3], [1, 3, 4], [1, 4], [2], [2, 3], [2, 3, 4], [2, 4], [3], [3, 4], [4]]

    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(subsets(nums));

    }
}
