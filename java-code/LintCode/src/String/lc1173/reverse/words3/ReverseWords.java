package String.lc1173.reverse.words3;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/8/26 12:45
 */
public class ReverseWords {
    /**
     * @param s: a string
     * @return: reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order
     */
    public static String reverseWords(String s) {
        // Write your code here
        
        /* Memory Limit Exceeded */
        String res = "";
        String reverse = "";
        boolean inwords = false;
        for (int i=0; i<s.length(); i++) {
            if (inwords) {
                if (s.charAt(i) == ' ') {
                    res += reverse;

                    res += " ";
                    inwords = false;
                    reverse = "";
                } else {
                    reverse = s.charAt(i)+reverse;
                }
            } else {
                if (s.charAt(i) == ' ') {
                    res += " ";
                } else {
                    reverse = s.charAt(i)+reverse;
                    inwords = true;
                }
            }

        }
        if (!reverse.isEmpty()) {
            res += reverse;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's  take LeetCode contest"));
    }
}
