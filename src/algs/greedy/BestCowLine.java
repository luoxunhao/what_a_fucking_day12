package algs.greedy;

import java.util.Scanner;

/**
 * 字典序最小问题   POJ#3617
 * 给定S，每次可以从S的头部或者尾部删除一个字符加到T上，T开始为空
 * 目标是构造字典序尽可能小的T字符串
 *
 * 贪心：
 * 按照字典序比较S和将S反转后的字符串S'，
 * 如果S<S'，则从S开头去除字符
 * 如果S>S'，则从S结尾去除字符
 */
public class BestCowLine {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            char[] s = sc.nextLine().toCharArray();
            System.out.println(solve(s,n));
        }
    }

    public static String solve(char[] s, int n){
        int left = 0, right = n-1;
        StringBuffer sb = new StringBuffer();
        while (left <= right){
            boolean head = false;
            for (int i = 0; left+i <= right; i++){
                if (s[left+i] < s[right-i]){
                    head = true;
                    break;
                }else if (s[left+i] > s[right-i]){
                    head = false;
                    break;
                }
            }
            if (head){
                sb.append(s[left++]);
            }else {
                sb.append(s[right--]);
            }
        }
        return sb.toString();
    }
}
