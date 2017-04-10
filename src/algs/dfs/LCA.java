package algs.dfs;

import java.util.LinkedList;


public class LCA {
    private static int[][] graph = new int[1001][1001];
    private static boolean[] visit = new boolean[1001];
    private static int n;

    public static int getSplitNode(String[] matrix, int indexA, int indexB) {
        n = matrix.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                graph[i][j] = Integer.parseInt(String.valueOf(matrix[i].charAt(j)));
            }
        }
        LinkedList<Integer> path1 = new LinkedList<>();
        path1.add(0);
        LinkedList<Integer> path2 = new LinkedList<>();
        path2.add(0);
        dfs(path1, 0, indexA);
        dfs(path2, 0, indexB);
        int lca = 0;
        while (!path1.isEmpty() && !path2.isEmpty()){
            if (path1.getFirst() == path2.getFirst()){
                lca = path1.getFirst();
            }
            path1.pollFirst();
            path2.pollFirst();
        }
        return lca;
    }


    public static boolean dfs(LinkedList<Integer> path, int i, int index){
        if (path.getLast() == index){
            return true;
        }
        for (int j = 0; j < n; j++){
            if (graph[i][j] == 1 && !path.contains(j)){
                path.add(j);
                if (dfs(path,j,index)){
                    return true;
                }
                path.pollLast();
            }
        }
        return false;
    }

    public static void main(String[] args){
        String[] matrix = {"01011","10100","01000","10000","10000"};
        getSplitNode(matrix,2,3);
    }
}
