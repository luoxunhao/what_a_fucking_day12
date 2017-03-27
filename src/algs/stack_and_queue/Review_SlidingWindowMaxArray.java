package algs.stack_and_queue;

import java.util.LinkedList;

/**
 * Created by lxh on 2017/3/27.
 */
public class Review_SlidingWindowMaxArray {
    public static int[] getMaxWindow(int[] array, int w){
        if (array == null || array.length < w){
            return null;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[array.length - w + 1];
        int index = 0;
        for (int i = 0; i < array.length; i++){
            while (!queue.isEmpty() && array[queue.getLast()] <= array[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            if (queue.getFirst() == i - w){
                queue.pollFirst();
            }
            if (i >= w - 1){
                res[index++] = array[queue.getFirst()];
            }
        }
        return res;
    }
}
