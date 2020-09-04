package String.Problem250.SpecialPalindromeString;

import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/12 14:56
 *
 * 判断字符串是否是回文字符串
 *
 * 但是有一个双向配对的字母列表，其中给出了一些可以用于替换的字母
 * 若替换之后为回文，则该字符串也是回文字符串
 *
 * Example
 * 示例1:
 * 输入：ambigram=["at", "by", "yh", "hn", "mw", "ww"], word="swims"
 * 输出：true
 * 说明：“w”可以被“m”代替后字符串变成了“smims”，其是回文字符串，因此返回true。
 */
public class SpecialPalindrome {
    /**
     * @param ambigram: A list of paired ambigram letter.
     * @param word: A string need to be judged.
     * @return: If it is special palindrome string, return true.
     */
    public boolean ispalindrome(List<String> ambigram, String word) {
        // write your code here.

        // 长度为26的数组，每个位置对应一个字母，值对应着能替换的字母
        MyAmbigramDict[] my = BuiltAmbigramDict(ambigram);

        int left = 0, right = word.length()-1;
        while (left<right) {
            if (word.charAt(left) != word.charAt(right)) {
                int posLeft = word.charAt(left)-'a', posRight = word.charAt(right)-'a';
                if (my[posLeft] != null || my[posRight] != null) {
                    boolean[] tmp = new boolean[26];
                    tmp[posLeft] = true;
                    MyAmbigramDict ambig = my[posLeft];
                    while (ambig != null) {
                        tmp[ambig.x - 'a'] = true;
                        ambig = ambig.next;
                    }

                    if (tmp[posRight] == false) {   // 进入right的替换序列找
                        ambig = my[posRight];
                        while (ambig != null && tmp[ambig.x-'a'] != true) {
                            ambig = ambig.next;
                        }

                        if (ambig == null || tmp[ambig.x-'a'] == false) {
                            return false;
                        }
                    }

                } else {// 没有能够替换的（且不匹配）
                    return false;
                }
            }

            left++;
            right--;
        }

        return true;
    }

    public MyAmbigramDict[] BuiltAmbigramDict(List<String> ambigram) {
        MyAmbigramDict[] my = new MyAmbigramDict[26];
        for (String s :
                ambigram) { // 考虑一个字母可能有多个对应的替换
            int pos = s.charAt(0)-'a';
            if (my[pos] != null) {
                // 已经有替换的值
                MyAmbigramDict tmp = my[pos];
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = new MyAmbigramDict(s.charAt(1));
            } else {
                my[pos] = new MyAmbigramDict(s.charAt(1));
            }

            pos = s.charAt(1) - 'a';
            boolean flag = false;
            if (my[pos] != null) {
                // 已经有替换的值
                MyAmbigramDict tmp = my[pos];
                while (tmp.next != null) {
                    if (tmp.x == s.charAt(0)) {
                        flag = true;
                        break;
                    }
                    tmp = tmp.next;
                }
                if (!flag) {
                    tmp.next = new MyAmbigramDict(s.charAt(0));
                }
            } else {
                my[pos] = new MyAmbigramDict(s.charAt(0));
            }
        }
        return my;
    }

    private class MyAmbigramDict {
        char x;
        MyAmbigramDict next;

        public MyAmbigramDict(char x) {
            this.x = x;
            this.next = null;
        }
    }
}
