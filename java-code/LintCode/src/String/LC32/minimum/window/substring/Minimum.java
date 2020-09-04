package String.LC32.minimum.window.substring;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/16 16:20
 */
public class Minimum {
    /**
     * @param s : A string
     * @param t: A string
     * @return: A string denote the minimum window, return "" if there is no such a string
     */
    public static String minWindow(String s, String t) {
        /**
         * 不忽略t中重复的元素
         */
        // 在s中找t的最小覆盖子串
        int left = 0, right = 0;
        String res = s+"#"; // 记录的结果字符串

        // 两个计数器Map
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> needs = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if (needs.containsKey(t.charAt(i))) {
                needs.put(t.charAt(i),needs.get(t.charAt(i))+1);
            } else {
                needs.put(t.charAt(i),1);
            }
        }

        // 记录window中已经有多少字符匹配
        int match = 0;

        while (right < s.length()) {
            char ch = s.charAt(right);

            if (needs.containsKey(ch)) {
                if (window.containsKey(ch)) {
                    window.put(ch,window.get(ch)+1);
                } else {
                    window.put(ch,1);
                }

                //System.out.println(window.get(ch));
                //System.out.println(needs.get(ch).equals(window.get(ch)));

                if (needs.get(ch).equals(window.get(ch))) { // 这里必须使用equals!!!!，因为当数value大于127时, Integer 128 == Integer 128 为false（缓冲池问题）
                    // 该字符成功匹配
                    match++;
                }
            }
            right++;

            while (match == needs.size()) {
                // 更新结果
                if (right - left < res.length()) {
                    res = s.substring(left,right);
                }
                ch = s.charAt(left);
                if (needs.containsKey(ch)) {
                    window.put(ch,window.get(ch)-1);
                    if (window.get(ch) < needs.get(ch)) {
                        match--;
                    }
                }
                left++;
            }
        }

        return res.length()>s.length()?"":res;
    }

    public static String SimpleMinWindow(String s, String t) {
        // 简化上面代码
        int left, right;
        left = right = 0;

        String res = "";
        int diff = Integer.MAX_VALUE;
        int[] window = new int[128];    // 不止小写字母
        int[] needs = new int[128];
        int characters = 0; // t中不同字符的个数

        for (int i = 0; i < t.length(); i++) {
            int pos = t.charAt(i);
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
                if (right - left < diff) {
                    res = s.substring(left,right);
                    diff = right-left;
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

    public static void main(String[] args) {
        String source = "adobecodebanc",
                target = "abc";
        //System.out.println(minWindow(source,target));
        System.out.println(SimpleMinWindow(source,target));
    }
}
