package Array.LC424.evaluate.reverse.polish.notation;

import java.util.Stack;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/24 19:13
 *
 * 求逆波兰表达式的值。
 *
 * 在逆波兰表达法中，其有效的运算符号包括 +, -, *, / 。
 * 每个运算对象可以是整数，也可以是另一个逆波兰计数表达。
 *
 * Example
 * 样例 1:
 *
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ["2", "1", "+", "3", "*"] -> (2 + 1) * 3 -> 9
 * 样例 2:
 *
 * 输入: ["4", "13", "5", "/", "+"]
 * 输出: 6
 * 解释: ["4", "13", "5", "/", "+"] -> 4 + 13 / 5 -> 6
 */
public class Evaluate {

    /**
     * @param tokens: The Reverse Polish Notation
     * @return: the value
     */
//    public int evalRPN(String[] tokens) { // 栈解法
//        // write your code here
//        Stack<Integer> s = new Stack<Integer>();
//        String operators = "+-*/";
//        for (String token : tokens) {
//            if (!operators.contains(token)) {
//                s.push(Integer.valueOf(token));
//                continue;
//            }
//
//            int a = s.pop();
//            int b = s.pop();
//            if (token.equals("+")) {
//                s.push(b + a);
//            } else if(token.equals("-")) {
//                s.push(b - a);
//            } else if(token.equals("*")) {
//                s.push(b * a);
//            } else {
//                s.push(b / a);
//            }
//        }
//        return s.pop();
//    }
    public static int evalRPN(String[] tokens) {
        // write your code here
        int[] tmp = new int[tokens.length]; // 用数组代替栈
        int size = 0; // size标记存储的元素位置
        for (String token : tokens) {
            switch (token){
                case "+": {
                    tmp[size-2] = tmp[size-2] + tmp[size-1];
                    break;
                }
                case "-": {
                    tmp[size-2] = tmp[size-2] - tmp[size-1];
                    break;
                }
                case "*": {
                    tmp[size-2] = tmp[size-2] * tmp[size-1];
                    break;
                }
                case "/": {
                    tmp[size-2] = tmp[size-2] / tmp[size-1];
                    break;
                }
                default: {
                    tmp[size++] = Integer.valueOf(token);
                    continue;
                }
            }
            size--;
        }
        return tmp[size-1];
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"0","3","/"}));
    }
}
