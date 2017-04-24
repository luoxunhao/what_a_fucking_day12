package algs.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by lxh on 2017/4/24.
 */
public class LongestIncrementSubsquence {
    public static int getLIS1(int[] arr, int n){
        if (arr == null || n < 1){
            return 0;
        }
        int[] dp = new int[n];
        int res = 1;
        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static int getLIS2(int[] arr, int n){
        if (arr == null || n < 1){
            return 0;
        }
        int dp[] = new int[n];
        int ends[] = new int[n];
        ends[0] = arr[0];
        dp[0] = 1;
        int len = 0;
        for (int i = 1; i < n; i++){
            int l = 0;
            int r = len;
            while (r - l > 1){
                int mid = (l + r) / 2;
                if (ends[mid] > arr[i]){ //找到第一个大于arr[i]的位置
                    r = mid;
                }else {
                    l = mid;
                }
            }
            len = Math.max(len, l);
            ends[l] = arr[i];
            dp[i] = l+1;
        }
        return 0;
    }

    static class Pair{
        int a;
        int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    static class PairComparator implements Comparator<Pair>{
        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.a == o2.a){
                if (o1.b == o2.b){
                    return 0;
                }else if (o1.b < o2.b){
                    return 1;
                }else {
                    return -1;  //-1: o1放在前面， 1：o1放在后面  0: 顺序不变
                }
            }else if (o1.a < o2.a){
                return -1;
            }else {
                return 1;
            }
        }
    }

    public static int maxEnvelopes(int[][] es, int n, int m){
        if (es == null || n < 1 || es[0] == null || m != 2){
            return 0;
        }
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++){
            pairs[i] = new Pair(es[i][0], es[i][1]);
        }
        Arrays.sort(pairs, new PairComparator());
        int[] ends = new int[n];
        ends[0] = pairs[0].b;
    }
}
