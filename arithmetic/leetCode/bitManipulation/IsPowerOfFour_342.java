package bitManipulation;

/**
 * author： 张亚飞
 * time：2016/5/2  17:06
 */
//写一个函数韩端是不是4的次幂
public class IsPowerOfFour_342 {
    public boolean isPowerOfFour(int num) {
        if (num < 0) return false;
        /**判断是否是2的幂*/
        if ((num & (num - 1)) != 0) return false;
        /**是2的幂后,判断是否是4的幂*/
        if ((num & 0x55555555) != 0) return true;
        return false;
    }
    //num == (num & -num)判断末位是否为0，为0的是奇数
    public boolean isPowerOfFour3(int num) {
        return num > 0 && num == (num & -num) && num == (num & 0x55555555);
    }

}
