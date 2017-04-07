package algs.tree;

import java.util.ArrayList;

/**
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 */
public class KthMaxNodeInBST {
    public static TreeNode KthNode(TreeNode pRoot, int k) {
        if (k < 1 || pRoot == null){
            return null;
        }
        ArrayList<TreeNode> inOrder = new ArrayList<>();
        inOrderTraverse(inOrder,pRoot);
        if (k <= inOrder.size()){
            return inOrder.get(k-1);
        }
        return null;
    }

    public static void inOrderTraverse(ArrayList<TreeNode> inOrder, TreeNode node){
        if (node == null){
            return;
        }
        inOrderTraverse(inOrder,node.left);
        inOrder.add(node);
        inOrderTraverse(inOrder,node.right);
    }
}
