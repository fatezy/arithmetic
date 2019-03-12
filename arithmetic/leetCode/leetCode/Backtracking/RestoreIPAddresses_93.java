package leetCode.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/8/6  11:58
 */
//Given a leetCode.string containing only digits, restore it by returning all possible
// valid IP address combinations.
//
//        For example:
//        Given "25525511135",
//
//        return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
    //给你一个字符串，看可以解析为多少个ip
public class RestoreIPAddresses_93 {
    public static List<String> restoreIpAddresses(String s) {
        return restore(new int[0], s);
    }

    private static List<String> restore(int[] tokens, String rest) {
        List<String> total = new ArrayList<>();
        if (tokens.length==4) {
            if ("".equals(rest)) {
                String ip = "";
                for (int i=0; i<4; i++) {
                    if (!"".equals(ip))
                        ip += '.';
                    ip += String.valueOf(tokens[i]);
                }
                total.add(ip);
            }

            return total;
        }

        for (int i=1; i<=3 && i<=rest.length(); i++) {
            String subStr = rest.substring(0, i);
            int sub = Integer.parseInt(subStr);
            if ((subStr.startsWith("0") && i>1) || sub>255)
                break;

            int[] ts = new int[tokens.length+1];
            System.arraycopy(tokens, 0, ts, 0, tokens.length);
            ts[tokens.length] = sub;

            total.addAll(restore(ts, rest.substring(i)));
        }

        return total;
    }


    public static void main(String[] args) {

    }
}
