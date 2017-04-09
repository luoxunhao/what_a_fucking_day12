package algs.dp.pack_problem;

/**
 * Created by lxh on 2017/4/9.
 */
public class TwoDim01Package {
    private static int[] W1;
    private static int[] W2;
    private static int[] C;
    private static int V1;
    private static int V2;
    private static int N;
    private static int[][][] dp1;
    private static int[][] dp2;

    public static int getDP1(){
        dp1 = new int[N+1][V1+1][V2+1];
        for (int i = 1; i <= N; i++){
            for (int j = W1[i]; j <= V1; j++){
                for (int k = W2[i]; k <= V2; k++){
                    dp1[i][j][k] = Math.max(dp1[i-1][j][k], C[i] + dp1[i-1][j-W1[i]][k-W2[i]]);
                }
            }
        }
        return dp1[N][V1][V2];
    }

    public static int getDP2(){
        dp2 = new int[V1+1][V2+1];
        for (int i = 1; i <= N; i++){
            for (int j = V1; j >= W1[i]; j--){
                for (int k = V2; k >= W2[i]; k--){
                    dp2[j][k] = Math.max(dp2[j][k], C[i] + dp2[j-W1[i]][k-W2[i]]);
                }
            }
        }
        return dp2[V1][V2];
    }
}
