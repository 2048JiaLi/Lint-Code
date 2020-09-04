package String.Problem193.LongestValidParentheses;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/27 14:48
 *
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed)
 * parentheses substring.
 *
 * Example
 * Example 1:
 *
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * Example 2:
 *
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 */
public class LongestValidParentheses {

    /**
     * 想使用记录位置的方法，但是在Lintcode上没有通过（不知哪里出错），留作以后发现问题原因
     *
     * @param s: a string
     * @return: return a integer
     */
    public static int longestValidParentheses(String s) {
        int stack = 0;
        Valid res = new Valid(0,-1);

        int[] leftParenthese = new int[s.length()];
        int pos = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack++;
                leftParenthese[pos++] = i;
            } else {
                Valid tmp = res;
                if (stack > 0) {
                    stack--;
                    pos--;

                    int currentLength = i - leftParenthese[pos] + 1;

                    // 只要减了，就表示可以判断

                    if (leftParenthese[pos] == tmp.end + 1) {
                        tmp.end = i;
                    } else if (currentLength > tmp.getDiff()) {
                        tmp.start = leftParenthese[pos];
                        tmp.end = i;
                    }

                }

                if (tmp.getDiff() > res.getDiff()) {
                    res = tmp;
                }
            }
        }

        return res.getDiff();
    }


    private static class Valid {
        int start;
        int end;

        public Valid(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public int getDiff() {
            if (this.start != this.end) {
                return this.end - this.start + 1;
            }
            return 0;
        }
    }


    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(longestValidParentheses(s));
    }
}
