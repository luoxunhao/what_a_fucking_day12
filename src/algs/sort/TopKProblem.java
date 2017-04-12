package algs.sort;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/12.
 */
public class TopKProblem {
    private static int[] arr = new int[101]; //假设数据规模小于100
    private static int n, k;

    /*
    top k min 建最大堆，top k max建最小堆
     */
    public static void heapInsert(int i){
        while (i > 0){
            int parent = (i-1)/2;
            if (arr[parent] >= arr[i]){
                break;
            }
            swap(parent,i);
            i = parent;
        }
    }

    public static void heapify(int i, int size){
        int left = i*2 + 1;
        int right = 1*2 + 2;
        if (left > size){
            return;
        }
        int largest = i;
        if (arr[largest] <= arr[left]){
            largest = left;
        }
        if (right < size && arr[largest] <= arr[right]){
            largest = right;
        }
        if (i == largest){
            return;
        }
        swap(i, largest);
        heapify(largest, size);
    }

    public static void solve(){
        for (int i = 0; i < k; i++){
            heapInsert(i);
        }
        for (int i = k; i < n; i++){
            if (arr[0] > arr[i]){
                swap(0,i);
                heapify(0,k);
            }
        }
    }

    public static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            k = sc.nextInt();
            for (int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            solve();
        }
    }
}
