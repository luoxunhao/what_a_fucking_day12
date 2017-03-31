package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/3/31.
 */
public class LongestPeekCrest {
    public static int[] findLongestPeek(int[] arr, int n){
        int[] res = {-1,-1};
        if (n < 3){
            return res;
        }
        int maxGap = 0;
        boolean findMax = false;
        int leftMin = 0;
        for (int i = 1; i < n-1; i++){
            if (i == 1 && arr[i] > arr[0]){
                leftMin = 0;
                continue;
            }
            if (i == n-2 && arr[i] > arr[n-1] && n - leftMin > maxGap){
                    res[0] = leftMin;
                    res[1] = n-1;
                    break;
            }
            if (arr[i] < arr[i-1] && arr[i] < arr[i+1]){
                if (findMax && i - leftMin + 1 > maxGap){
                    findMax = false;
                    res[0] = leftMin;
                    res[1] = i;
                    maxGap = i - leftMin + 1;
                }
                leftMin = i;
            }else if (arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                findMax = true;
            }
        }
        return res;
    }
    public static void print(int[] arr){
        System.out.println(arr[0] + " " + arr[1]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            print(findLongestPeek(arr,n));
        }
    }
}
