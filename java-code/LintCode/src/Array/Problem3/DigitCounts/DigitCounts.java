package Array.Problem3.DigitCounts;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/30 19:45
 *
 * Count the number of k's between 0 and n. k can be 0 - 9.
 *
 * Example
 * Example 1:
 *
 * Input:
 * k = 1, n = 1
 * Output:
 * 1
 * Explanation:
 * In [0, 1], we found that 1 appeared once (1).
 * Example 2:
 *
 * Input:
 * k = 1, n = 12
 * Output:
 * 5
 * Explanation:
 * In [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12],
 * we found that one appeared five times (1, 10, 11, 12)(Note that there are two 1 in 11).
 */
public class DigitCounts {
    /**
     * @param k: An integer
     * @param n: An integer
     * @return: An integer denote the count of digit k in 1..n
     */
    public static int digitCounts(int k, int n) {
        // write your code here
        int res = 0;
        boolean flag = false;
        for (int i=0; i<=n; i++) {
            int tmp = countOf(i,k);
            if (tmp != 0) {
                res += tmp;
                flag = true;
            } else {
                if (flag == true) { // 上一个数中含有k，但是这一个数没有k
                    while (i%10 != 0) {
                        i++;
                    }
                    i-=1;
                    flag = false;
                }
            }
        }
        return res;
    }

    private static int countOf(int i, int k) {
        if (i == k) {
            return 1;
        }

        int count = 0;
        while (i != 0) {
            if (i%10 == k) {
                count++;
            }
            i = i/10;
        }
        return count;
    }

    public static void main(String[] args) {
        int k = 1, n = 12;
        System.out.println(digitCounts(k,n));
    }
}
