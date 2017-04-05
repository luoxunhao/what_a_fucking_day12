package algs.stack_and_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by lxh on 2017/4/5.
 */
public class CatDogAsylum {
    public ArrayList<Integer> asylum(int[][] ope) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<Integer> deque = new LinkedList<>();
        Stack<Integer> help = new Stack<>();
        for (int i = 0; i < ope.length; i++){
            if (ope[i][0] == 1){
                deque.addLast(ope[i][1]);
            }else if (ope[i][0] == 2){
                switch (ope[i][1]){
                    case 0:
                        if (!deque.isEmpty()){
                            res.add(deque.pollFirst());
                        }
                        break;
                    case -1:
                        while (!deque.isEmpty() && deque.getFirst() > 0){
                            help.push(deque.pollFirst());
                        }
                        if (!deque.isEmpty()){
                            res.add(deque.pollFirst());
                        }
                        while (!help.isEmpty()){
                            deque.addFirst(help.pop());
                        }
                        break;
                    case 1:
                        while (!deque.isEmpty() && deque.getFirst() < 0){
                            help.push(deque.pollFirst());
                        }
                        if (!deque.isEmpty()){
                            res.add(deque.pollFirst());
                        }
                        while (!help.isEmpty()){
                            deque.addFirst(help.pop());
                        }
                        break;
                }
            }
        }
        return res;
    }
}
