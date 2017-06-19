package test.wangyi;

import java.util.Scanner;

/**
 * Created by lxh on 2017/5/13.
 */
public class Main2 {
    public static int n;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            int m = (int)Math.sqrt(n);
            int count = 0;
            for (int i = 0; i <= m; i++){
                int tmp = (int) Math.sqrt(n - i * i);
                if (tmp * tmp + i * i == n){
                    if (i == 0 || tmp == 0){
                        count += 2;
                    }else {
                        count += 4;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
