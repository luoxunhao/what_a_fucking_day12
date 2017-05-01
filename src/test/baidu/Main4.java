package test.baidu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 度度熊有一个N个数的数组，他想将数组从大到小排好序，但是萌萌的度度熊只会下面这个操作：
 任取数组中的一个数然后将它放置在数组的最后一个位置。
 问最少操作多少次可以使得数组从小到大有序？
 */
public class Main4 {
    public static int n;
    public static int[] arr = new int[51];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            System.out.println(count());
        }
    }

    public static int count(){
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        int count = 0;
        for (;idx < n; idx++){
            map.put(arr[idx], idx);
        }
        Arrays.sort(arr,0,n);
        for (int i = 1; i < n; i++){
            if (map.get(arr[i]) < map.get(arr[i-1])){
                map.put(arr[i], idx++);
                count++;
            }
        }
        return count;
    }
}
