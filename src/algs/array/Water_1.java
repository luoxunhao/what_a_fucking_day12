package algs.array;

/**
 * Created by lxh on 2017/5/3.
 */
public class Water_1 {
    private static int[] arr = new int[100];
    private static int n;
    public static int getMaxWater(int[] arr, int n){
        if (arr == null || n < 1){
            return 0;
        }
        int res = 0;

        return res;
    }
    public static int getMax(int[] arr, int l, int r){
        int max = 0;
        for (int i = l; i <= r; i++){
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
