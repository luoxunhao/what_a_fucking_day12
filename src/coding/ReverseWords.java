package coding;

import java.util.Stack;

/**
 * Created by lxh on 2017/3/23.
 */
public class ReverseWords {
        public String reverseWords(String s) {
            Stack<Character> word = new Stack<Character>();
            Stack<Character> sentence = new Stack<Character>();
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i <= s.length(); i++){
                if(i == s.length() || s.charAt(i) == ' '){
                    if(!word.empty()){
                        if(!sentence.empty()){
                            sentence.push(' ');
                        }
                        while (!word.empty()){
                            sentence.push(word.peek());
                            word.pop();
                        }
                    }
                }else {
                    word.push(s.charAt(i));
                }
            }
            while (!sentence.empty()){
                sb.append(sentence.peek());
                sentence.pop();
            }
            return sb.toString();
        }
}
