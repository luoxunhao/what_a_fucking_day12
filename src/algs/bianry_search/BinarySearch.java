package algs.bianry_search;

/**
 * Created by lxh on 2017/4/25.
 */
public class BinarySearch {
    public static int binarySearch(int[] arr, int n, int val){
        if (arr == null || n < 1){
            return -1;
        }
        int l = 0;
        int r = n-1;
        while (r - l > 1){
            int mid = (l + r) >> 1;
            if (arr[mid] >= val){
                r = mid;
            }else {
                l = mid;
            }
        }
        return r;
    }
}
