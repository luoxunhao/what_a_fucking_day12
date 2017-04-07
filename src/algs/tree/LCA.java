package algs.tree;

/**
 * Created by lxh on 2017/4/7.
 */
public class LCA {
    private static class Node{
        int val;
        Node left = null;
        Node right = null;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node lca(Node cur, Node o1, Node o2){
        if (cur == null || cur == o1 || cur == o2){
            return cur;
        }
        Node left = lca(cur.left,o1,o2);
        Node right = lca(cur.right,o1,o2);
        if (left != null && right != null){
            return cur;
        }
        return left != null ? left : right;
    }
}
