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

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int x : nums) {
            int idx = Arrays.binarySearch(dp, 0, len, x);
            if(idx < 0) {
                idx = -(idx + 1);
            }
            dp[idx] = x;
            if(idx == len) {
                len++;
            }
        }
        return len;
    }


    public static int maxEnvelopes(int[][] es, int n, int m){
        if (es == null || n < 1 || es[0] == null || m != 2){
            return 0;
        }
        Arrays.sort(es, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]){
                    return o2[1] - o1[1];
                }else {
                    return o1[0] - o2[0];
                }
            }
        });
        int[] dp = new int[n];
        int len = 0;
        for (int[] e : es){
            int idx = Arrays.binarySearch(dp, 0, len, e[1]);
            if (idx < 0){
                idx = -(idx + 1);
            }
            dp[idx] = e[1];
            if (idx == len){
                len++;
            }
        }
        return len;
    }
}
