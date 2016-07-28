package string;

/**
 * author： 张亚飞
 * time：2016/6/25  22:45
 */
//Implement atoi to convert a string to an integer.
    //// TODO: 2016/6/25
public class StringtoInteger_8 {
    //错误的解法,未跑完所有用例
    public static int myAtoi(String str) {
        try{
            int index =0;
            if(str.length() == 0) return 0;
            while(str.charAt(index) == ' ' && index < str.length())
                index ++;
            str = str.substring(index,str.length());

            for (int i = 0; i <str.length() ; i++) {
                char c = str.charAt(i);
                if (c == '+' || c=='-'){
                    continue;
                }
                if (c<'0'||c>'9'){
                    str = str.substring(0,i);
                }
            }
            return Integer.parseInt(str);
        }catch(Exception e){
            if (str.length() == 0) return 0;
            if (str.charAt(0) == '+' || str.charAt(0)=='-') return 0;
            if (str.charAt(0) == '+') return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
    }


    public int myAtoi2(String str) {
        int index = 0, sign = 1, total = 0;
        //1. Empty string
        if(str.length() == 0) return 0;

        //2. Remove Spaces
        while(str.charAt(index) == ' ' && index < str.length())
            index ++;

        //3. Handle signs
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index ++;
        }

        //4. Convert number and avoid overflow
        while(index < str.length()){
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;

            //check if total will be overflow after 10 times and add digit
            if(Integer.MAX_VALUE/10 < total || Integer.MAX_VALUE/10 == total && Integer.MAX_VALUE %10 < digit)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            total = 10 * total + digit;
            index ++;
        }
        return total * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("2147483648"));
    }
}
