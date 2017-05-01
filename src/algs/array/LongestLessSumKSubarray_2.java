package algs.array;

/**
 * Created by lxh on 2017/4/27.
 */
public class LongestLessSumKSubarray_2 {
    public static int maxLength(int[] arr, int n, int k){
        if (arr == null || n < 1){
            return 0;
        }
        int[] help = new int[n + 1];
        help[0] = 0;
        int sum = 0;
        for (int i = 0; i < n ;i++){
            sum += arr[i];
            help[i+1] = Math.max(help[i], sum);
        }
        sum = 0;
        int res = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
        }
        return res;
    }
}
