package leetCode.DepthfirstSearch;

import leetCode.util.Tree;
import leetCode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author： 张亚飞
 * time：2016/6/4  20:19
 */
//Given a binary leetCode.tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
//
//        For example:
//        Given the below binary leetCode.tree and sum = 22,
//        5
//        / \
//        4   8
//        /   / \
//        11  13  4
//        /  \    / \
//        7    2  5   1
//        return
//        [
//        [5,4,11,2],
//        [5,8,4,5]
//        ]
    //得到所有可以达到目标值的路径
    //前序遍历
public class PathSumII_113 {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        addSum(root,lists,new ArrayList<>(),sum);
        return lists;

    }


    public static void addSum(TreeNode root,List<List<Integer>> lists,List<Integer> cur, int target){
        if (root == null) return;
            cur.add(root.val);
        if (root.right == null && root.left == null) {
            if (target == root.val) {
                lists.add(new ArrayList<>(cur));
              //  lists.remove(lists.size()-1);

            }else {
               // cur.remove(cur.size()-1);
            }
        }

        addSum(root.left,lists,cur,target-root.val);
        addSum(root.right,lists,cur,target-root.val);
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(new TreeNode(5));
        list.add(new TreeNode(4));
        list.add(new TreeNode(8));
        list.add(new TreeNode(11));
        list.add(null);
        list.add(new TreeNode(13));
        list.add(new TreeNode(4));
        list.add(new TreeNode(7));
        list.add(new TreeNode(2));
        list.add(null);
        list.add(null);
        list.add(new TreeNode(5));
        list.add(new TreeNode(1));
        Tree tree = new Tree();
        TreeNode node = tree.tree_init(list);
        pathSum(node,22);
    }
}
