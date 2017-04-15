package test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by lxh on 2017/4/15.
 */
public class LongestSubstringWithoutRepeatChar {
    private static String str = null;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            str = sc.nextLine();
            System.out.println(lengthOfLongestSubstring(str));
        }
    }

    public static int lengthOfLongestSubstring(String s) {
        //"abba"
        int n = s.length();
        int first = 0;
        int max = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            if (map.containsKey(s.charAt(i))){
                first = Math.max(map.get(s.charAt(i))+1, first);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-first+1);
        }
        return max;
    }
}
