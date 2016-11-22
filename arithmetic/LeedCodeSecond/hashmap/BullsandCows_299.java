package hashmap;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/11/22  19:26
 */
//You are playing the following Bulls and Cows game with your friend: You write down a number
// and ask your friend to guess what the number is. Each time your friend makes a guess, you
// provide a hint that indicates how many digits in said guess match your secret number exactly
// in both digit and position (called "bulls") and how many digits match the secret number but
// locate in the wrong position (called "cows"). Your friend will use successive guesses and
// hints to eventually derive the secret number.
//
//        For example:
//
//        Secret number:  "1807"
//        Friend's guess: "7810"
//        Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
//        Write a function to return a hint according to the secret number and friend's guess,
// use A to indicate the bulls and B to indicate the cows. In the above example, your function
// should return "1A3B".
//
//        Please note that both secret number and friend's guess may contain duplicate digits,
// for example:
//
//        Secret number:  "1123"
//        Friend's guess: "0111"
//        In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your
// function should return "1A1B".
//        You may assume that the secret number and your friend's guess only contain digits, and
// their lengths are always equal.
    //给你一个字符串，判断有几个字母是位置正确且数字正确和有几个字母是位置错误但是字母正确
public class BullsandCows_299 {
    public static String getHint(String secret, String guess) {
        char[] secretChars = secret.toCharArray();
        char[] guessChars = guess.toCharArray();
        int bull = 0;
        int cow = 0;
        List<Integer> list = new ArrayList<>();
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <secretChars.length ; i++) {
          if (secretChars[i] == guessChars[i]){
              bull++;
              list.add(i);

          }else {
              if (!map.containsKey(secretChars[i])){
                  map.put(secretChars[i],1);
              }else {
                  map.put(secretChars[i],map.get(secretChars[i])+1);
              }
          }
        }


        for (int i = 0; i <guess.length() ; i++) {
            if (!list.contains(i)) {
                if (map.containsKey(guessChars[i])&&map.get(guessChars[i])>0){
                    cow++;
                    map.put(guessChars[i],map.get(guessChars[i])-1);
                }
            }
        }
        String res = bull+"A"+cow+"B";
        return res;
    }
    public static void main(String[] args) {
        System.out.println(getHint("1123", "0111"));

    }
}
