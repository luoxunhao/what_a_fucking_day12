package algs.array;

import java.util.Scanner;

/**
 * 未排序正数数组中累加和为指定值得最长子数组长度
 */
public class LongestSumKSubarrayInPositiveArray_2 {
    private static int[] arr = new int[100];
    private static int n, k;
    public static int getMaxLength(int[] arr, int n, int k){
        if (arr == null || n < 1){
            return 0;
        }
        int l = 0, r = 0;
        int len = 0;
        int cur = arr[0];
        while (r < n){
            if (cur == k){
                len = Math.max(len, r - l + 1);
                cur -= arr[l++];
            }else if (cur > k){
                r++;
                if (r == n){
                    break;
                }
                cur += arr[r];
            }else {
                cur -= arr[l++];
            }
        }
        return len;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(getMaxLength(arr, n, k));
        }
    }
}
