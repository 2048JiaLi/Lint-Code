package ByteCode.Problem181.FlipBits;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/23 15:06
 *
 * Determine the number of bits required to flip
 * if you want to convert integer n to integer m.
 *
 * Example
 * Example 1:
 * 	Input: n = 31, m = 14
 * 	Output:  2
 *
 * 	Explanation:
 * 	(11111) -> (01110) there are two different bits.
 *
 *
 * Example 2:
 * 	Input: n = 1, m = 7
 * 	Output:  2
 *
 * 	Explanation:
 * 	(001) -> (111) will change two bits.
 *
 *
 * Notice
 * Both n and m are 32-bit integers.
 */
public class FlipBits {
    /**
     * @param a: An integer
     * @param b: An integer
     * @return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        /**
         * 先异或，结果中有多少位为1，就需要多少次翻转
         */

        int tmp = a^b;
        int res = 0;
        while (tmp != 0) {
            tmp = tmp & (tmp-1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 1, m = 7;
        System.out.println(bitSwapRequired(n,m));
    }
}
