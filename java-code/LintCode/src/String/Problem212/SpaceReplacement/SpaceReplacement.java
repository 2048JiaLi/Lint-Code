package String.Problem212.SpaceReplacement;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/29 15:32
 *
 *
 * 设计一种方法，将一个字符串中的所有空格替换成 %20 。
 * 你可以假设该字符串有足够的空间来加入新的字符，且你得到的是“真实的”字符长度。
 *
 * 你的程序还需要返回被替换后的字符串的长度。
 *
 * Example
 * 样例 1：
 *
 * 输入：string[] = "Mr John Smith" and length = 13
 * 输出：string[] = "Mr%20John%20Smith" and return 17
 * 解释：
 * 对于字符串 "Mr John Smith"，长度为 13。替换空格之后，
 * 参数中的字符串需要变为 "Mr%20John%20Smith"，并且把新长度 17 作为结果返回。
 * 样例 2：
 *
 * 输入：string[] = "LintCode and Jiuzhang" and length = 21
 * 输出：string[] = "LintCode%20and%20Jiuzhang" and return 25
 * 解释：
 * 对于字符串 "LintCode and Jiuzhang"，长度为 21。替换空格之后，
 * 参数中的字符串需要变为 "LintCode%20and%20Jiuzhang"，并且把新长度 25 作为结果返回。
 * Challenge
 * 在原字符串(字符数组)中完成替换，不适用额外空间
 *
 * Notice
 * 如果使用 Java 或 Python, 程序中请用字符数组表示字符串。
 */
public class SpaceReplacement {
    /*
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public static int replaceBlank(char[] string, int length) {
        // write your code here
        /**
         * > 注意，所有出现的空格都要转换
         *
         * 如 a  b（两个空格），输出为 a%20%20b
         */
        int newLen = 0;
        for (int i=0; i<length; i++) { // 计算新长度
            if (string[i] == ' ') {
                newLen += 3;
            } else {
                newLen += 1;
            }
        }

        int pos = newLen-1;

        for (int i=length-1; i>=0; i--) {
            if (i > pos) {break;}

            if (string[i] != ' ') {
                string[pos--] = string[i];
            } else {
                string[pos--] = '0';
                string[pos--] = '2';
                string[pos--] = '%';
            }
        }
        return newLen;
    }

    public static void main(String[] args) {
        char[] string = {' ', 'a', 'b', ' ', ' ', 'd', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' };
        System.out.println(replaceBlank(string,7));
        System.out.println(string);
    }
}
