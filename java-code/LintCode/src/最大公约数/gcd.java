package 最大公约数;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/13 15:07
 */
public class gcd {
    public static int MaximumCommonDivisor (int A, int B) {
        // 记录较大的数
        int max, min;
        if (A > B) {
            max = A;
            min = B;
        } else {
            max = B;
            min = A;
        }

        while ( min > 0 ) {
            int r = max % min; // 余数
            max = min;
            min = r;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(MaximumCommonDivisor(18,6));
    }
}
