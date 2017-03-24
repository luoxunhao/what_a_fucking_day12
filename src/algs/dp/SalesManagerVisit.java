package algs.dp;

import java.util.Scanner;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/12cbdcdf5d1e4059b6ddd420de6342b6
 来源：牛客网

 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，
 但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案到达商家地址。
 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，0代表可以经过的地区，
 请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 测试样例：
 [[0,1,0],[2,0,0]],2,3
 返回：2
 */
public class SalesManagerVisit {
    public static int countPath(int[][] map, int n, int m){
        int bx = 0,by = 0,ex=0,ey=0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if (map[i][j] == 1){
                    bx = i;
                    by = j;
                }else if (map[i][j] == 2){
                    ex = i;
                    ey = j;
                }
            }
        }
        int yDir = ex > bx ? 1 : -1; //根据经理和商店位置决定水平和垂直方向
        int xDir = ey > by ? 1 : -1;
        //构造DP矩阵，dp[x][y]表示经理走到(x,y)的路径数
        int[][] dp = new int[n][m]; //已经初始化为不能走的位置路径数为0
        dp[bx][by] = 1;
        for (int y = by + xDir; y != ey + xDir; y += xDir){
            if (map[bx][y] == -1){
                break;
            }
            dp[bx][y] = 1;
        }
        for (int x = bx + yDir; x != ex + yDir; x += yDir){
            if (map[x][by] == -1){
                break;
            }
            dp[x][by] = 1;
        }
        for (int x = bx + yDir; x != ex + yDir; x += yDir){
            for (int y = by + xDir; y != ey + xDir; y += xDir){
                dp[x][y] = dp[x - yDir][y] + dp[x][y - xDir];
            }
        }
        return dp[ex][ey];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt(), m = sc.nextInt();
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            System.out.println(countPath(map, n, m));
        }
    }
}
