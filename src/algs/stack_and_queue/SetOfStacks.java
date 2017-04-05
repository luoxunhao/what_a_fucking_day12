package algs.stack_and_queue;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 请实现一种数据结构SetOfStacks，由多个栈组成，其中每个栈的大小为size，当前一个栈填满时，新建一个栈。该数据结构应支持与普通栈相同的push和pop操作。
 给定一个操作序列int[][2] ope(C++为vector<vector<int>>)，每个操作的第一个数代表操作类型，若为1，则为push操作，后一个数为应push的数字；若为2，则为pop操作，
 后一个数无意义。请返回一个int[][](C++为vector<vector<int>>)，为完成所有操作后的SetOfStacks，顺序应为从下到上，默认初始的SetOfStacks为空。保证数据合法。
 */
public class SetOfStacks {

    private static ArrayList<ArrayList<Integer>> setOfStacks = new ArrayList<>();
    private static ArrayList<Integer> stack = new ArrayList<>();

    public static ArrayList<ArrayList<Integer>> setOfStacks(int[][] ope, int size) {
        setOfStacks.add(stack);
        for (int i = 0; i < ope.length; i++){
            if (ope[i][0] == 1){
                push(ope[i][1], size);
            }else if(ope[i][0] == 2){
                pop();
            }
        }
        return setOfStacks;
    }

    public static void push(int data, int size){
        if (stack.size() < size){
            stack.add(data);
        }else {
            stack = new ArrayList<>();
            stack.add(data);
            setOfStacks.add(stack);
        }
    }

    public static void pop(){
        if (stack.size() > 0){
            stack.remove(stack.size()-1);
        }else {
            setOfStacks.remove(setOfStacks.size()-1);
            stack = setOfStacks.get(setOfStacks.size()-1);
            stack.remove(stack.size()-1);
        }
    }

    public static void main(String[] args){
        int[][] ope = {{1,32},{1,34},{1,56},{1,68}};
        int size = 2;
        setOfStacks(ope,size);
    }
}
