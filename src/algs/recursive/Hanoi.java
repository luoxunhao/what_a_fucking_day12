package algs.recursive;

/**
 * Created by lxh on 2017/3/24.
 */
public class Hanoi {
    public static void hanoi(int n){
        if (n > 0){
            func(n, "left", "mid", "right");
        }
    }

    public static void func(int n, String from, String mid, String to){
        if (n == 1){
            System.out.println("from " + from + " to " + to);
        }else {
            func(n-1, from, to, mid);
            func(1, from, mid, to);
            func(n-1, mid, from, to);
        }
    }

    public static void main(String[] args){
        hanoi(2);
    }
}
