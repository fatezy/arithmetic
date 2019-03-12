package leetCode.util;


import java.util.LinkedList;

/**
 * author： 张亚飞
 * time：2016/6/4  20:32
 */
public class Tree {
    /**
     * 层序创建二叉树
     * @param tree
     * @return
     */
    public static TreeNode tree_init(LinkedList<TreeNode> tree){
        TreeNode head = tree.getFirst();
        for (int parentIndex = 0; parentIndex < tree.size() / 2 - 1; parentIndex++) {
            // 左孩子
            if (tree.get(parentIndex) !=null) {
                tree.get(parentIndex).left = tree
                        .get(parentIndex * 2 + 1);
                // 右孩子
                tree.get(parentIndex).right = tree
                        .get(parentIndex * 2 + 2);
            }
        }
        // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
        int lastParentIndex = tree.size() / 2 - 1;
        // 左孩子
        tree.get(lastParentIndex).left = tree
                .get(lastParentIndex * 2 + 1);
        // 右孩子,如果数组的长度为奇数才建立右孩子
        if (tree.size() % 2 == 1) {
            tree.get(lastParentIndex).right = tree
                    .get(lastParentIndex * 2 + 2);
        }
        return head;
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
        TreeNode node = tree_init(list);
               System.out.println(node.val);



    }

}
