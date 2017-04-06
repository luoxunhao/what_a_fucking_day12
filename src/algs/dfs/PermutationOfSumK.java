package algs.dfs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * 按字典顺序输出
 */
public class PermutationOfSumK {
    private static int n;
    private static int m;

    public static void dfs(ArrayList<Integer> res, int pos, int n, int sum, int m){
        if (pos > n){
            return;
        }
        sum += pos;
        res.add(pos);
        if (sum == m){
            print(res);
            return;
        }else if (sum > m){
            return;
        }
        dfs(new ArrayList<>(res),pos+1,n,sum,m);
        res.remove(res.size()-1);
        dfs(new ArrayList<>(res),pos+1,n,sum-pos,m);
    }

    public static void print(ArrayList<Integer> list){
        for (int i = 0; i < list.size(); i++){
            if (i == list.size()-1){
                System.out.println(list.get(i));
            }else {
                System.out.print(list.get(i) + " ");
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            n = sc.nextInt();
            m = sc.nextInt();
            n = n > m ? m : n;
            ArrayList<Integer> res = new ArrayList<>();
            dfs(res,1,n,0,m);
        }
    }
}
