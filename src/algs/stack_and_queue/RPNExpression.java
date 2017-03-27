package algs.stack_and_queue;

/**
 * Created by lxh on 2017/3/5.
 */

import java.util.Stack;

/**
 * 逆波兰表达式：一种不需要括号的后缀表达式，所有的符号都是在要运算数字的后面出现。
 *
 * 计算规则：从左到右遍历表达式的每个数字和符号，遇到数字就进栈，遇到符号，
 * 就将栈顶两个数字出栈，进行运算，运算结果进栈，直到最终获得结果。
 *
 * 标准四则运算表达式（中缀表达式(Infix Expression)）转后缀表达式(Postfix Expression)：
 * 从左到右遍历中缀表达式的每个数字和符号，
 * （1）若是数字就输出，即成为后缀表达式的一部分；
 * （2）若是符号：
 *     1） 左括号 '(' ：进栈;
 *     2） 右括号 ')' ：栈顶元素依次输出直到遇到 '(';
 *     3） '+ - * /'  ：判断其他跟栈顶符号的优先级，
 *                 优先级 <= 栈顶符号，则栈顶元素依次出栈并输出，当前符号进栈
 *                 优先级 > 栈顶元素，当前符号进栈
 *
 * 计算中缀表达式关键的两步：
 * （1）将中缀表达式转化为后缀表达式（栈用来进出运算的符号）
 * （2）将后缀表达式进行运算得出结果（栈用来进出运算的数字）
 */
public class RPNExpression {
    /*
    bug: 只能处理一位整数的运算。假设输入的公式合法
    拓展：处理多位整数
     */

    /**
     * 1、中缀表达式转换为后缀表达式
     * @param infix
     * @return 后缀表达式字符串
     */
    public static String infixToPostfix(String infix){
        StringBuilder sb = new StringBuilder();;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < infix.length(); i++){
            char ch = infix.charAt(i);
            if (ch >= '0' && ch <= '9'){
                sb.append(ch);
                continue;
            }
            if (ch == '('){
                stack.push(ch);
                continue;
            }
            if (ch == ')'){
                while (stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.pop();
                continue;
            }
            if (ch == '*' || ch == '/'){
                while (stack.peek() != '+' && stack.peek() != '-'){
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }else if (ch == '+' || ch == '-'){
                while (!stack.empty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    public static int postfixSolver(String postfix){
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < postfix.length(); i++){
            char ch = postfix.charAt(i);
            if (ch >= '0' && ch <= '9'){
                stack.push(ch - '0');
            }else { // + - * /
                int a = 0, b = 0;
                switch (ch){
                    case '+':
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b + a);
                        break;
                    case '-':
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b - a);
                        break;
                    case '*':
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b * a);
                        break;
                    case '/':
                        a = stack.pop();
                        b = stack.pop();
                        stack.push(b / a);
                        break;

                }
            }
        }
        return stack.pop();
    }
}
