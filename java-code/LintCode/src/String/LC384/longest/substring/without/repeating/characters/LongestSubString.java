package String.LC384.longest.substring.without.repeating.characters;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/15 14:39
 *
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The longest substring is "abc".
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The longest substring is "b".
 * Challenge
 * time complexity O(n)
 *
 * 注意，字符串不限于小写字母
 */
public class LongestSubString {
    /**
     * @param s: a string
     * @return: an integer
     */
    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        /*
        注意，
         */
        boolean[] characters = new boolean[255]; // 不止小写字母，lintcode中，128也是可行的
        int res = 0;
        int left = 0, right = 0;

        while (right < s.length()) {
            // right指针始终向右移动
            if (characters[(int) s.charAt(right)] == true) {
                // 当前left至right段子串中存在 s.charAt(right)字符出现了两次

                // 记录该子串，若长度大于结果res，则替换
                // String tmp = s.substring(left,right); // substring会找到 [left,right)位置的子串
                if (right-left > res) {
                    res = right-left;
                }

                // 执行操作，用于找下一个子串
                while (s.charAt(left) != s.charAt(right)) {
                    // 找到该子串中的另一个 s.charAt(right) 字符位置
                    characters[(int) s.charAt(left)] = false; // left走过的位置，都标记为false
                    left++;
                }
                // 此时left的位置是第二个 s.charAt(right)字符
                left++; // 移到下一个位置，这里不需要对characters进行改动，因为此字符必然出现了（right位置）
            } else {
                characters[(int) s.charAt(right)] = true;
            }
            right++;
        }

        if (right - left > res) {
            res = right-left;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "an++--viaj";

        System.out.println(lengthOfLongestSubstring(s));
    }
}
