package algs.string;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 有n个数，两两组成二元组，差最小的有多少对呢？差最大呢？


 输入描述:

 输入包含多组测试数据。

 对于每组测试数据：

 N - 本组测试数据有n个数

 a1,a2...an - 需要计算的数据

 保证:

 1<=N<=100000,0<=ai<=INT_MAX.



 输出描述:

 对于每组数据，输出两个数，第一个数表示差最小的对数，第二个数表示差最大的对数。

 输入例子:
 6
 45 12 45 32 5 6

 输出例子:
 1 2
 */
public class NumberOfMaxMinDiff {
    public static int[] findNumberOfMaxAndMinDiff(int[] arr){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++){
            if (!map.containsKey(arr[i])){
                map.put(arr[i], 1);
            }else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        int[] res = new int[2];
        int maxNum = map.get(map.firstKey()) * map.get(map.lastKey());
        res[1] = maxNum;
        int minNum = 0;
        for (Map.Entry kv : map.entrySet()){
            int curVal = (Integer) kv.getValue();
            minNum += func(curVal);
        }
        if (minNum != 0){
            res[0] = minNum;
            return res;
        }
        int preKey = 0;
        int preVal = 1;
        int min = Integer.MAX_VALUE;
        for (Map.Entry kv : map.entrySet()){
            int curKey = (Integer) kv.getKey();
            int curVal = (Integer) kv.getValue();
            if (curKey - preKey < min){
                min = curKey - preKey;
                minNum = curVal * preVal;
                preKey = curKey;
                preVal = curVal;
            }
        }
        res[0] = minNum;
        return res;
    }

    public static int func(int i){
        if (i < 1){
            return 0;
        }
        int res = 0;
        while (--i > 0){
            res += i;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int[] res = findNumberOfMaxAndMinDiff(arr);
            for (int i = 0; i < res.length; i++){
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
