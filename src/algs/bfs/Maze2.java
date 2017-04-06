package algs.bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 迷宫的最短路径
 */
public class Maze2 {
    private static char[][] map;
    private static int[][] d; //d[][]既是距离矩阵，也是标志矩阵
    private static int n,m,sx,sy,gx,gy;
    private static int[] dx = {1,0,-1,0};
    private static int[] dy = {0,1,0,-1};
    private static int max = Integer.MAX_VALUE;

    private static class Status{
        int x;
        int y;
        Status(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();
            map = new char[n][m];
            d = new int[n][m];
            for (int i = 0; i < n; i++){
                map[i] = sc.next().toCharArray();
            }
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    d[i][j] = max;
                    if (map[i][j] == 'S'){
                        sx = i;
                        sy = j;
                    }else if (map[i][j] == 'G'){
                        gx = i;
                        gy = j;
                    }
                }
            }
            System.out.println(bfs());
        }
    }

    public static int bfs(){
        LinkedList<Status> queue = new LinkedList<>();
        Status cur = new Status(sx,sy);
        queue.addLast(cur);
        d[sx][sy] = 0;
        while (!queue.isEmpty()){
            cur = queue.pollFirst();
            if (cur.x == gx && cur.y == gy){
                break;
            }
            for (int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >=0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != '#' && d[nx][ny] == max){ //d[nx][ny] == max是否被访问过
                    d[nx][ny] = d[cur.x][cur.y] + 1;
                    queue.addLast(new Status(nx,ny));
                }
            }
        }
        return d[gx][gy];
    }
}
