package algs.tree;

/**
 * Created by lxh on 2017/4/7.
 */
public class IsAHasB {
    public static boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return fun(root1,root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    public static boolean fun(TreeNode root1,TreeNode root2){
        if (root2 == null){
            return true;
        }
        if (root1 == null){
            return false;
        }
        if (root1.val != root2.val){
            return false;
        }
        return fun(root1.left, root2.left) && fun(root1.right, root2.right);
    }
}
