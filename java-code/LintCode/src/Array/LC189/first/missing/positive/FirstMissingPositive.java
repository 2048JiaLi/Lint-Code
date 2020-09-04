package Array.LC189.first.missing.positive;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/25 16:32
 *
 * Given an unsorted integer array, find the first missing positive integer.
 *
 * Example
 * Example 1:
 *
 * Input:[1,2,0]
 * Output:3
 * Example 2:
 *
 * Input:[3,4,-1,1]
 * Output:2
 * Challengeif (A == null) {
 *             return 1;
 *         }
 *
 *         for (int i = 0; i < A.length; i++) {
 *             while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
 *                 int tmp = A[A[i]-1];
 *                 if (tmp == A[i]) {
 *                     break; // 相同的数值，不需要执行操作
 *                 }
 *                 A[A[i]-1] = A[i];
 *                 A[i] = tmp;
 *             }
 *         }
 *
 *         for (int i = 0; i < A.length; i ++) {
 *             if (A[i] != i + 1) {
 *                 return i + 1;
 *             }
 *         }
 *
 *         return A.length + 1;
 * Your algorithm should run in O(n) time and uses constant space.
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        /**
         * @param A: An array of integers
         * @return: An integer
         *
         * 两次变量数组，第一次将遍历到的整数1,2,3,4,....,依次交换到数组下标对应位置
         *
         * 第二次遍历得到第一个不符合条件的，即为缺失
         */
        return 0;
    }
}
