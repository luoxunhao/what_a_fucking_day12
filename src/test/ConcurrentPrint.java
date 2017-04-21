package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/21.
 */

public class ConcurrentPrint {
    static class Task implements Runnable{

        @Override
        public void run() {

        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String str = sc.nextLine();
        }
    }
}
