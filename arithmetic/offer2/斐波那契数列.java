import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 张亚飞 on 2019/3/17.
 */

//题目描述
//        大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
//        n<=39
public class 斐波那契数列 {

    public int Fibonacci(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        helper(map,n);
        return map.get(n);
    }

    public int helper(Map<Integer,Integer> map,int i ){
        if (map.containsKey(i)){
            return map.get(i);
        }
        Integer res = helper(map,i-1)+helper(map,i-2);
        map.put(i,res);
        return res;

    }

    public static void main(String[] args) {
        斐波那契数列 a = new 斐波那契数列();
        System.out.println(a.Fibonacci(6));
    }
}

 