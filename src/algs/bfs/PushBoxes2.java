package algs.bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/11.
 */
public class PushBoxes2 {
    static class Status{
        int px;
        int py;
        int bx;
        int by;

        public Status(int px, int py, int bx, int by) {
            this.px = px;
            this.py = py;
            this.bx = bx;
            this.by = by;
        }
    }

    private static int[] dx = {-1,0,1,0};
    private static int[] dy = {0,1,0,-1};
    private static int[][][][] d = new int[10][9][10][9];
    private static char[][] map = new char[10][9];
    private static int n;
    private static int m;

    public static int bfs(){
        int spx=0,spy=0,sbx=0,sby=0,ex=0,ey=0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 'X'){
                    spx = i;
                    spy = j;
                }else if (map[i][j] == '@'){
                    ex = i;
                    ey = j;
                }else if (map[i][j] == '*'){
                    sbx = i;
                    sby = j;
                }
            }
        }
        LinkedList<Status> queue = new LinkedList<>();
        Status first = new Status(spx,spy,sbx,sby);
        d[spx][spy][sbx][sby] = 1;
        queue.addLast(first);
        while (!queue.isEmpty()){
            Status cur = queue.pollFirst();
            if (cur.bx == ex && cur.by == ey){
                return d[cur.px][cur.py][cur.bx][cur.by]-1;
            }
            for (int i = 0; i < 4; i++){
                int npx = cur.px + dx[i];
                int npy = cur.py + dy[i];
                if (npx < 0 || npx >= n || npy < 0 || npy >= m || map[npx][npy] == '#'){
                    continue;
                }
                if (npx == cur.bx && npy == cur.by){
                    int nbx = cur.bx + dx[i];
                    int nby = cur.by + dy[i];
                    if (nbx < 0 || nbx >= n || nby < 0 || nby >= m || map[nbx][nby] == '#'){
                        continue;
                    }
                    if (d[npx][npy][nbx][nby] == 0){
                        d[npx][npy][nbx][nby] = d[cur.px][cur.py][cur.bx][cur.by]+1;
                        Status next = new Status(npx,npy,nbx,nby);
                        queue.addLast(next);
                    }
                }else {
                    int nbx = cur.bx;
                    int nby = cur.by;
                    if (d[npx][npy][nbx][nby] == 0){
                        d[npx][npy][nbx][nby] = d[cur.px][cur.py][cur.bx][cur.by]+1;
                        Status next = new Status(npx,npy,nbx,nby);
                        queue.addLast(next);
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++){
                map[i] = sc.nextLine().toCharArray();
            }
            System.out.println(bfs());
        }
    }
}
