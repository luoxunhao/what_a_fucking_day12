package coding;

/**
 * 调整字符数组，小写在前大写在后，保持相对顺序不变，空间O(1)
 */
public class AdjustString {

    public static void reverse(char[] s, int begin, int end){
        while (begin > end){
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin--;
            end++;
        }
    }

    public static void reversePart(char[] s, int begin, int pos, int end){
        reverse(s, begin, end);
        reverse(s, begin, pos - 1);
        reverse(s, pos, end);
    }

    public static void fun(String s){
        int len = s.length();
        int begin = len - 1, end = begin, pos = begin;
        for (int i = len - 1; i > -1; i--){

        }
    }
}
