package offer;

/**
 * author： 张亚飞
 * time：2016/5/16  23:40
 */
//我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
// 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
    //本题其实还是fibonacci·的变种
public class RectCover_09 {
    public int RectCover(int target) {
        if (target ==0){
            return 0;
        }
        if (target == 1){
            return 1;
        }
        if (target == 2)
            return 2;
        return RectCover(target-1) +RectCover(target -2);

    }
}
