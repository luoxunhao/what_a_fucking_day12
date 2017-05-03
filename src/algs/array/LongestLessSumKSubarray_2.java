package algs.array;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/27.
 */
public class LongestLessSumKSubarray_2 {
    private static int [] arr = new int[100];
    private static int n;
    private static int k;

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
            int pre = binarySearch(help, 0, n, sum-k);
            int len = pre == n ? 0 : i - pre + 1;
            res = Math.max(res, len);
        }
        return res;
    }

    //找到第一个大于等于val的位置
    public static int binarySearch(int[] arr, int l, int r, int val){
        int low = l;
        int high = r - 1;
        while (low <= high){
            int mid = (low + high) >> 1;
            if (arr[mid] >= val){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(maxLength(arr, n, k));
        }
    }
}
