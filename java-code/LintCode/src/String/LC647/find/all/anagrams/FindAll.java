package String.LC647.find.all.anagrams;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/17 13:26
 */
public class FindAll {
    /**
     * @param s: a string
     * @param p: a string
     * @return: a list of index
     */
    public static List<Integer> findAnagrams(String s, String p) {
        // write your code here
        /**
         * 类似LC32的滑动解法，只是修改了更新结果的部分
         */
        int left, right;
        left = right = 0;

        List<Integer> res = new ArrayList<>();
        int[] window = new int[128];
        int[] needs = new int[128];
        int characters = 0; // t中不同字符的个数

        for (int i = 0; i < p.length(); i++) {
            int pos = p.charAt(i);
            needs[pos]++;
            if (needs[pos] == 1) {
                characters++;
            }
        }

        int match = 0;
        while (right < s.length()) {
            int pos = s.charAt(right);

            if (needs[pos] > 0) {
                window[pos]++;

                if (needs[pos] == window[pos]) {
                    match++;
                }
            }
            right++;

            while (match == characters) {
                if (right - left == p.length()) {
                    res.add(left);
                }
                pos = s.charAt(left);
                if (needs[pos] > 0) {
                    window[pos]--;
                    if (window[pos] < needs[pos]) {
                        match--;
                    }
                }
                left++;
            }
        }
        return res;
    }

    public static List<Integer> find(String s, String p) {
        /**
         * 尝试其他解法
         *
         * LC158题解法  异或+hash可以快速判断是否为 anagram异位词
         *
         * 窗口可固定为p.length大小，不断移动窗口，判断窗口内的子串是否满足条件
         *
         * 性质： a^b^b = a; 异或运算
         *
         */

        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) {return res;}

        int por, phash,  // 目标子串的异或值，和hash值
                mor, mhash; // 滑动窗口异或值与hash值
        por = phash = mor = mhash = 0;
        for (int i=0; i<p.length(); i++) {
            int pv = p.charAt(i); // 转为int
            int mv = s.charAt(i);
            por = por ^ pv; // 异或
            phash += pv%13; // 计算总和

            mor = mor ^ mv;
            mhash += mv%13;
        }

        if (mor==por && phash==mhash) {res.add(0);} // 第一个窗口满足条件
        /*到这里窗口已经固定为p.length大小了，开始滑动与判断*/

        int left = 0, right = p.length();
        while (right < s.length()) {
            int rv = s.charAt(right);
            int lv = s.charAt(left);

            mor ^= lv ^ rv; // 先异或left位置消除（x^a^a=x），再异或right位置添加
            mhash += rv%13 - lv%13;

            left++;
            right++;
            if (mor == por && mhash == phash) {
                res.add(left);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s =  "cbaebabacd", p = "abc";
        //System.out.println(findAnagrams(s,p));
        System.out.println(find(s,p));
    }
}
