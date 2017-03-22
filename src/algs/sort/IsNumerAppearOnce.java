package algs.sort;

/**
 * Created by lxh on 2017/3/22.
 */
public class IsNumerAppearOnce {

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

    public static void HeapSort(int[] arr){
        //1.首先创建最大堆
        //从 arr.length / 2 开始 依次减小到 0,是因为这些结点都具有孩子结点，
        //即他们是子树的根结点
        for (int i = arr.length / 2 - 1; i >= 0; i--){
            MaxHeapAdjust(arr, i, arr.length);
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
            MaxHeapAdjust(arr, 0, i);
        }
    }

    public static void main(String[] args){
        int[] arr = {5,1,9,3,7,4,8,6,2};
        HeapSort(arr);
    }
}
