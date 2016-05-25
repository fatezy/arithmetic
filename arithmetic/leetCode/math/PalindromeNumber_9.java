package math;

/**
 * author： 张亚飞
 * time：2016/5/25  15:41
 */
//Determine whether an integer is a palindrome. Do this without extra space.
public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        //判断不为负
        if ((x>>31) == 1) {
            return false;
        }
        int ans = 0;
        int num = x;
        while ( num > 0) {
            ans = ans * 10 + num % 10;
            num = num / 10;
        }
        if (ans != x) return false;
        return true;
    }
}
