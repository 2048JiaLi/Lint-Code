package question.Problem365.CountOneinBinary;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/9 18:27
 */

/**
 * Count how many 1 in binary representation of a 32-bit integer.
 *
 * Example
 * Example 1:
 *
 * Input: 32
 * Output: 1
 * Explanation:
 * 32(100000), return 1.
 * Example 2:
 *
 * Input: 5
 * Output: 2
 * Explanation:
 * 5(101), return 2.
 */

public class CountOneinBinary {
    /*
     * @param num: An integer
     * @return: An integer
     */

    // 利用二进制中 n&(n-1)的性质
    public static int countOnes(int num) {
        // write your code here
        int count = 0;
        while (num != 0){
            count += 1;
            num = num&(num-1);
        }
        return count;
    }

    public static void main(String[] args){
        System.out.print(countOnes(5));
    }
}
