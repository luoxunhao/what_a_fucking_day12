package algs.dfs;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
 */
//DFS深度优先搜索
public class PathSum {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.val = data;
        }
    }
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if (root == null){
            return null;
        }
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        dfs(paths,new ArrayList<Integer>(),root,target);
        return paths;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode node, int target){
        if (node == null){
            return;
        }
        path.add(node.val);
        if (target == node.val && node.left == null && node.right == null){
            paths.add(new ArrayList<>(path));
            return;
        }else if(target < node.val){
            return; //剪枝
        }
        dfs(paths, new ArrayList<>(path), node.left, target-node.val);
        dfs(paths, new ArrayList<>(path), node.right, target-node.val);
        path.remove(path.size()-1);
    }


    public static void main(String[] args) {
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.right = new TreeNode(12);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(7);
        head.left.left.left = new TreeNode(3);
        //FindPath1(head,22);
    }
}
