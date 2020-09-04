package parentheses.LC427.generate.parentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/27 17:50
 *
 * Given n, and there are n pairs of parentheses,
 * write a function to generate all combinations of well-formed parentheses.
 *
 * Example
 * Example 1:
 *
 * Input: 3
 * Output: ["((()))", "(()())", "(())()", "()(())", "()()()"]
 * Example 2:
 *
 * Input: 2
 * Output: ["()()", "(())"]
 */
public class GenerateParentheses {

    /**
     * @param n: n pairs
     * @return: All combinations of well-formed parentheses
     *
     * 回溯解法：https://mp.weixin.qq.com/s/XVnoX-lBzColVvVXNkGc5g
     */
    public static List<String> generateParenthesis(int n) {
        // write your code here
        if (n == 0) {
            // n = 0没有有效括号
            return new ArrayList<>();
        }
        // 结果
        List<String> res = new ArrayList<>();
        // 路径
        MyStack track = new MyStack();
        // 可用的左括号和右括号数量初始化为 n
        backtrack(n,n,track,res);
        return res;
    }

    public static void backtrack(int left, int right, MyStack track, List<String> res) {
        // 若左括号剩下的多，说明不合法
        if (right < left) {
            return;
        }
        // 数量小于 0 肯定是不合法的
        if (left < 0 || right < 0) {
            return;
        }
        // 当所有括号都恰好用完时，得到一个合法的括号组合
        if (left == 0 && right == 0) {
            res.add(track.toString());
            return;
        }

        // 尝试放一个左括号
        // 选择
        track.push('(');
        backtrack(left - 1, right, track, res);
        track.pop(); // 撤消选择

        //  尝试放一个右括号
        // 选择
        track.push(')');
        backtrack(left, right - 1, track, res);
        track.pop(); // 撤消选择
    }
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
//        char[] res = new char[]{'1','3'};
//        System.out.println(String.valueOf(res));
    }

    static class MyStack{
        Stack<Character> stack = new Stack<>();

        @Override
        public String toString() {
            char[] res = new char[stack.size()];
            for (int i = 0; i < stack.size(); i++) {
                res[i] = stack.get(i);
            }
            return String.valueOf(res);
        }

        public void pop() {
            stack.pop();
        }

        public void push(Character item) {
            stack.push(item);
        }
    }
}
