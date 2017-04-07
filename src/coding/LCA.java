package coding;

/**
 * 求二叉树的任意两个节点的最近公共祖先
 */
public class LCA {
    public static TreeNode lca(TreeNode root, TreeNode node1, TreeNode node2){
        if (root == null || root == node1 || root == node2){
            return root;
        }
        TreeNode leftTree = lca(root.left, node1, node2);
        TreeNode rightTree = lca(root.right, node1, node2);
        if (leftTree != null && rightTree != null){
            return root;
        }
        return leftTree != null ? leftTree : rightTree;
    }

    // for test -- print tree
    public static void printTree(TreeNode head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        head.right.right.left = new TreeNode(8);
        printTree(head);
        System.out.println("===============");

        TreeNode o1 = head.left.left;
        TreeNode o2 = head.right.right.left;

        // 单次查询--原问题
        System.out.println("o1 : " + o1.val);
        System.out.println("o2 : " + o2.val);
        System.out.println("ancestor : " + lca(head, o1, o2).val);
        System.out.println("===============");
    }
}
