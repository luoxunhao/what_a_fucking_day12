package algs.sort;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/11.
 */
public class HeapSort {
    private static int[] arr = new int[100]; //假设数据规模 N <= 100
    private static int n;

    public static void heapInsert(int i){
        while (i > 0){
            int parent = (i-1)/2;
            if (arr[parent] >= arr[i]){
                break;
            }
            swap(arr, parent, i);
            i = parent;
        }
    }

    public static void heapify(int[] arr, int i, int size){
        int left = i * 2 + 1, right = i * 2 + 2;
        int largest = i;
        while (left < size){
            if (arr[largest] < arr[left]){
                largest = left;
            }
            if (right < size && arr[largest] < arr[right]){
                largest = right;
            }
            if (largest != i){
                swap(arr,largest,i);
            }else {
                break;
            }
            i = largest;
            left = i*2 + 1;
            right = i*2 + 2;
        }
    }

    public static void heapSort(int[] arr){
        for (int i = 0; i < n; i++){
            heapInsert(i);
        }
        for (int i = n-1; i > 0; i--){
            swap(arr,0,i);
            heapify(arr,0,i);
        }
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            heapSort(arr);
        }
    }
}
