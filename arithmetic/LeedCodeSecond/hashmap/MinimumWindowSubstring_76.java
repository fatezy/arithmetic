package hashmap;

/**
 * author： 张亚飞
 * time：2016/10/20  23:13
 */
/*Given a string S and a string T, find the minimum window in S which will contain all the characters
in T in complexity O(n).
        For example,
        S = "ADOBECODEBANC"
        T = "ABC"
        Minimum window is "BANC".

        Note:
        If there is no such window in S that covers all characters in T, return the empty string "".

        If there are multiple such windows, you are guaranteed that there will always be only
                one unique minimum window in S*/
    //给你两个字符串找出第一个字符串包含第二个字符串最短子串
    /*解题思路：
    两点法：从左向右遍历，建立hash存储字符串t，同时记录t的长度·count，如果
    s中包含此字母则移除，当count等于0时，说明此字符串已包含所有的t中字母
    ，对一遍历的位置first指针进行右移操作
    * */
public class MinimumWindowSubstring_76 {
    //快慢指针法
    public static String minWindow(String s, String t) {
        int start =0;
        int end = 0;
        int count = t.length();
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int[] map = new int[256];
        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        for (int i = 0; i <tArr.length ; i++) {
            map[tArr[i]]++;
        }

        while (end<sArr.length){
            if (map[sArr[end]]>0){
                count--;
            }
            map[sArr[end]]--;
            while (count==0){

                if((end - start + 1) < minLength) {
                    minLength = end - start + 1;
                    minStart = start;
                }
                map[sArr[start]]++;
                if (map[sArr[start]]>0){
                    count++;
                }
                start++;

            }
            end++;
        }
        if( minStart+minLength > s.length())
        return "";
        return s.substring(minStart,minStart+minLength);
    }



//相同方法的不同演绎
    public String minWindow2(String S, String T) {
        if(S==null||S.isEmpty()||T==null||T.isEmpty()) return "";
        int i=0, j=0;
        int[] Tmap=new int[256];
        int[] Smap=new int[256];
        for(int k=0; k< T.length(); k++){
            Tmap[T.charAt(k)]++;
        }
        int found=0;
        int length=Integer.MAX_VALUE;
        String res="";
        while(j<S.length()){
            if(found<T.length()){
                if(Tmap[S.charAt(j)]>0){
                    Smap[S.charAt(j)]++;
                    if(Smap[S.charAt(j)]<=Tmap[S.charAt(j)]){
                        found++;
                    }
                }
                j++;
            }
            while(found==T.length()){
                if(j-i<length){
                    length=j-i; res=S.substring(i,j);
                }
                if(Tmap[S.charAt(i)]>0){
                    Smap[S.charAt(i)]--;
                    if(Smap[S.charAt(i)]<Tmap[S.charAt(i)]){
                        found--;
                    }
                }
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
    }
}
