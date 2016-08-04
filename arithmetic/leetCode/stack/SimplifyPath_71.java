package stack;

import java.util.*;

/**
 * author： 张亚飞
 * time：2016/8/4  12:15
 */
//Given an absolute path for a file (Unix-style), simplify it.
//
//        For example,
//        path = "/home/", => "/home"
//        path = "/a/./b/../../c/", => "/c"
    //简化路径
public class SimplifyPath_71 {
    //error
    public static String simplifyPath(String path) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <path.length() ; i++) {
            if (path.charAt(i) == '/'){
                if ((i<path.length()-3)){
                    if (path.charAt(i+1)=='.'&&path.charAt(i+2)=='.'){
                        if (!stack.empty()){
                            stack.pop();
                        }

                    }
                }
                if ((i<path.length()-2)){
                    if (Character.isAlphabetic(path.charAt(i+1))){
                        stack.push(path.charAt(i+1));
                    };
                }
            }

        }

        String s ="";
        while (!stack.empty()){
            s+=stack.pop();
        }
        String res = "";
        for (int i = 0; i <s.length() ; i++) {
            res+="/"+s.charAt(i);
        }
        if (res.length()==0){
            return "/";
        }
        return res;
    }

    public static String simplifyPath2(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
    }


    public static void main(String[] args) {
        System.out.println(simplifyPath2("/..."));

    }
}
