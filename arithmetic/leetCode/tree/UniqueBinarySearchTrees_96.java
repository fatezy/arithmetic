package tree;

/**
 * author： 张亚飞
 * time：2016/5/2  09:47
 */
//Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
//
//        For example,
//        Given n = 3, there are a total of 5 unique BST's.
//
//        1         3     3      2      1
//        \       /     /      / \      \
//        3     2     1      1   3      2
//        /     /       \                 \
//        2     1         2                 3
    //判断二叉排序树又多少种重构
//【解答】二叉搜索树的每一个节点都满足：如果有左孩子，那么左孩子小于自己；如果有右孩子，那么右孩子小于自己。
// 假设f(n)表示有多少棵树，利用动态规划：
//
//        当n=0，就一棵树（空树）；
//        当n=1，就一棵树；
//        当n=2，f(2) = 左子树f(0)*右子数f(1) + 左子树f(1)*右子数f(0)，即根节点可以取第一个数，也可以取第二个数，
// 总数就是这两种情况相加；
//        ……
//        当n=i，f(i) = Σ total(k)*total(i-1-k)，其中k=0..i-1。
    //动态规划
public class UniqueBinarySearchTrees_96 {
    public static int numTrees(int n) {
        if(n<0)
            throw new IllegalArgumentException();
        int[] total = new int[n+1];
        total[0]=total[1]=1;
        for(int i=2; i<=n; i++){
            for(int k=0; k<i; k++)
                total[i] += total[k]*total[i-1-k];
        }
        return total[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(3));
    }

}
