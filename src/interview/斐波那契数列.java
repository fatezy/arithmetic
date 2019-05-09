package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张亚飞 on 2019/5/9.
 */
public class 斐波那契数列 {
    public int Fibonacci(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        return helper(n,map);
    }


    public int helper(int n,Map<Integer,Integer> map){
        if (map.containsKey(n)){
            return map.get(n);
        }

        int val = helper(n-1,map)+helper(n-2,map);
        map.put(n,val);

        return map.get(n);
    }



    public static void main(String[] args) {
        System.out.println(new  斐波那契数列().Fibonacci(4));
    }
}

 