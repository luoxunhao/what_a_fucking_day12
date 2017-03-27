package algs.sort;

import java.util.ArrayList;

/**
 * 《大话数据结构》中关于快排的优化
 */
public class MyQSort {

    /**
     * 核心思想Partition函数
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int Partition(int[] arr, int left, int right){
        int pivot = arr[left];
        while (left < right){
            while (left < right && pivot < arr[right]){
                right--;
            }
            if (left < right){ //这个判断很关键
                arr[left++] = arr[right];
            }
            while (left < right && pivot > arr[left]){
                left++;
            }
            if (left < right){
                arr[right--] = arr[left];
            }
        }
        arr[left] = pivot;
        return left;
    }

    /**
     * 快排
     * @param arr
     * @param left
     * @param right
     */
    public static void QSort(int[] arr, int left, int right){
        int pivot;
        if (left < right){
            pivot = Partition(arr, left, right);
            QSort(arr, left, pivot - 1);
            QSort(arr, pivot + 1, right);
        }
    }

    /**
     * 利用Partition解决Topk问题
     * 找中位数是找到一组数中的第k小元素的特殊情况
     * 判定分割的位置，然后再确定对前段还是后段进行分割，所以只对单侧分割即可
     * @param arr
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_by_partition(int[] arr, int k){
        if (arr == null || arr.length <= 0 || arr.length < k){
            return null;
        }
        ArrayList<Integer> res = new ArrayList<Integer>();
        int left = 0, right = arr.length - 1;
        int pivot = Partition(arr, left, right);
        while (pivot != k - 1){
            if (pivot < k - 1){
                pivot = Partition(arr, pivot + 1, right);
            }else {
                pivot = Partition(arr, left, pivot - 1);
            }
        }
        for (int i = 0; i < k; i++){
            res.add(arr[i]);
        }
        return res;
    }

    public static void main(String[] args){
        int[] arr = {3,10,10,9,10,7};
        //GetLeastNumbers_by_partition(arr, 4);
        QSort(arr, 0, arr.length - 1);
    }
}
