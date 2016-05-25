package Brainteaser;

/**
 * author： 张亚飞
 * time：2016/5/25  17:15
 */
//There are n bulbs that are initially off. You first turn on all the bulbs. Then, you turn off every second bulb. On the third round, you toggle every third bulb (turning on if it's off or turning off if it's on). For the ith round, you toggle every i bulb. For the nth round, you only toggle the last bulb. Find how many bulbs are on after n rounds.
//
//        Example:
//
//        Given n = 3.
//
//        At first, the three bulbs are [off, off, off].
//        After first round, the three bulbs are [on, on, on].
//        After second round, the three bulbs are [on, off, on].
//        After third round, the three bulbs are [on, off, off].
//
//        So you should return 1, because there is only one bulb is on.
    //最开始所有的开关都是关闭的，每一轮拨动第某一轮倍数的开关
public class BulbSwitcher_319 {
    //这题是真没意思，时间通不过
    public static int bulbSwitch(int n) {
        boolean[] bulbs = new boolean[n];
        for (int i = 1; i <=n ; i++) {
            for (int j = i; j <=n; j=j+i) {
                    bulbs[j-1] = !bulbs[j-1];
            }
        }
        int result = 0;
        for (int i = 0; i <bulbs.length ; i++) {
            if (bulbs[i] == true){
                result++;
            }
        }
        return result;

    }
//看了下例解
public static int bulbSwitch2(int n) {
  return (int)Math.sqrt(n);

}
    public static void main(String[] args) {
        bulbSwitch(5);
        System.out.println("ok");
    }
}
