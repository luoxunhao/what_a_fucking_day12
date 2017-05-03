package algs.array;

/**
 * Created by lxh on 2017/5/3.
 */
public class Water_1 {
    private static int[] arr = new int[100];
    private static int n;
    public static int getMaxWater1(int[] arr, int n){
        if (arr == null || n < 3){
            return 0;
        }
        int res = 0;
        for (int i = 1; i < n-1; i++){
            int leftMax = getMax(arr, 0, i-1);
            int rightMax = getMax(arr, i+1, n-1);
            res += Math.max(0, Math.min(leftMax, rightMax) - arr[i]);
        }
        return res;
    }
    public static int getMax(int[] arr, int l, int r){
        int max = 0;
        for (int i = l; i <= r; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }

    public static int getWater2(int[] arr, int n){
        int len = n-2;
        int[] leftMax = new int[len];
        leftMax[0] = arr[0];
        for (int i = 1; i < len; i++){
            leftMax[i] = Math.max(leftMax[i-1], arr[i]);
        }
        int[] rightMax = new int[len];
        leftMax[len-1] = arr[len+1];
        for (int i = len-2; i >= 0; i--){
            rightMax[i] = Math.max(rightMax[i+1], arr[i+2]);
        }
        int res = 0;
        for (int i = 1; i <= len; i++){
            res += Math.max(0, Math.min(leftMax[i-1], rightMax[i-1]) - arr[i]);
        }
        return res;
    }
}
