package Array.Problem1424.LongestMountainSubArray;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/8 16:13
 *
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:
 *
 * B.length >= 3
 * There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * (Note that B could be any subarray of A, including the entire array A.)
 * Given an array A of integers, return the length of the longest mountain.
 *
 * Return 0 if there is no mountain.
 *
 * Example
 * Example 1:
 *
 * Input: [2,1,4,7,3,2,5]
 * Output: 5
 * Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 * Example 2:
 *
 * Input: [2,2,2]
 * Output: 0
 * Explanation: Explanation: There is no mountain.
 * Challenge
 * Can you solve it using only one pass?
 * Can you solve it in O(1) space?
 * Notice
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class LongestMountainSubArray {
    /**
     * @param A:
     * @return: the length of the longest mountain
     */
    public static int longestMountain(int[] A) {
        // write your code here
        if (A == null) {return 0;}

        int longest = 0;
        int mount = 0;
        boolean flag;
        int pos = 0;
        while (pos < A.length-1) {
            if (A[pos+1] > A[pos]) {
                flag = true;
            } else {flag = false;}

            if (flag) {
                mount += 1;
            } else {
                if (mount > 0) {
                    while (pos < A.length-1 && A[pos+1] < A[pos]) {
                        pos++;
                        mount += 1;
                    }
                    longest = mount+1>longest?mount+1:longest;
                    mount = 0;
                }
            }
            pos++;
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] A = {2,2,2};
        longestMountain(A);
    }
}
