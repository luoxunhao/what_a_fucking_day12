package algs.array;

/**
 * Created by lxh on 2017/4/24.
 */
public class MaxSubArraySum {
    public static int maxSubSum(int[] arr, int n){
        if (arr == null || n < 1){
            return 0;
        }
        int max = 0;
        int cur = 0;
        for (int i = 0; i < n; i++){
            cur += arr[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }
        return max;
    }
}
