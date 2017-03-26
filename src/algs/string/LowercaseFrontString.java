package algs.string;

import java.util.Scanner;

/**
 * 把一个字符串的大写字母放到字符串的后面，各个字符的相对位置不变，且不能申请额外的空间。
 */
public class LowercaseFrontString {

    public static char[] lowercaseFront(String str){
        char[] s = str.toCharArray();
        int i = 0,j;
        while(i < s.length){
            while(i < s.length && !isUpcase(s[i])){i++;}
            j = i+1;
            while(j < s.length && isUpcase(s[j])){j++;}
            if(j < s.length){
                char tmp = s[j];
                for (int k = j-1; k >= i; k--) {
                    s[k+1] = s[k];
                }
                s[i++] = tmp;
            }else {// 查找失敗
                break;
            }
        }
        return s;
    }

    public static boolean isUpcase(char c){
        if (c >= 'A' && c <= 'Z'){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(lowercaseFront(s));
        }
    }
}
