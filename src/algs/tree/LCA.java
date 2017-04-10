package algs.tree;

import java.util.ArrayList;
import java.util.LinkedList;

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

    public static Node getLCA(LinkedList<Node> path1, LinkedList<Node> path2){
        Node lca = null;
        while (!path1.isEmpty() && !path2.isEmpty()){
            if (path1.getFirst() == path2.getFirst()){
                lca = path1.getFirst();
            }
            path1.pollFirst();
            path2.pollFirst();
        }
        return lca;
    }

    /*
    可以用在多叉树的lca上
     */
    public static boolean getNodePath(LinkedList<Node> path, Node root, Node node){
        if (root == null){
            return false;
        }
        path.add(root);
        if (root == node){
            return true;
        }
        boolean find = false;
        find = getNodePath(path,root.left,node);
        if (!find){
            find = getNodePath(path,root.right,node);
        }
        if (!find){
            path.pollLast();
        }
        return find;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        System.out.println("===============");

        Node o1 = head.left.right;
        Node o2 = head.right.left;

        // 单次查询--原问题
        System.out.println("o1 : " + o1.val);
        System.out.println("o2 : " + o2.val);
        System.out.println("===============");
        LinkedList<Node> path2 = new LinkedList<>();
        LinkedList<Node> path1 = new LinkedList<>();
        getNodePath(path1,head,head.left.right);
        getNodePath(path2,head,head.right.right.left);
        Node lca = getLCA(path1,path2);
    }

}
