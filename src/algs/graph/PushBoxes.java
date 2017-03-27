package algs.graph;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 推箱子
 *
 *
 每个测试输入包含1个测试用例
 第一行输入两个数字N，M表示地图的大小。其中0<N，M<=8。
 接下来有N行，每行包含M个字符表示该行地图。其中 . 表示空地、X表示玩家、*表示箱子、#表示障碍、@表示目的地。
 每个地图必定包含1个玩家、1个箱子、1个目的地。

 输出一个数字表示玩家最少需要移动多少步才能将游戏目标达成。当无论如何达成不了的时候，输出-1。
in:
 6 6
 ...#..
 ......
 #*##..
 ..##.#
 ..X...
 .@#...
out:
 11

 比迷宫问题多了一个箱子状态的判断，包括人碰到箱子，箱子碰到终点
 */

public class PushBoxes {

    /*
    状态类，记录当前游戏状态，包括人物坐标，箱子坐标以及当前状态下的最小路径
     */
    static class Status {
        int personx;
        int persony;
        int boxx;
        int boxy;
        int step;

        public Status(int personx, int persony, int boxx, int boxy) {
            this.personx = personx;
            this.persony = persony;
            this.boxx = boxx;
            this.boxy = boxy;
        }

    }

    private static int a[]={0,0,1,-1};
    private static int b[]={1,-1,0,0};

    private static boolean[][][][] visited;  //状态数组，用来记录当前状态是否已经被访问(personx,persony,boxx,boxy)
    private static char[][] map;
    private static int px, py, bx, by, ex, ey, N, M; //游戏开始时的人物、箱子以及终点坐标，地图大小

    public static void initMap(){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];
        visited = new boolean[N][M][N][M];
        for (int i = 0; i < N; i++){
            map[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (map[i][j] == '*'){
                    bx = i;
                    by = j;
                }else if (map[i][j] == 'X'){
                    px = i;
                    py = j;
                }else if (map[i][j] == '@'){
                    ex = i;
                    ey = j;
                }
            }
        }
    }

    public static int BFS(){
        Queue<Status> queue = new LinkedList<>();
        Status start = new Status(px, py, bx, by);
        start.step = 1;
        visited[px][py][bx][by] = true;
        queue.offer(start); //起始状态入列
        while (!queue.isEmpty()){
            Status cur = queue.poll(); //当前状态
            if (cur.boxx == ex && cur.boxy == ey){
                return cur.step - 1;
            }
            for (int i = 0; i < a.length; i++){
                int npx = cur.personx + a[i], npy = cur.persony + b[i];
                if (npx < 0 || npx >= N || npy < 0 || npy >= M || map[npx][npy] == '#'){continue;}
                if (npx == cur.boxx && npy == cur.boxy){
                    int nbx = npx + a[i], nby = npy + b[i];
                    if (nbx < 0 || nbx >= N || nby < 0 || nby >= M || map[nbx][nby] == '#'){continue;}
                    if (!visited[npx][npy][nbx][nby]){
                        visited[npx][npy][nbx][nby] = true;
                        Status next = new Status(npx, npy, nbx, nby);
                        next.step = cur.step + 1;
                        queue.offer(next);
                    }
                }else {
                    int nbx = cur.boxx, nby = cur.boxy;
                    if (!visited[npx][npy][nbx][nby]){
                        visited[npx][npy][nbx][nby] = true;
                        Status next = new Status(npx, npy, nbx, nby);
                        next.step = cur.step + 1;
                        queue.offer(next);
                    }
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
