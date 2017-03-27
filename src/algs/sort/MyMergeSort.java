package algs.sort;

/**
 * MergeSort: 归并排序的递归实现
 * 注：算法导论上给出的合并排序算法
 * 递归过程是将待排序集合一分为二，
 * 直至排序集合就剩下一个元素为止，然后不断的合并两个排好序的数组
 * 分治算法
 * T(n) = O(nlgn)
 **/

/*
题目输入一个数组，数组元素的大小在0->999.999.999的范围内，元素个数为0-500000范围。
题目要求通过相邻的元素的交换，使得输入的数组变为有序，要求输出交换的次数.
这题求解的其实就是一个逆序对
 */
public class MyMergeSort {

    /**
     * 直接合并两个数组
     * @param arr
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] arr, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;
        // 需要额外的空间arr_left, arr_right 空间复杂度O(n)
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;
        for (i = 0; i < n1; i++){
            left[i] = arr[start + i];
        }
        for (i = 0; i < n2; i++){
            right[i] = arr[i + mid + 1];
        }
        //merge
        i = j = 0;
        k = start;
        while (i < n1 && j < n2){
            arr[k++] = left[i] < right[j] ? left[i++] : right[j++];
        }
        while (i < n1){
            arr[k++] = left[i++];
        }
        while (j < n2){
            arr[k++] = right[j++];
        }
    }

    /**
     * 归并排序算法
     * @param arr
     * @param start
     * @param end
     */
    public static void MergeSort(int[] arr, int start, int end){
        int mid;
        if (start < end) {
            mid = (start + end) / 2;
            MergeSort(arr, start, mid);
            MergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static int mergeArray(int[] arr, int start, int mid, int end){
        int n1 = mid - start + 1;
        int n2 = end - mid;
        // 需要额外的空间arr_left, arr_right 空间复杂度O(n)
        int[] left = new int[n1];
        int[] right = new int[n2];
        int i, j, k;
        for (i = 0; i < n1; i++){
            left[i] = arr[start + i];
        }
        for (i = 0; i < n2; i++){
            right[i] = arr[i + mid + 1];
        }
        i = j = 0;
        k = start;
        int count = 0;
        //merge, 合并的同时干两件事：1、排序 2、计逆序对数
        while (i < n1 && j < n2){
            if (left[i] > right[j]){ //产生逆序对
                arr[k++] = right[j++];
                //因为left[0...i...n1-1]和right[0...j...n2-1]都是有序的，如果left[i] > right[j]，
                //那么right[j] < left[i,....,n1-1] count += n1-1 - i + 1
                count += n1 - i;
            }else {
                arr[k++] = left[i++];
            }
        }
        while (i < n1){
            arr[k++] = left[i++];
        }
        while (j < n2){
            arr[k++] = right[j++];
        }
        return count;
    }

    public static int inverseCore(int[] arr, int start, int end){
        if (start == end){
            return 0;
        }
        int mid = (start + end) / 2;
        return inverseCore(arr, start, mid) + inverseCore(arr, mid + 1, end) + mergeArray(arr, start, mid, end);
    }

    public static int inversePairs(int[] arr){
        if (arr == null || arr.length == 0){
            return 0;
        }
        return inverseCore(arr, 0, arr.length - 1);
    }

    public static void main(String[] args){
        int[] arr = {7,5,6,4};
        System.out.println(inversePairs(arr));
        MergeSort(arr,0,arr.length - 1);
    }
}
