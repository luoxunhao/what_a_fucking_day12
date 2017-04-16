package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/16.
 */
public class BinarySearch {
    private static int[] A = new int[100];
    private static int n;

    public static int getPos(int[] A, int n, int val) {
        if(A == null || n < 1){
            return -1;
        }
        int lb = -1;
        int ub = n;
        while (ub - lb > 1){
            int mid = (lb+ub)/2;
            if (A[mid] >= val){
                ub = mid;
            }else {
                lb = mid;
            }
        }
        return ub;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                A[i] = sc.nextInt();
            }
            int val = sc.nextInt();
            System.out.println(getPos(A,n,val));
        }
    }
}
