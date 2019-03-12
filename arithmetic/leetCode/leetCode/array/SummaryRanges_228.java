package leetCode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/4/21  15:46
 */
//Given a sorted integer leetCode.array without duplicates, return the summary of its ranges.
//
//        For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums.length==0){
            list.add(null);
            return list;
        }
        if (nums.length==1){
            list.add(String.valueOf(nums[0]));
            return  list;
        }
            int t = nums[0];
            String s = String.valueOf(nums[0]);
            for (int i=0;i<nums.length;i++){
                if (t++!= nums[i]){
                    list.add(s+="->"+nums[i-1]);
                    s = String.valueOf(nums[i]);
                    if (i<nums.length-1)
                    t = nums[i+1];
                    else
                        list.add(String.valueOf(nums[i]));

                }
            }

        return list;

    }



}
