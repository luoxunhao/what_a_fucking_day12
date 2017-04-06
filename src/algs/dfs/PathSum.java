package algs.dfs;

import algs.tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
    public static void pathSum(TreeNode root, int sum, List<List<Integer>> result, LinkedList<Integer> path){
        path.addLast(root.val);
        if (root.left == null && root.right == null && root.val == sum){
            result.add(new LinkedList<>(path));
        }
        if (root.left != null){
            pathSum(root.left, sum - root.val, result, path);
        }
        if (root.right != null){
            pathSum(root.right, sum - root.val, result, path);
        }
        path.pollLast();
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null){
            return result;
        }
        LinkedList<Integer> path = new LinkedList<>();
        pathSum(root, sum, result, path);
        return result;
    }

    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target){
        if (root == null){
            return null;
        }
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        dps(paths,new ArrayList<Integer>(),root,target);
        return paths;
    }

    public static void dps(ArrayList<ArrayList<Integer>> paths, ArrayList<Integer> path, TreeNode node, int target){
        if (node == null){
            return;
        }
        path.add(node.val);
        if (target == node.val && node.left == null && node.right == null){
            paths.add(new ArrayList<>(path));
            return;
        }else if(target < node.val){
            return;
        }
        dps(paths, new ArrayList<>(path), node.left, target-node.val);
        dps(paths, new ArrayList<>(path), node.right, target-node.val);
        path.remove(path.size()-1);
    }
}
