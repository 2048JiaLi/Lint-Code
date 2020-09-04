package question.Problem82.Single.Number;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/11 19:05
 *
 * Given 2 * n + 1 numbers, every numbers occurs twice except one, find it.
 *
 * Example
 * Example 1:
 *
 * Input：[1,1,2,2,3,4,4]
 * Output：3
 * Explanation:
 * Only 3 appears once
 * Example 2:
 *
 * Input：[0,0,1]
 * Output：1
 * Explanation:
 * Only 1 appears once
 * Challenge
 * One-pass, constant extra space.
 */
public class SingleNumber {
    /**
     * @param A: An integer array
     * @return: An integer
     */

    // 异或运算 ^， 相同为0，相异为1。  且具有结合律和交换律
    // 即 a^b^a = (a^a)^b ， a^b = b^a
    public static int singleNumber(int[] A) {
        // write your code here
        int tmp = 0;
        for (int i=0;i<A.length;i++){
            tmp = tmp^A[i];
        }
        return tmp;
    }

    public static void main(String[] args){
        int[] A = {1,1,2,2,3,4,4};
        System.out.print(singleNumber(A));
    }
}
