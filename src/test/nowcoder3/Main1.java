package test.nowcoder3;

import java.util.Scanner;

/**
 * Created by lxh on 2017/6/19.
 */
public class Main1 {
    private static int num;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            num = sc.nextInt();
            int count = 0;
            while (num >= 10){
                num = change(num);
                count++;
            }
            System.out.println(count);
        }
    }

    public static int change(int num){
        int res = 1;
        while (num / 10 != 0){
            res *= num % 10;
            num /= 10;
        }
        return res * num;
    }
}
