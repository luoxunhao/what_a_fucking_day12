package algs.dp;

import java.util.Scanner;

public class TwoDimZeroOnePack {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int x = sc.nextInt(), n = sc.nextInt(), m = sc.nextInt(); //zero 个 0 ，one 个 1
            int[] zero = new int[x]; //第i个串0的个数
            int[] one = new int[x]; //第i个串1的个数
            String item;  //将该定义写在循环里面会报数组越界错误
            for(int i=0;i<x;i++) {
                item = sc.next();
                int cnt = 0;
                for(int j=0;j<item.length();j++) {
                    if(item.charAt(j) == '0') {
                        cnt++;
                    }
                }
                zero[i] = cnt;
                one[i] = item.length()-cnt;
            }
            System.out.println(maxObject(x,n,m,zero,one));
        }
    }

    public static int maxObject(int x, int n, int m, int[] zero, int[] one){
        if (zero == null || one == null){
            return 0;
        }
        //二维背包问题，需要定义三维的dp矩阵来存储状态
        //dp[i][j][k]代表第0...i号串item[0....i]被放进具有j个0和k个1的包里时，可以被放进去的最大数
        int[][][] dp = new int[x][n+1][m+1];
        for (int i = zero[0]; i < n+1; i++){
            for (int j = one[0]; j < m+1; j++){
                    dp[0][i][j] = 1;
            }
        }
        //状态方程：dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zero[i]][k-one[i]] + 1);
        for (int i = 1; i < x; i++){
            for (int j = zero[i]; j < n+1; j++){
                for (int k = one[i]; k < m+1; k++){
                    dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-zero[i]][k-one[i]] + 1);
                }
            }
        }
        return dp[x-1][n][m];

/*
        //下面用到了dp矩阵的空间优化，仅用二位数组记录dp矩阵状态
        if (zero == null || one == null){
            return 0;
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < x; i++){
            for (int j = n; j >= zero[i]; j--){
                for (int k = m; k >= one[i]; k--){
                    dp[j][k] = Math.max(dp[j][k], dp[j-zero[i]][k-one[i]] + 1);
                }
            }
        }
        return dp[n][m];
        */
    }

}


/*
public class TwoDimZeroOnePack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int x = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] zero = new int[x];
            int[] one = new int[x];
            String item;
            for(int i=0;i<x;i++) {
                item = sc.next();
                int cnt = 0;
                for(int j=0;j<item.length();j++) {
                    if(item.charAt(j) == '0') {
                        cnt++;
                    }
                }
                zero[i] = cnt;
                one[i] = item.length()-cnt;
            }
            int[][] dp = new int[n+1][m+1];
            for(int i=0;i<x;i++) {
                for(int j=n;j>=zero[i];j--) {
                    for(int k=m;k>=one[i];k--) {
                        if(dp[j][k] < dp[j-zero[i]][k-one[i]]+1) {
                            dp[j][k] = dp[j-zero[i]][k-one[i]]+1;
                        }
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }
}
*/