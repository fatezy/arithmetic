package offer2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张亚飞 on 2019/3/17.
 */
//一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。

public class 跳台阶 {
    public int JumpFloor(int target) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(2,2);
        helper(map,target);
        return map.get(target);
    }

    public int helper(Map<Integer,Integer> map,int i ){
        if(map.containsKey(i)){
            return map.get(i);
        }
        int val = helper(map,i-1)+helper(map,i-2);
        map.put(i,val);
        return val;
    }
}

 