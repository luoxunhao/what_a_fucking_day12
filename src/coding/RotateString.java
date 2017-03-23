package coding;

/**
 * Created by lxh on 2017/3/23.
 */
public class RotateString {
    public static void reverse(char[] s, int begin, int end){
        while (begin < end){
            char tmp = s[begin];
            s[begin] = s[end];
            s[end] = tmp;
            begin++;
            end--;
        }
    }

    public static String rotateString(String s, int pos){
        int len = s.length();
        char[] sArr = s.toCharArray();
        reverse(sArr, 0, len - 1);
        reverse(sArr, 0, pos - 1);
        reverse(sArr, pos, len - 1);
        return new String(sArr);
    }

    public static void main(String[] args){
        String s = "abcdef";
        System.out.print(rotateString(s, 3));
    }
}
