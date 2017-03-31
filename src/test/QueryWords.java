package test;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by lxh on 2017/3/31.
 */
public class QueryWords {
    public static int getQueryNum(String sentence, String query){
        HashSet<String> dict = getDictionary(sentence.toLowerCase());
        int count = 0;
        StringBuffer sb = new StringBuffer();
        query = query.toLowerCase();
        for (int i = 0; i <= query.length(); i++){
            if (i == query.length() || query.charAt(i) == ' '){
                if (sb.length() > 0 && dict.contains(sb.toString())){
                    count++;
                    dict.remove(sb.toString());
                }
            }else {
                sb.append(query.charAt(i));
            }
        }
        return count;
    }
    public static HashSet<String> getDictionary(String s){
        HashSet<String> dictionary = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= s.length(); i++){
            if (i == s.length() || s.charAt(i) == ' '){
                if (sb.length() > 0){
                    dictionary.add(sb.toString());
                    sb.delete(0,sb.length());
                }
            }else {
                sb.append(s.charAt(i));
            }
        }
        return dictionary;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            String[] sentence = new String [n];
            String[] query = new String[m];
            for (int i = 0; i < n; i++){
                sentence[i] = sc.nextLine();
            }
            for (int i = 0; i < m; i++){
                query[i] = sc.nextLine();
            }
            System.out.println(getQueryNum(sentence[0], query[0]));
        }
    }
}
