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
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) {
                i = -(i + 1);
            }
            dp[i] = x;
            if(i == len) {
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
                    return o1[1] - o2[1];
                }else {
                    return o2[0] - o1[0];
                }
            }
        });
    }
}
