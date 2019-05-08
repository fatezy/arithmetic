package offer;

/**
 * author： 张亚飞
 * time：2016/7/13  23:08
 */
//题目：从1加到n不允许用循环，判断等条件语句
public class Temp_46 {
    static int result = 0;
    static int n = 0;
    public Temp_46(int a,int n){
        if (n>0){
            result += a;
            Temp_46 temp = new Temp_46(++a,--n);
        }


    }
//    public int getSum(int num){
//        return result;
//
//    }
    public static void main(String[] args) {
      Temp_46 temp_46 =  new Temp_46(1,3);
        System.out.println(result);
    }
}
