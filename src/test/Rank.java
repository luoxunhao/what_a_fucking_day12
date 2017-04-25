package test;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by lxh on 2017/4/16.
 */
public class Rank {
    public static int[] getRank(int[] arr,int n){
        TreeMap<Integer, Integer>  map = new TreeMap<>();
        int[] res = new int[n];
        for (int i = 0; i < n; i++){
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else {
                map.put(arr[i],1);
            }
            for(Map.Entry kv : map.entrySet()){
                int key = (int) kv.getKey();
                int val = (int) kv.getValue();
                if (key < arr[i]){
                    res[i] += val;
                }else if (key == val){
                    res[i] += val-1;
                }else {
                    break;
                }
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5000];
        int n = 0;
        while (sc.hasNext()){
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] res = getRank(arr,n);
            for (int i = 0; i < n; i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}
