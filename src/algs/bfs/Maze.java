package algs.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 公主被魔王抓走了 ， 王子需要拯救出美丽的公主 。 他进入了魔王的城
 堡 ， 魔王的城堡是一座很大的迷宫 。 为了使问题简单化 ， 我们假设这个迷宫是一
 个 N*M 的二维方格 。 迷宫里有一些墙 ， 王子不能通过 。 王子只能移动到相邻 （ 上
 下左右四个方向 ) 的方格内 ， 并且一秒只能移动一步 ， 就是说 ， 如果王子在 (x,y ）
 一步只能移动到 (x-1,y),(x+1,y),(x,y-1),(x,y+1) 其中的一个位置上。地图由
 ‘S’，‘P’，‘ . ’ ， ‘ *’ 四种符号构成 ， ‘ . ’ 表示王子可以通过 ， ‘ *’ 表示
 墙，王子不能通过；'S'表示王子的位置；‘P’表示公主的位置； n表示公主存活的剩余时间，王子必须在 n 秒
 内到达公主的位置，才能救活公主。
 */
public class Maze {
    private static final int n = 10;
    private static boolean[][] visited;  //用来记录当前顶点是否已经被访问过了
    private static char[][] map;
    private static int a[]={0,0,1,-1};
    private static int b[]={1,-1,0,0};
    private static int px, py, ex,ey, N, M; //记录地图初始化的起始点和结束点坐标

    /*
    状态类，表示当前王子的位置和最小路径
     */
    static class Status{
        int x;
        int y;
        int step; //记录王子在(x,y)这个顶点时的最小路径

        public Status(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void initMap(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++){
            map[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == 'S'){
                    px = i;
                    py = j;
                }else if (map[i][j] == 'P'){
                    ex = i;
                    ey = j;
                }
            }
        }
    }

    public static int BFS(){
        Queue<Status> queue = new LinkedList<>();
        Status begin = new Status(px, py);
        begin.step = 1;
        visited[px][py] = true;
        queue.offer(begin); //起始状态入列
        while (!queue.isEmpty()){
            Status cur = queue.poll(); //当前状态
            if (cur.x == ex && cur.y == ey){ //到达终点
                return cur.step - 1;
            }
            for (int i = 0; i < a.length; i++){ //往4个方向搜索，BFS
                int nx = cur.x + a[i], ny = cur.y + b[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '*') {continue;}
                if (!visited[nx][ny]){ //满足条件且没有被访问过的顶点
                    visited[nx][ny] = true; //状态设为已经被访问
                    Status next = new Status(nx, ny);
                    next.step = cur.step + 1;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        initMap();
        System.out.println(BFS());
    }

}
