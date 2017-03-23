package coding;

import java.util.Scanner;

/**
 * Created by lxh on 2017/3/23.
 */
public class IntPower {
    public static int power(int m, int n){
        int res = 1;
        for (; n != 0; n >>= 1){
            if ((n & 1) != 0){
                res *= m;
            }
            m = m * m;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int m = sc.nextInt(), n = sc.nextInt();
            System.out.println(power(m, n));
        }
    }
}
