package algs.sort;

import java.util.ArrayList;

/**
 * Created by lxh on 2017/3/15.
 */
/*
堆的性质：
1---父结点的键值总是大于或等于（小于或等于）任何一个子节点的键值。
2---每个结点的左子树和右子树都是一个二叉堆（都是最大堆或最小堆）。
 */
public class MyHeapSort {
    /**
     * 堆调整（最大堆）， O(logN)
     * 对某一个节点为根的子树做堆调整，
     * 其实就是将该根节点进行“下沉”操作(具体是通过和子节点交换完成的)，
     * 一直下沉到合适的位置，使得刚才的子树满足堆的性质。
     * 即最大堆：根 >= 左 && 右
     * 思路的核心就是——“下沉”
     * @param arr
     * @param root 需要下沉的子树根结点
     * @param heapSize 最大堆的大小
     */
    public static void MaxHeapAdjust(int[] arr, int root, int heapSize){
        int left, right, target = root;

        for (int i = root; i < heapSize; i = target){
            //乘以2是根据完全二叉树的性质，
            //i 与 2i, 2i+1 是亲子关系
            left = 2 * i + 1;
            right = left + 1;
            if (left < heapSize){
                target = arr[i] < arr[left] ? left : i;
            }
            if (right < heapSize){
                target = arr[target] < arr[right] ? right : target;
            }
            if (i != target){
                int temp = arr[i];
                arr[i] = arr[target];
                arr[target] = temp;
            }else {
                break;
            }
        }
    }

    /**
     * 堆调整递归版本
     * @param arr
     * @param root
     * @param heapSize
     */
    public static void rMaxHeapAdjust(int[] arr, int root, int heapSize){
        int left = 2 * root + 1;
        int right = left + 1;
        int target = root;
        if (left < heapSize){
            target = arr[root] < arr[left] ? left : root;
        }
        if (right < heapSize){
            target = arr[target] < arr[right] ? right : target;
        }
        if (root != target){
            int temp = arr[root];
            arr[root] = arr[target];
            arr[target] = temp;
            rMaxHeapAdjust(arr, target, heapSize);
        }else {
            return;
        }
    }
    /**
     * 堆排序
     * @param arr
     */
    public static void HeapSort(int[] arr){
        //1.首先创建最大堆
        //从 arr.length / 2 开始 依次减小到 0,是因为这些结点都具有孩子结点，
        //即他们是子树的根结点
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            rMaxHeapAdjust(arr, i, arr.length);
        }
        //2.排序
        /*
        数组储存成堆的形式之后，第一次将A[0]与A[n - 1]交换，再对A[0…n-2]重新恢复堆。
        第二次将A[0]与A[n-2]交换，再对A[0…n-3]重新恢复堆，重复这样的操作直到A[0]与A[1]交换。
        由于每次都是将最大（因为是最大堆）的数据并入到后面的有序区间，故操作完成后整个数组就有序了。
         */
        for (int i = arr.length - 1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            rMaxHeapAdjust(arr, 0, i);
        }
    }

    /**
     * 用堆来处理Top K问题
     * 首先创建一个大小为k的最大堆，
     * 从 k+1 开始遍历数组，如果arr[k+1]小于堆里面的最大值（heap[0]），
     * 则插入arr[k+1]替换原来的heap[0]，
     * 再重新调整堆，也就是新替换的根结点arr[0]
     * 这样一趟下来后，heap里面的就是最小的k个元素
     * @param arr
     * @param k
     * @return
     */
    public static ArrayList<Integer> getTopKNum(int[] arr, int k){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (arr == null || arr.length <= 0 || arr.length < k){
            return res;
        }
        //首先创建大小为k的最大堆
        for (int i = k / 2 - 1; i >= 0; i--){
            MaxHeapAdjust(arr, i, k);
        }
        for (int i = k; i < arr.length; i++){
            if (arr[i] < arr[0]){
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                MaxHeapAdjust(arr, 0, k);
            }
        }
        for (int i = 0; i < k; i++){
            res.add(arr[i]);
        }
        return res;
    }
    public static void main(String[] args){
        int[] arr = {5,1,9,3,7,4,8,6,2};
        //getTopKNum(arr, 3);
        HeapSort(arr);
    }
}
