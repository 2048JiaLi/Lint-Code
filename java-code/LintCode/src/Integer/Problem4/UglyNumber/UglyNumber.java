package Integer.Problem4.UglyNumber;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/30 20:26
 *
 * Ugly number is a number that only have prime factors 2, 3 and 5.
 *
 * Design an algorithm to find the nth ugly number.
 * The first 10 ugly numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12...
 *
 * Example
 * Example 1:
 *
 * Input: 9
 * Output: 10
 * Example 2:
 *
 * Input: 1
 * Output: 1
 * Challenge
 * O(n log n) or O(n) time.
 *
 * Notice
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {

    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public static int nthUglyNumber(int n) {
        // write your code here
        if (n <= 6) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;

        int l2 = 0, l3 = 0, l5 = 0; // 丑数指针
        for (int i=1; i<n; i++) {
            int tmp1 = dp[l2]<<1;
            int tmp2 = dp[l3]*3;
            int tmp3 = dp[l5]*5;

            int min = compareOfmin(tmp1,tmp2,tmp3);
            dp[i] = min;
            if (min == tmp1) {
                l2++;
            }
            if (min == tmp2) {
                l3++;
            }
            if (min == tmp3) {
                l5++;
            }
        }
        return dp[n-1];
    }

    public static int compareOfmin(int a, int b, int c) {
        if (a > b) {
            a = b;
        }

        if (a > c) {
            a = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(9));
    }
}
