import java.util.Stack;

/**
 * author： 张亚飞
 * time：2016/5/20  21:27
 */
//输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
// 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是
// 该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
public class IsPopOrder_22 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <pushA.length ; i++) {
            stack.push(pushA[i]);
            while (j<popA.length&&stack.peek()==popA[j]){
                stack.pop();
                j++;
            }

        }
        return stack.empty() ? true : false;
    }
}
