package algs.tree;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/12.
 */
public class IsPostTravelInBST {

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length < 1){
            return false;
        }
        int left = 0, right = sequence.length-1;
        return solve(sequence,left,right);
    }

    public static boolean solve(int [] sequence, int left, int right){
        if (left > right){
            return true;
        }
        int mid = left;
        while (mid < right){
            if (sequence[mid] > sequence[right]){
                break;
            }
            mid++;
        }
        for (int i = mid; i < right; i++){
            if (sequence[i] < sequence[right]){
                return false;
            }
        }
        if (solve(sequence,left,mid-1) && solve(sequence,mid,right-1)){
            return  true;
        }
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] sequence = new int[n];
            for (int i = 0; i < n; i++){
                sequence[i] = sc.nextInt();
            }
            System.out.println(VerifySquenceOfBST(sequence));
        }
    }
}
