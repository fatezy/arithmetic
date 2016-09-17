package Array;

/**
 * author： 张亚飞
 * time：2016/9/17  15:36
 */
/*Given n non-negative integers a1, a2, ..., an, where
 each represents a point at coordinate (i, ai). n vertical lines
 are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
  Find two lines, which together with x-axis forms a container, such that the
  container contains the most water.
        Note: You may not slant the container.*/
    //给你一个数组，没个数代表一个点，
// 向X轴做垂线，所能装载的水的体积

public class ContainerWithMostWaer_11 {
    /**
     * 双指针法，从两端向中间找最高的点，求他们所围成的面积
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0 ;
        int right = height.length -1;
        int maxArea = 0;
        while (left<right){
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right-left));
            if (height[left]<height[right]){
                left++;
            }else {
                right --;
            }
        }


        return maxArea;
    }

    public static void main(String[] args) {

    }
}
