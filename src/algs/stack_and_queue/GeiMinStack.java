package algs.stack_and_queue;

import java.util.Stack;

/**
 * Created by lxh on 2017/3/26.
 */
public class GeiMinStack {
    public static class MyStack{
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;

        public MyStack() {
            this.stackData = new Stack<Integer>();
            this.stackMin = new Stack<Integer>();
        }

        public void push(int e){
            stackData.push(e);
            if (stackMin.isEmpty()){
                stackMin.push(e);
            }else if (e < stackMin.peek()){
                 stackMin.push(e);
            }else {
                stackMin.push(stackMin.peek());
            }
        }

        public int pop(){
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin(){
            return stackMin.peek();
        }
    }
}
