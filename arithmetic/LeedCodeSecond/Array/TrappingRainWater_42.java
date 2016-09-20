package Array;

/**
 * author： 张亚飞
 * time：2016/9/20  10:24
 */
/*Given n non-negative integers representing an elevation map where the width of each bar is 1,
        compute how much water it is able to trap after raining.

        For example,
        Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.


        The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
        6 units of rain water (blue section) are being trapped.*/
    //可以囤积的水
    //类似于第十一题
public class TrappingRainWater_42 {
    public int trap(int[] height) {
        if (height.length<3) return 0;
        int l = 0;
        int r = height.length-1;
        while (l < r && height[l] <= height[l + 1]) l++;
        while (l < r && height[r] <= height[r - 1]) r--;
        int ans = 0;
        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= height[++l]) {
                    ans += left - height[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && height[--r] <= right) {
                    ans += right - height[r];
                }
            }
        }
        return ans;

    }


    public static void main(String[] args) {

    }
}
