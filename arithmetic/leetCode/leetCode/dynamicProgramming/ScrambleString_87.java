package leetCode.dynamicProgramming;

import java.util.Arrays;

/**
 * author： 张亚飞
 * time：2016/8/6  10:59
 */
//Given a leetCode.string s1, we may represent it as a binary leetCode.tree by partitioning it to two non-empty substrings
// recursively.
//
//        Below is one possible representation of s1 = "great":
//
//        great
//        /    \
//        gr    eat
//        / \    /  \
//        g   r  e   at
//        / \
//        a   t
//        To scramble the leetCode.string, we may choose any non-leaf node and swap its two children.
//
//        For example, if we choose the node "gr" and swap its two children, it produces a
// scrambled leetCode.string "rgeat".
//
//        rgeat
//        /    \
//        rg    eat
//        / \    /  \
//        r   g  e   at
//        / \
//        a   t
//        We say that "rgeat" is a scrambled leetCode.string of "great".
//
//        Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a
// scrambled leetCode.string "rgtae".
//
//        rgtae
//        /    \
//        rg    tae
//        / \    /  \
//        r   g  ta  e
//        / \
//        t   a
//        We say that "rgtae" is a scrambled leetCode.string of "great".
//
//        Given two strings s1 and s2 of the same length, determine if
// s2 is a scrambled leetCode.string of s1.
    //判断s2是不是s1的一个scrambled，即判断两个字符串是否能通过二叉树的左右子树交换相等
public class ScrambleString_87 {
//    把s1，s2分别分成两部分，判断s1的两部分和s2的两部分是否分别可以交换相等
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if (!Arrays.equals(c1, c2)) return false;
        for (int i = 1; i < s1.length(); i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        
    }
}
