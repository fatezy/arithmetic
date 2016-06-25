package string;

/**
 * author： 张亚飞
 * time：2016/6/25  22:45
 */
//Implement atoi to convert a string to an integer.
    //// TODO: 2016/6/25
public class StringtoInteger_8 {
    //错误的解法
    public int myAtoi(String str) {
        try{
            str = str.replaceAll(" ","");
            return Integer.parseInt(str);
        }catch(Exception e){
            return 0;
        }
    }
}
