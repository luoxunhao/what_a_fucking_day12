package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/3/25.
 */
public class MathExpectation {
    public static double expectation(int[] x, int[] p){
        int sum = 0;
        for (int i = 0; i < p.length; i++){
            sum += p[i];
        }
        if (sum != 100){
            return 0.0;
        }
        sum = 0;
        for (int i = 0; i < x.length; i++){
            sum += x[i] * p[i];
        }
        return sum / 100.0;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] x = new int[n];
            int[] p = new int[n];
            for (int i = 0; i < n; i++){
                x[i] = sc.nextInt();
                p[i] = sc.nextInt();
            }
            double res = expectation(x,p);
            System.out.printf("%.3f",expectation(x, p));
        }
    }
}
