/**
 * author： 张亚飞
 * time：2016/8/4  21:01
 */
//题目描述
//
//        利用字符重复出现的次数，编写一个方法，实现基本的字符串压缩功能。比如，字符串“aabcccccaaa”经
// 压缩会变成“a2b1c5a3”。若压缩后的字符串没有变短，则返回原先的字符串。
//        给定一个string iniString为待压缩的串(长度小于等于3000)，保证串内字符均由大小写英文字母组成，
// 返回一个string，为所求的压缩后或未变化的串。
//        测试样例
//        "aabcccccaaa"
//        返回："a2b1c5a3"
//        "welcometonowcoderrrrr"
//        返回："welcometonowcoderrrrr"
    //字符串压缩
public class Zipper {
    public static String zipString(String iniString) {
        String res = "";
        for (int i = 0; i <iniString.length() ; i++) {
            char c = iniString.charAt(i);
            int num = 0;
            for (int j = i; j <iniString.length() ; j++) {
                if (c == iniString.charAt(j)) {
                    if (j == iniString.length()-1){
                        num++;
                        res = res + c + num;
                        i = j;
                        break;
                    }
                    num++;
                }
                else {
                    res = res + c + num;
                    i = j-1;
                    break;
                }
            }

        }
        if (res.length()<iniString.length()) {
            return res;
        }else {
            return iniString;
        }
    }

    public static void main(String[] args) {
        System.out.println(zipString("aabcccccaaa"));
    }
}
