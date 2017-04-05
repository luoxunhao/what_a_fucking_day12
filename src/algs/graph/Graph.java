package algs.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by lxh on 2017/3/18.
 */
public class Graph {
    private static int number = 9;
    private static boolean[] visited;
    private static String[] vertexs = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
    private static int[][] edges = {
            { 0, 1, 0, 0, 0, 1, 1, 0, 0 },
            { 1, 0, 1, 0, 0, 0, 1, 0, 1 },
            { 0, 1, 0, 1, 0, 0, 0, 0, 1 },
            { 0, 0, 1, 0, 1, 0, 1, 1, 1 },
            { 0, 0, 0, 1, 0, 1, 0, 1, 0 },
            { 1, 0, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 1, 0, 1, 0, 1, 0 },
            { 0, 0, 0, 1, 1, 0, 1, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 0, 0 }
    };

    /**
     * DFS递归版本
     */
    public static void DFSTraverse(){
        visited = new boolean[number]; //初始化所有顶点状态为未访问
        for (int i = 0; i < number; i++){
            if (!visited[i]){ // 当前顶点没有被访问
                DFS(i);
            }
        }
    }

    /**
     * DFS核心
     * 思想就是树的前序遍历
     * @param i 第i个顶点
     */
    public static void DFS(int i){
        visited[i] = true; // 第i个顶点被访问
        System.out.print(vertexs[i] + " ");
        for (int j = 0; j < number; j++){
            if (!visited[j] && edges[i][j] == 1){ //第j个顶点没有被访问并且与i邻接
                DFS(j); //递归访问第j个顶点
            }
        }
    }

    /**
     * DFS非递归版本
     * 利用栈来实现树的前序遍历
     */
    public static void DFSMap(){
        visited = new boolean[number];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < number; i++){
            if (!visited[i]){
                visited[i] = true;
                System.out.print(vertexs[i] + " ");
                stack.push(i);
            }
            while (!stack.isEmpty()){
                int k = stack.pop();
                for (int j = 0; j < number; j++){
                    if (!visited[j] && edges[k][j] == 1){
                        visited[j] = true;
                        System.out.print(vertexs[j] + " ");
                        stack.push(j);
                        break;
                    }
                }
            }
        }
    }

    /**
     * BFS核心
     * 思想就是树的层序遍历
     * 区别：广度优先看起来和深度优先很相似，但是深度优先搜索是遇到一个满足条件的邻边元素就将其入栈，接着去判断该邻边元素的上下左右。
     * 而广度优先搜索是判断完某元素的上下左右四个元素并入队列以后才进行下一轮判断的。
     * 广度优先搜索就像波纹一样，以入口元素为中心，逐层搜索路径长度为1、为2、为3...的所有元素，从而最先出来的路径就是最短路径。
     */
    public static void BFSMap(){
        visited = new boolean[number];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < number; i++){
            if (!visited[i]){
                visited[i] = true;
                System.out.print(vertexs[i] + " ");
                queue.offer(i);
            }
            while (!queue.isEmpty()){
                int k = queue.poll();
                for (int j = 0; j < number; j++){
                    if (!visited[j] && edges[k][j] == 1){
                        visited[j] = true;
                        System.out.print(vertexs[j] + " ");
                        queue.offer(j); //所有邻接顶点都要入列
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        DFSTraverse();
        System.out.println();
        DFSMap();
        System.out.println();
        BFSMap();
    }
}
