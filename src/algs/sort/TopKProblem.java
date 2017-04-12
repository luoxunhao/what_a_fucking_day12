package algs.sort;

import java.util.Comparator;
import java.util.PriorityQueue;
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
                swap(largest,i);
            }else {
                break;
            }
            i = largest;
            left = i*2 + 1;
            right = i*2 + 2;
        }
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

    public static int[] getKthMin(int[] arr, int n, int k){
        if (arr == null || arr.length < k){
            return null;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return -1;
                }else {
                    return 1;
                }
            }
        });
        for (int i = 0; i < k; i++){
            queue.add(arr[i]);
        }
        for (int i = k; i < n; i++){
            if (arr[i] < queue.peek()){
                queue.poll();
                queue.add(arr[i]);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++){
            res[i] = queue.poll();
        }
        return res;
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
            int[] res = getKthMin(arr,n,k);
            for (int i = 0; i < res.length; i++){
                System.out.print(res[i] + " ");
            }
        }
    }
}
