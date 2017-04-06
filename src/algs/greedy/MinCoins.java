package algs.greedy;

import java.util.Scanner;

/**
 * 换钱的最少硬币数
 * 贪心：总是先选面值最大的硬币去换
 */
public class MinCoins {
    private static int[] V = {1,5,10,50,100,500};
    private static int[] C;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            C = new int[6];
            int A = sc.nextInt();
            for (int i = 0; i < 6; i++){
                C[i] = sc.nextInt();
            }

        }
    }

    public static int solve(int A){
        int res = 0;
        int i = 5;
        while (A > 0){
            res += Math.min(C[i], A/V[i]);
            A = A%V[i--];
        }
        return res;
    }
}
