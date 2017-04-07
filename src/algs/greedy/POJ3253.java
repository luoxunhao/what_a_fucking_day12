package algs.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/7.
 */
public class POJ3253 {
    private static int N;
    private static int[] L;

    public static void solve(int[] ans,int left, int right){
        if (left == right){
            //ans[0] += L[left];
            return;
        }
        Arrays.sort(L, left, right);
        ans[0] += (L[left] + L[left+1]);
        L[left+1] += L[left];
        solve(ans,left+1,right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            N = sc.nextInt();
            L = new int[N];
            for (int i = 0; i < N; i++){
                L[i] = sc.nextInt();
            }
            int[] ans = {0};
            solve(ans,0,N-1);
            System.out.println(ans[0]);
        }
    }
}
