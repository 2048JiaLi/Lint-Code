package question.Problem158.Valid.Anagram;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/18 15:23
 *
 * Write a method anagram(s,t) to decide if two strings are anagrams or not.
 *
 * Example
 * Example 1:
 *
 * Input: s = "ab", t = "ab"
 * Output: true
 * Example 2:
 *
 * Input:  s = "abcd", t = "dcba"
 * Output: true
 * Example 3:
 *
 * Input:  s = "ac", t = "ab"
 * Output: false
 * Challenge
 * O(n) time, O(1) extra space
 *
 * Clarification
 * What is Anagram?
 *
 * Two strings are anagram if they can be the same after change the order of characters.
 *
 * 改变字母顺序就可以获得，那么他们就是变位词
 * 最终问题等价于，找两个字符串中，各字母的出现次数都相同（总长度相同）
 */
public class ValidAnagram {
    /**
     * 异或运算可以保留不同（相异为1），且具有运算性质
     * 但是因为可能存在重复的字符，a ⊕ a = 0
     *
     * 异或结果为0并不能保证所有元素都相同，但是所有元素相同的异或结果必然为0
     * 设计hash尽可能保证不同元素的hash不一样
     *
     *
     * 注：该题与211. String Permutation题相同
     *
     * @param s: The first string
     * @param t: The second string
     * @return: true or false
     */
    public static boolean anagram(String s, String t) {
        // write your code here

        // 不同长度，必然不是变位词
        if (s.length()!=t.length()) {return false;}

        int xor = 0, hash =0;
        for (int i=0; i<s.length(); i++) {
            int sv = s.charAt(i)-'a'+1; // 转为int
            int tv = t.charAt(i)-'a'+1;
            xor = xor ^ sv ^ tv; // 异或
            hash += sv%13-tv%13; // 计算总和
        }

        return xor==0 && hash==0;
    }



    public static void main(String[] args) {
        String s = "az", t = "by";
        System.out.println(anagram(s,t));
    }
}
