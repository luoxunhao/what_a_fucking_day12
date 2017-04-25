package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] num = new int[3];
        while (sc.hasNext()){
            sum = sc.nextInt();
            for (int i = 0; i < 3; i++){
                num[i] = sc.nextInt();
            }
            System.out.println(solve(sum, num));
        }
    }
    public static int solve(int sum, int[] num){
        if(num.length != 3){
            return 0;
        }
        int tmp = 0;
        for (int i = 0; i < 3; i++){
            tmp += num[i];
        }
        int[] task = {5,8,10};
        int[] tasks = new int[tmp];
        int idx = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < num[i]; j++){
                tasks[idx++] = task[i];
            }
        }
        int[][] dp = new int[tmp+1][sum+1];
        dp[0][0] = 1;
        for (int i = 1; i <= tmp; i++){
            dp[i][0] = 1;
            for (int j = 1; j <= sum; j++){
                dp[i][j] = dp[i-1][j];
                if (j >= tasks[i-1]){
                    dp[i][j] += dp[i-1][j-tasks[i-1]];
                }
            }
        }
        return dp[tmp][sum];
    }
}

