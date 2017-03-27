package algs.stack_and_queue;

import java.util.Stack;

/**
 * Created by lxh on 2017/3/26.
 */
public class Review_ReverseStackUsingRecursive {
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int last = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(last);
    }
}
