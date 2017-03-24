package algs.dp;

/**
 * 最长递增子序列
 */
public class LIS {
    public static int[] getDP(int[] arr){
        int[] dp = new int[arr.length]; //dp[i]:必须以arr[i]结尾的LIS长度
        for (int i = 0; i < arr.length; i++){
            dp[i] = 1;
            for (int j = 0; j < i; j++){
                if (arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    public static int[] generateLIS(int[] arr, int[] dp){
        int len = 0, last = 0;
        for (int i = 0; i < arr.length; i++){
            if (dp[i] > len){
                len = dp[i];
                last = i;
            }
        }
        int[] lis = new int[len];
        lis[--len] = arr[last];
        for (int i = last; i > -1; i--){
            if (arr[i] < arr[last] && dp[i] == dp[last]-1){
                lis[--len] = arr[i];
                last = i;
            }
        }
        return lis;
    }

    public static int[] lis(int[] arr){
        if (arr == null){
            return null;
        }
        int[] dp = getDP(arr);
        return generateLIS(arr, dp);
    }
    public static void main(String[] args){
        int[] arr = {2,1,5,3,6,4,8,9,7};
        lis(arr).toString();
    }
}
