package question.eight;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/1 15:32
 */
public class RotateString {

    /**
     * Given a string(Given in the way of char array) and an offset, rotate the string by offset in place. (rotate from left to right).
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */

    //Input: str="abcdefg", offset = 3
    //Output: str = "efgabcd"
    public static void rotateString(char[] str, int offset) {
        // write your code here

        // 通过将原本的字符串倒置，可以将后面的旋转到前面。 但是结果两段分别倒置了，再分别将两段倒置回来即可。
        // https://www.jiuzhang.com/solution/rotate-string/
        if (str == null || str.length == 0)
            return;

        offset = offset % str.length;
        reverse(str, 0, str.length - offset - 1);
        reverse(str, str.length - offset, str.length - 1);
        reverse(str, 0, str.length - 1);
    }

    private static void reverse(char[] str, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
        }
    }

        /**
        if (str.length!=0){//最基本得解法，循环右移offset%str.length次
            offset = offset%str.length;
            for (int i=0;i<offset;i++){
                //循环右移1位
                char ch = str[str.length-1];
                for (int j=str.length-2;j>=0;j--){
                    str[j+1] = str[j];
                }
                str[0] = ch;
            }
        }
         **/

    public static void main(String[] args){
        char[] st1 = {'a', 'b', 'c', 'c', 'b', 'a'};

        rotateString(st1,3);
        for (int i=0;i<st1.length;i++){
            System.out.print(st1[i]);
        }

    }
}
