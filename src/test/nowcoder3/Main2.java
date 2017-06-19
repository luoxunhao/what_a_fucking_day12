package test.nowcoder3;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * Created by lxh on 2017/6/19.
 */
public class Main2 {
    private static int a;
    private static int b;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            a = sc.nextInt();
            b = sc.nextInt();
            int count = 0;
            for (int i = a; i <= b; i++){
                if (isNum(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean isNum(int num){
        ArrayList<Integer> nums = new ArrayList<>();
        while (num > 9){
            nums.add(num % 10);
            num /= 10;
        }
        nums.add(num);
        for (int i = 0; i < nums.size()-1; i++){
            int a = nums.get(i);
            for (int j = i+1; i < nums.size(); i++){
                int b = nums.get(j);
                if (isPrime(a*10+b) || isPrime(b*10+a)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isPrime(int num){
        if (num == 0){
            return false;
        }
        for (int i = 2; i <= num/2; i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
