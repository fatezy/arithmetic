import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * author： 张亚飞
 * time：2016/8/4  20:35
 */
//给定两个字符串，请编写程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
// 这里规定大小写为不同字符，且考虑字符串重点空格。
//        给定一个string stringA和一个string stringB，请返回一个bool，代表两串是否重新排列后可相同。
// 保证两串的长度都小于等于5000。
//        测试样例：
//        "This is nowcoder","is This nowcoder"
//        返回：true
//        "Here you are","Are you here"
//        返回：false
public class Same {
    public static boolean checkSam(String stringA, String stringB) {
        Map<String,Integer> map = new HashMap<>();
        String[] stringsA = stringA.split(" ");
        String[] stringsB = stringB.split(" ");
        for (String str:
            stringsA ) {
            if (map.containsKey(str)){
                map.replace(str,map.get(str)+1);
            }else {
                map.put(str,1);
            }
        }

        for (String str:
             stringsB) {
            if (map.containsKey(str)){
                map.replace(str,map.get(str)-1);
                if (map.get(str) == 0){
                    map.remove(str);
                }
            }else {
                return false;
            }
        }


        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(checkSam("This is nowcoder", "is This nowcoder"));

    }
}
