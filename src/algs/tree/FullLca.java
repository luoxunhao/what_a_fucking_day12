package algs.tree;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/9.
 */
public class FullLca {
    private static int a ,b;

    public static int getLCA(int a, int b) {
        if (a == b){
            return a;
        }else if (a < b){
            return getLCA(a, b/2);
        }else {
            return getLCA(a/2, b);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(getLCA(a,b));
        }
    }
}
