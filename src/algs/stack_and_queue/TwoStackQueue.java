package algs.stack_and_queue;

import java.util.Stack;

/**
 * 两个栈实现的队列：
 * 设计原则：
 * 1. 如果stackPush要往stackPop中压入数据，那么必须一次性把stackPush里面的数据全部压入
 * 2. 如果stackPop不为空，那么绝对不能往stackPop中压入数据
 */
public class TwoStackQueue {
    public static class MyQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public MyQueue() {
            stackPush = new Stack<Integer>();
            stackPop = new Stack<Integer>();
        }

        public void add(int e){
            stackPush.push(e);
        }

        public int poll(){
            if (stackPop.isEmpty()) {
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.pop();
        }

        public int peek(){
            if (stackPop.isEmpty()){
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
            }
            return stackPop.peek();
        }
    }
}
