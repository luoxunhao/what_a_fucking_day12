package test;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by lxh on 2017/4/8.
 */
public class Main2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++){
                set.add(sc.nextInt());
            }
            for (int i : set){
                System.out.println(i);
            }
            set.clear();
        }
    }
}
