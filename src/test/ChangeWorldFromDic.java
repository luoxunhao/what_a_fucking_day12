package test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/21.
 */
public class ChangeWorldFromDic {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String source = sc.nextLine();
            String target = sc.nextLine();
            String[] tmp = sc.nextLine().split(" ");
            String[] dic = new String[tmp.length+1];
            dic[0] = source;
            for (int i = 0; i < tmp.length; i++){
                dic[i+1] = tmp[i];
            }
            System.out.println(solve(source, target, dic, dic.length));
        }
    }

    public static int solve(String source, String target, String[] dic, int n){
        if (source == null || target == null || dic == null || n <= 0){
            return 0;
        }
        int index = 0;
        for (int i = 0; i < n; i++){
            if (target.equals(dic[i])){
                index = i;
                break;
            }
        }
        boolean[] visit = new boolean[n];
        int[] dist = new int[n];
        dist[0] = 0;
        visit[0] = true;
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < n; i++){
                if (!visit[i] && isChange(dic[cur], dic[i])){
                    visit[i] = true;
                    dist[i] = dist[cur]+1;
                    queue.add(i);
                }
            }
        }
        return dist[index]+1;
    }

    public static boolean isChange(String s1, String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        int index = 0;
        for (int i = 0; i < s1.length(); i++){
            if (s1.charAt(i) != s2.charAt(i)){
                index++;
            }
        }
        return index > 1 ? false : true;
    }
}
