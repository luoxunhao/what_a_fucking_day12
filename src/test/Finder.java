package test;

import java.util.Scanner;

/**
 * Created by lxh on 2017/4/15.
 */
public class Finder {
    private static String[] str = new String[100];
    private static int n;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String x = null;
        while (sc.hasNext()){
            n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++){
                str[i] = sc.nextLine();
            }
            x = sc.nextLine();
            System.out.println(findString(str,n,x));
        }
    }

    public static int findString(String[] str, int n, String x) {
        if (str == null || str.length <= 0){
            return -1;
        }
        for (int i = 1; i < n; i++){
            if (str[i].equals("")){
                str[i] = str[i-1];
            }
        }
        int lb = 0, ub = n-1;
        while (ub - lb > 1){
            int mid = (lb+ub)/2;
            int cmp = str[mid].compareTo(x);
            if (cmp >= 0){
                ub = mid;
            }else {
                lb = mid;
            }
        }
        return ub;
    }


}
