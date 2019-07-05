package 左程云;

public class 最长回文子串 {
    /**
     * 动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[i - 1][j + 1]))
                    dp[i][j] = true;
                if (dp[i][j] && (i - j + 1 > res.length())) {
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;

    }


    int x=0,y=0,max=1;

    /**
     * 递归
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        int n=s.length();
        if(n==0){return s;}
        char[] ch=s.toCharArray();
        int[][] dp=new int[n][n];
        recursion(ch,0,n-1,dp);
        return s.substring(x,y+1);
    }

    boolean recursion(char[] seq,int i,int j,int[][] dp){
        if(dp[i][j]!=0){
            return dp[i][j]==1?true:false;
        }
        if(i==j){            // 当前字母
            dp[i][j]=1; return true;
        }
        if(seq[i]==seq[j]&&j==i+1){   // 一个字母
            if(max<j-i+1){x=i;y=j;max=j-i+1;}
            dp[i][j]=1;return true;
        }
        if(seq[i]==seq[j] &&recursion(seq,i+1,j-1,dp)){
            if(max<j-i+1){x=i;y=j;max=j-i+1;}
            dp[i][j]=1;return true;
        }
        dp[i][j]=-1;
        boolean b1=recursion(seq,i,j-1,dp);
        boolean b2=recursion(seq,i+1,j,dp);
        return false;
    }


}
