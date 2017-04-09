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

    public static void getPath(ArrayList<LinkedList<Node>> paths, LinkedList<Node> path, Node root, Node node1, Node node2){
        if (root == null){
            return;
        }
        path.addFirst(root);
        if (root == node1 || root == node2){
            paths.add(new LinkedList<>(path));
            return;
        }
        getPath(paths,new LinkedList<>(path), root.left, node1,node2);
        getPath(paths,new LinkedList<>(path),root.right,node1,node2);
        path.pollFirst();
    }

    public static Node getLCA(ArrayList<LinkedList<Node>> paths){
        int len1 = paths.get(0).size();
        int len2 = paths.get(1).size();
        LinkedList<Node> large = len1 > len2 ? paths.get(0) : paths.get(1);
        LinkedList<Node> small = large == paths.get(0) ? paths.get(1) : paths.get(0);
        int len = large.size() - small.size();
        while (len-- > 0){
            large.pollFirst();
        }
        while (large.getFirst() != small.getFirst()){
            large.pollFirst();
            small.pollFirst();
        }
        return large.getFirst();
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
        LinkedList<Node> path = new LinkedList<>();
        ArrayList<LinkedList<Node>> paths = new ArrayList<>();
        getPath(paths, path, head, head.left.right, head.left.left);
        Node lca = getLCA(paths);
    }

}
