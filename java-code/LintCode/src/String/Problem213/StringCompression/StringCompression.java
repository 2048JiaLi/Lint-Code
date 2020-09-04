package String.Problem213.StringCompression;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/29 16:15
 *
 * Implement a method to perform basic string compression using
 * the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 *
 * If the "compressed" string would not become smaller than
 * the original string, your method should return the original string.
 *
 * You can assume the string has only upper and lower case letters (a-z).
 *
 * Example
 * Example 1:
 *
 * Input: str = "aabcccccaaa"
 * Output: "a2b1c5a3"
 * Example 2:
 *
 * Input: str = "aabbcc"
 * Output: "aabbcc"
 */
public class StringCompression {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public static String compress(String originalString) {
        // write your code here
        /**
         * 字符串由小写字母组成
         *
         * 字符串拼接使用 '+' 操作符，非常耗时
         */
        if (originalString.isEmpty()) {return originalString;}

        //String res = "";
        StringBuffer res = new StringBuffer();

        int left = 0, right = 0;
        int tmp;
        while (right < originalString.length()) {
            if (originalString.charAt(right) != originalString.charAt(left)) {
                tmp = right-left;
                //res += "" + originalString.charAt(left) + tmp;
                res.append(originalString.charAt(left));
                res.append(tmp);

                left = right;
            }
            right++;
        }

        tmp = right - left;
        //res += "" + originalString.charAt(left) + tmp;
        res.append(originalString.charAt(left));
        res.append(tmp);

        return res.length()<originalString.length()? res.toString() : originalString;
    }

    public static void main(String[] args) {
        String s = "aabcccccaaa";
        System.out.println(s.length());
        System.out.println(compress(s));
    }
}
