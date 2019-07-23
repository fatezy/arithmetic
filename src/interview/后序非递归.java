package interview;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by 张亚飞 on 2019/7/23.
 */
public class 后序非递归 {
    public List<Integer> postorderTraversal(TreeNode root) {//非递归写法
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if((curr.left == null && curr.right == null) ||
                    (pre != null && (pre == curr.left || pre == curr.right))){
                //如果当前结点左右子节点为空或上一个访问的结点为当前结点的子节点时，当前结点出栈
                res.add(curr.val);
                pre = curr;
                stack.pop();
            }else{
                if(curr.right != null) stack.push(curr.right); //先将右结点压栈
                if(curr.left != null) stack.push(curr.left);   //再将左结点入栈
            }
        }
        return res;
    }

}

 