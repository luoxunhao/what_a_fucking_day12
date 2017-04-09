package algs.dp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 输入两个整数 n 和 m，从数列1，2，3.......n 中随意取几个数,使其和等于 m ,要求将其中所有的可能组合列出来
 * 按字典顺序输出
 */
public class PermutationOfSumK {
    private static int n;
    private static int m;

    //打印组合
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
            return; //剪枝
        }
        dfs(new ArrayList<>(res),pos+1,n,sum,m);
        res.remove(res.size()-1);
        dfs(new ArrayList<>(res),pos+1,n,sum-pos,m);
    }

    //是否存在
    public static boolean dfs1(int[] a, int pos, int n, int sum, int m){
        if (pos == n){
            return sum == m;
        }
        sum += a[pos];
        if (sum == m){
            return true;
        }else if (sum > m){
            return false;
        }
        return dfs1(a,pos+1,n,sum,m) || dfs1(a,pos+1,n,sum-a[pos],m);
    }

    //组合数
    public static int dfs2(int[] a, int pos, int n, int sum, int m){
        if (pos == n){
            if (sum == m){
                return 1;
            }else {
                return 0;
            }
        }
        sum += a[pos];
        if (sum == m){
            return 1;
        }else if (sum > m){
            return 0;
        }
        return dfs2(a,pos+1,n,sum,m) + dfs2(a,pos+1,n,sum-a[pos],m);
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
            //n = n > m ? m : n;
            //ArrayList<Integer> res = new ArrayList<>();
            //dfs(res,1,n,0,m);
            int[] a = new int[n];
            for (int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            System.out.println(dfs2(a,0,n,0,m));
        }
    }
}
