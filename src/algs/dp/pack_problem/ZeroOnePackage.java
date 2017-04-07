package algs.dp.pack_problem;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/7.
 */
public class ZeroOnePackage {
    private static int[] weight;
    private static int[] value;
    private static int N;
    private static int V;
    private static int[][] dp1;
    private static int[] dp2;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            N = sc.nextInt();
            V = sc.nextInt();
            weight = new int[N+1];
            value = new int[N+1];
            dp1 = new int[N+1][V+1];
            dp2 = new int[V+1];
            for (int i = 1; i <= N; i++){
                weight[i] = sc.nextInt();
                value[i] = sc.nextInt();
            }
            System.out.println(dp2());
        }
    }

    public static int dp1(){
        for (int i = 1; i <= N; i++){
            for (int j = weight[i]; j <= V; j++){
                dp1[i][j] = Math.max(dp1[i-1][j], dp1[i-1][j-weight[i]] + value[i]);
            }
        }
        return dp1[N][V];
    }

    public static int dp2(){
        for (int i = 1; i <= N; i++){
            for (int j = V; j >= weight[i]; j--){
                dp2[j] = Math.max(dp2[j], dp2[j-weight[i]] + value[i]);
            }
        }
        return dp2[V];
    }
}
