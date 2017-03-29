package algs.dp;

/**
 * Created by lxh on 2017/3/29.
 */
public class RobotMove {
    public static int countWays(int[][] map, int x, int y){
        int[][] dp = new int[x][y];
        //第一行
        for (int i = 0; i < y; i++){
            if (map[0][i] != 1){
                break;
            }
            dp[0][i] = 1;
        }
        //第一列
        for (int i = 0; i < x; i++){
            if (map[i][0] != 1){
                break;
            }
            dp[i][0] = 1;
        }
        //dp[i][j]
        for (int i = 1; i < x; i++){
            for (int j = 1; j < y; j++){
                if (map[i][j] != 1){
                    continue;
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[x-1][y-1];
    }
}
