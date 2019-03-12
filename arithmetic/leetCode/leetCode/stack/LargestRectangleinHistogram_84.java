package leetCode.stack;

import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/8/5  20:33
 */
//Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
// find the area of largest rectangle in the histogram.
    //给你一个直方图，找出面积最大的一块矩阵
    //一道很难的题
public class LargestRectangleinHistogram_84 {
//    public static int largestRectangleArea(int[] height) {
//        int len = height.length;
//        Stack<Integer> s = new Stack<Integer>();
//        int maxArea = 0;
//        for(int i = 0; i <= len; i++){
//            int h = (i == len ? 0 : height[i]);
//            if(s.isEmpty() || h >= height[s.peek()]){
//                s.push(i);
//            }else{
//                int tp = s.pop();
//                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
//                i--;
//            }
//        }
//        return maxArea;
//    }

//从左往右遍历，用一个栈来存储递增的高度序列，如果发现高度递减，停止入栈，
// 并不断出栈以分别计算以之前栈内存放的每个高度作为最终高度的矩形面积

    public static int largestRectangleArea(int[] height) {
        if (height==null) return 0;//Should throw exception
        if (height.length==0) return 0;

        Stack<Integer> index= new Stack<Integer>();
        index.push(-1);
        int max=0;

        for  (int i=0;i<height.length;i++){
            //Start calculate the max value
            while (index.peek()>-1)
                if (height[index.peek()]>height[i]){
                    int top=index.pop();
                    max=Math.max(max,height[top]*(i-1-index.peek()));
                }else break;

            index.push(i);
        }
        //此时所有的剩下的都是递增的
        while(index.peek()!=-1){
            int top=index.pop();
            max=Math.max(max,height[top]*(height.length-1-index.peek()));
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(height));
    }

}
