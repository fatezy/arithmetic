package 左程云;

//输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的
// 前序遍历和中序遍历的结果中都不含重复的数字。例如：前序遍历序列｛ 1, 2, 4, 7, 3, 5, 6, 8｝
// 和中序遍历序列｛4, 7, 2, 1, 5, 3, 8，6}，重建二叉树并输出它的头结点。


import leetcode.util.Tree;
import leetcode.util.TreeNode;

public class 重建二叉树 {


    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null){
            return null;
        }

        java.util.HashMap<Integer,Integer> map= new java.util.HashMap<Integer, Integer>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }

    public TreeNode preIn(int[] p,int pi,int pj,int[] n,int ni,int nj,java.util.HashMap<Integer,Integer> map){

        if(pi>pj){
            return null;
        }
        TreeNode head=new TreeNode(p[pi]);
        int index=map.get(p[pi]);
        head.left=preIn(p,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right=preIn(p,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }



}