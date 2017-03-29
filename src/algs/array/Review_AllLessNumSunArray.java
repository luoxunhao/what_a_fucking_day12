package algs.array;

import java.util.LinkedList;

/**
 * Created by lxh on 2017/3/29.
 */
public class Review_AllLessNumSunArray {
    public static int getNum(int[] arr, int num){
        if (arr == null){
            return 0;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        LinkedList<Integer> qmin = new LinkedList<>();
        int i = 0, j = 0, res = 0;
        while (i < arr.length){
            while (j < arr.length){
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]){
                    qmin.pollLast();
                }
                qmin.offerLast(j);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]){
                    qmax.pollLast();
                }
                qmax.offerLast(j);
                if (arr[qmax.peekFirst()] - arr[qmin.peekFirst()] > num){
                    break;
                }
                j++;
            }
            res += j-i;
            i++;
        }
        return res;
    }
}
