package String.lc702.concatenated.string.with.uncommon.character;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/31 13:48
 *
 * 给出两个字符串, 你需要修改第一个字符串，将所有与第二个字符串中相同的字符删除,
 * 并且第二个字符串中不同的字符与第一个字符串的不同字符连接
 *
 * Example
 * 样例 1:
 *
 * 输入 : s1 = "aacdb", s2 = "gafd"
 * 输出 : "cbgf"
 * 样例 2:
 *
 * 输入 : "abcs", s2 = "cxzca"
 * 输出 : "bsxz"
 */
public class Concatenated {
    /**
     * @param s1: the 1st string
     * @param s2: the 2nd string
     * @return: uncommon characters of given strings
     */
    public String concatenetedString(String s1, String s2) {
        // write your code here
        // 第一次遍历记录s1所有元素
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s2.length(); i++){
            if(!set.contains(s2.charAt(i))){
                set.add(s2.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<Character> set2 = new HashSet<>();
        for(int i = 0; i < s1.length(); i++){
            if(!set.contains(s1.charAt(i))){
                sb.append(s1.charAt(i));
            }else{
                if(!set2.contains(s1.charAt(i))) {
                    set2.add(s1.charAt(i));
                }
            }
        }

        for(int i = 0; i < s2.length(); i++){
            if(!set2.contains(s2.charAt(i))){
                sb.append(s2.charAt(i));
            }
        }

        return sb.toString();
    }
}
