package test.baidu;

import java.util.Scanner;

/**
 * Created by lxh on 2017/5/1.
 */
public class Main2 {
    public static int n;
    public static int[] p = new int[51];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            for (int i = 0; i < n; i++){
                p[i] = sc.nextInt();
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i < n-1; i++){
                int sum = 0;
                for (int j = 1; j < n; j++){
                    if (j == i){
                        continue;
                    }else if (j == i+1){
                        sum += Math.abs(p[i+1] - p[i-1]);
                    }else {
                        sum += Math.abs(p[j] - p[j-1]);
                    }
                }
                min = Math.min(min, sum);
            }
            System.out.println(min);
        }
    }
}
