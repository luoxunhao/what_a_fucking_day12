package algs.array;

import java.util.LinkedList;

/**
 * Created by lxh on 2017/3/27.
 */
public class Review_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] array, int w){
        if (array == null || array.length < w){
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[array.length - w + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            //从队尾入列，保证qmax中下标对应的元素是严格递减的
            while (!qmax.isEmpty() && array[qmax.getLast()] <= array[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            //头过期，则出列
            if (qmax.getFirst() == i - w){
                qmax.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = array[qmax.getFirst()];
            }
        }
        return res;
    }
}
