package algs.tree;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/7.
 */
public class ReconstructTree {
    private static class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int[] preOrder;
    private static int[] inOrder;
    private static int n;
    private static HashMap<Integer, Integer> map;

    public static void init(){
        map = new HashMap<>();
        //key: 中序数组下标i对应的值    value:下标i
        for (int i = 0; i < n; i++){
            map.put(inOrder[i], i);
        }
    }

    /**
     *
     * @param pi preOrder[] 子树开始点
     * @param pj preOrder[] 子树结束点
     * @param ii inOrder[] 子树开始点
     * @param ij inOrder[] 子树结束点
     * @return
     */
    public static TreeNode solve(int pi, int pj,int ii, int ij){
        if (pi > pj){
            return null;
        }
        int tmp = preOrder[pi];
        TreeNode root = new TreeNode(tmp);
        int index = map.get(tmp);
        root.left = solve(pi+1,pi+index-ii,ii,index-1);
        root.right = solve(pi+index-ii+1,pj,index+1,ij);
        return root;
    }

    public static void printPre(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        printPre(root.left);
        printPre(root.right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            preOrder = new int[n];
            inOrder = new int[n];
            for (int i = 0; i < n ;i++){
                preOrder[i] = sc.nextInt();
            }
            for (int i = 0; i < n ;i++){
                inOrder[i] = sc.nextInt();
            }
            init();
            TreeNode root = solve(0,n-1,0,n-1);
            printPre(root);
        }
    }
}
