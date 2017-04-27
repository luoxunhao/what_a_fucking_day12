package algs.array;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 未排序数组中累加和为给定值的最长子数组长度
 *
 * 拓展1：给定无序数组arr,求arr所有子数组中正数和负数个数相等的最长子数组长度
 * 解法：直接将原问题数组中的正数变为1，负数变为-1,0不变，转化为求累加和为0的最长子数组长度
 *
 * 拓展2：给定无序数组arr，其中元素只有0或1，求arr所有子数组中0和1个数相等的最长子数组长度
 * 解法：直接将原问题数组中的0变为-1，转化为求累加和为0的最长子数组长度
 */
public class LongestSumKSubarray_2 {
    private static int n, k;
    private static int[] arr = new int[100]; //假设数据规模为100
    public static int maxLength(int[] arr, int n, int k){
        if (arr == null || n < 1){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); //重要
        int len = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += arr[i];
            if (map.containsKey(sum - k)){
                len = Math.max(len, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)){
                map.put(sum, i);
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
            System.out.println(maxLength(arr, n, k));
        }
    }
}
