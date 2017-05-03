package algs.bianry_search;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/25.
 */
public class BinarySearch {
    private static int n;
    private static int[] arr = new int[100];
    public static int binarySearch(int[] arr, int val, int l, int r){
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
        if (low < r && arr[low] == val){
            return low;
        }
        return -low - 1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int val = sc.nextInt();
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(binarySearch(arr,val,0,n));
        }
    }
}
