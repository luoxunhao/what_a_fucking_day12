package algs.dfs;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/6.
 */
public class LakeCount {
    private static char[][] map;
    private static int n,m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            sc.nextLine();
            map = new char[n][m];
            for (int i = 0; i < n; i++){
                map[i] = sc.next().toCharArray();
            }
            System.out.println(solve());
        }
    }
    public static void dps(int x, int y){
        map[x][y] = '.';
        for (int dx = -1; dx <=1; dx++){
            for (int dy = -1; dy <=1; dy++){
                int nx = x+dx, ny = y+dy;
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 'W'){
                    dps(nx,ny);
                }
            }
        }
    }
    public static int solve(){
        int res = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (map[i][j] == 'W'){
                    dps(i,j);
                    res++;
                }
            }
        }
        return res;
    }
}
