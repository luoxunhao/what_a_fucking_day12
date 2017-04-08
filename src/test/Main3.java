package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/8.
 */
public class Main3 {
    public static String hexToDec(String hex){
        if (hex == null || hex.length() < 3){
            return null;
        }
        char[] s = hex.trim().toCharArray();
        long res = 0;
        if (s[0] == '0' && s[1] == 'x'){
            int i = 2;
            while (i < s.length){
                res *= 16;
                if (s[i] >= '0' && s[i] <= '9'){
                    res += s[i++] - '0';
                }else if (s[i] >= 'A' && s[i] <= 'F'){
                    res += s[i++] - 'A' + 10;
                }else {
                    res = -1;
                    break;
                }
            }
        }
        if (res == -1){
            return null;
        }
        return String.valueOf(res);
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String hex;
        while (sc.hasNext()){
            hex = sc.nextLine();
            System.out.println(hexToDec(hex));
        }
    }
}
