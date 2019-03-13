/**
 * Created by 张亚飞 on 2019/3/13.
 */


//请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，
// 当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        String s = str.toString();
        return s.replaceAll(" ","%20");
    }
}

 