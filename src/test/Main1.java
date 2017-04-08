package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/8.
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            if (n == 0){
                break;
            }
            int res = 0;
            while (n >= 2){
                if (n == 2){
                    res += 1;
                    break;
                }
                res += n/3;
                n = n/3 + n%3;
            }
            System.out.println(res);
        }
    }
}
