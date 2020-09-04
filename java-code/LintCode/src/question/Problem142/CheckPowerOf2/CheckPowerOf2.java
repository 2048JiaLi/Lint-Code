package question.Problem142.CheckPowerOf2;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/9 18:17
 */

/**
 * Using O(1) time to check whether an integer n is a power of 2.
 *
 * Example
 * Example 1:
 * 	Input: 4
 * 	Output: true
 *
 *
 * Example 2:
 * 	Input:  5
 * 	Output: false
 */
public class CheckPowerOf2 {
    /**
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        /**
         * 观察一下n与n-1这两个数的二进制表示：
         * - 最末位一个1会变成0
         * - 最末位一个1之后的0会全部变成1
         * - 其他位相同
         *
         *         x = 1011 0000
         *       x-1 = 1010 1111
         * x & (x-1) = 1010 0000
         *
         * `n&(n-1)`这个操作，可以起到“消除最后一个1”的功效。
         */
        return (n&(n-1)) == 0; // 如果是2的幂，则其二进制只有一个1，那么操作之后应为0
    }
}
