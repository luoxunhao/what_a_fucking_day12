package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by lxh on 2017/4/21.
 */

public class ConcurrentPrint {
    private final Lock lock = new ReentrantLock();
    static class Task extends Thread{
        private int n;
        public Task(String name, int n){
            super(name);
            this.n = n;
        }
        @Override
        public void run() {
            for (int i = 0; i < n; i++){

                    System.out.print(this.getName());

            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            char[] str = sc.nextLine().toCharArray();
            List<Thread> threadList = new ArrayList<>();
            for (char c : str){
                threadList.add(new Task(String.valueOf(c), n));
            }
            for (Thread t : threadList){
                t.start();
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
