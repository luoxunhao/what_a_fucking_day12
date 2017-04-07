package algs.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/7.
 */
public class POJ3069 {
    private static int N;
    private static int R;
    private static int[] X;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            N = sc.nextInt();
            R = sc.nextInt();
            X = new int[N];
            for (int i = 0; i < N; i++){
                X[i] = sc.nextInt();
            }
        }
    }

    public static int solve(){
        Arrays.sort(X);
        int ans = 0;
        int i = 0;
        while (i < N){
            //S：没有被覆盖的最左边点的位置
            int S = X[i++];
            while (i < N && X[i] <= S+R){
                i++;
            }
            //P：新标记点的位置
            int P = X[i-1];
            while (i < N && X[i] <= P+R){
                i++;
            }
            ans++;
        }
        return ans;
    }
}
