package Integer.LC140.fast.power;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/20 16:22
 *
 * Calculate the a^n % b where a, b and n are all 32bit non-negative integers.
 *
 * Example
 * For 2^31 % 3 = 2
 *
 * For 100^1000 % 1000 = 0
 *
 * Challenge
 * O(logn)
 */
public class FastPower {

    public int fastPower(int a, int b, int n) {
        /**
         * 非递归版本，思路是转换为二进制
         *
         * 注意幂次是二进制：
         * a^10 = a^(1010) = a^(1000)*a^(10)
         */
        long ans = 1, tmp = a;

        while (n != 0) {
            tmp %= b;
            if (n % 2 == 1) {
                ans = (ans%b * tmp) % b;
            }
            tmp = (tmp * tmp) % b;
            n = n >> 1;
        }
        return (int) ans % b;
    }
}
