package leetCode.array;

/**
 * author： 张亚飞
 * time：2016/4/26  17:27
 */
//Given n non-negative integers a1, a2, ..., an,
// where each represents a point at coordinate (i, ai).
// n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
// which together with x-axis forms a container, such that the container contains the most water.
//
//        Note: You may not slant the container.
    //给了一组非负数，每个数代表一个点，向x轴做垂线，找两个垂线的容量最大
public class  ContainerWithMostWater_11 {
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right){
            maxArea = Math.max(maxArea,Math.min(height[left],height[right])*(right - left));
            if (height[left]<height[right]){
                left++;
            }else {
                right--;
            }

        }
        return maxArea;

    }



}
