package String.lc720.rearrange.string.with.integer;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/30 15:50
 *
 * Given a string containing uppercase alphabets and integer digits (from 0 to 9),
 * write a function to return the alphabets in the order followed by the sum of digits.
 *
 * Example
 * Example 1:
 *
 * Input : str = "AC2BEW3"
 * Output : "ABCEW5"
 * Explanation :
 * Alphabets in the lexicographic order, followed by the sum of integers(2 and 3).
 */
public class RearrangeStringWithIntegers {
    /**
     * @param str: a string containing uppercase alphabets and integer digits
     * @return: the alphabets in the order followed by the sum of digits
     */
    public static String rearrange(String str) {
        // Write your code here

        // 前 0-25记录大写字母，26位记录数字和
        int[] map = new int[27];

        // 第一次循环，记录字符串中元素
        for (int i = 0; i < str.length(); i++) {
            int tmp = str.charAt(i) - 'A';
            // 是大写字母类型
            if (tmp>=0 && tmp<=25) {
                map[tmp] += 1;
            } else {
                // 0-9数字类型
                map[26] += str.charAt(i)-'0';
            }
        }

        StringBuffer buffer = new StringBuffer();
        int pos = 0;
        while (pos < map.length-1) {
            if (map[pos] == 0) {
                pos++;
                continue;
            }
            buffer.append((char) (pos+'A'));
            map[pos]--;
        }
        buffer.append(map[map.length-1]);
        return buffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(rearrange("AC2BEW3"));
    }

}
