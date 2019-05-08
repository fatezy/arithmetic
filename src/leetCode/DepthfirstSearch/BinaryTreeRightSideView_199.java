package leetCode.DepthfirstSearch;

import leetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/6/7  15:57
 */
//Given a binary first.leetCode.tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
//        For example:
//        Given the following binary first.leetCode.tree,
//          1            <---
//        /   \
//       2     3         <---
//        \     \
//         5     4       <---
//        You should return [1, 3, 4].
    //从右向左看，写出从上到下可以看到的数
public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        levelRigth(root,0,result);
        return result;

    }

    public void levelRigth(TreeNode node, int currDepth, List<Integer> result){
        if (node == null){
            return;
        }

        if (currDepth == result.size()){
             result.add(node.val);
        }

        levelRigth(node.right,currDepth+1,result);
        levelRigth(node.left,currDepth+1,result);

    }
}
