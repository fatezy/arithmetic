package leetCode.string;

/**
 * author： 张亚飞
 * time：2016/4/21  16:31
 */
//Given a first.leetCode.string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
//
//        For example,
//        "A man, a plan, a canal: Panama" is a palindrome.
//        "race a car" is not a palindrome.
    //判断是否回文
public class IsPalindrome_125 {
    //// TODO: 2016/4/21 error 
    public boolean isPalindrome(String s) {
        if (s.length()==0){
            return false;
        }else {
            s= s.replace(" ","");
            s= s.toLowerCase();
           for (int i =0;i<s.length();i++){

           }
            for (int i =0;i<s.length()/2;i++){
                if (s.charAt(i)!= s.charAt(s.length()-i-1))
                    return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome2(String s) {
        if (s == null)
            return false;
        if (s.length() == 0)
            return true;
        int low = 0, high = s.length() - 1;
        s = s.toLowerCase();
        while (low < high) {
            while (low < high && !Character.isLetterOrDigit(s.charAt(low)))
                low++;

            while (low < high && !Character.isLetterOrDigit(s.charAt(high)))
                high--;

            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        IsPalindrome_125 isPalindrome_125 = new IsPalindrome_125();
        isPalindrome_125.isPalindrome("A mana plan a canal Panama");
    }

}
