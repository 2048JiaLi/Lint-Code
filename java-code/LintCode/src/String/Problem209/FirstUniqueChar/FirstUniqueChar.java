package String.Problem209.FirstUniqueChar;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/28 16:49
 *
 * Find the first unique character in a given string.
 * You can assume that there is at least one unique character in the string.
 *
 * Example
 * Example 1:
 * 	Input: "abaccdeff"
 * 	Output:  'b'
 *
 * 	Explanation:
 * 	There is only one 'b' and it is the first one.
 *
 *
 * Example 2:
 * 	Input: "aabccd"
 * 	Output:  'b'
 *
 * 	Explanation:
 * 	'b' is the first one.
 */
public class FirstUniqueChar{
    /**
     * hash数组用于记录元素出现次数
     * 链表记录出现的次序
     *
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public static char firstUniqChar(String str) {
        // Write your code here
        int[] hash = new int[26];
        Linkedlist current = null;
        Linkedlist tail = null;

        for (int i=0; i<str.length(); i++) {
            int tmp = str.charAt(i) - 'a';
            hash[tmp]++;

            if (hash[tmp] == 1) {
                if (current == null) {
                    current = new Linkedlist(str.charAt(i));
                    tail = current;
                } else {
                    tail.next = new Linkedlist(str.charAt(i));
                    tail = tail.next;
                }
            } else if (hash[tmp] > 1 && current != null){

                if (current.val == str.charAt(i)) {
                    while (current != null && hash[current.val - 'a'] != 1) {
                        current = current.next;
                    }
                }

            }

        }

        return current.val;
    }

    private static class Linkedlist {
        char val;
        Linkedlist next;

        public Linkedlist(char val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        String str = "aaab";
        System.out.println(firstUniqChar(str));
    }
}
