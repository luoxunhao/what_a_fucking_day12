package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/12.
 */
public class BoysAndGirls {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            char[] str = sc.nextLine().toCharArray();
            int n = str.length;
            System.out.println(solve(str, n));
        }
    }

    public static int solve(char[] str, int n){
        if (str == null || n <= 0){
            return 0;
        }
        int[] boys = new int[n];
        int[] girls = new int[n];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < n; i++){
            if (str[i] == 'B'){
                boys[index1++] = i;
            }else {
                girls[index2++] = i;
            }
        }
        int res1 = 0;
        for (int i = 0; i < index1; i++){
            res1 += boys[i] - i;
        }
        int res2 = 0;
        for (int i = 0; i < index2; i++){
            res2 += girls[i] - i;
        }
        return Math.min(res1, res2);
    }
}
