package Array.com.ByteDance2020.Problem1901.SquareOfSortedArray;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/2 17:58
 *
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * Example
 * Example 1
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * Notice
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class SquareOfSortedArray {

    /**
     * @param A: The array A.
     * @return: The array of the squares.
     */
    public static int[] SquareArray(int[] A) {
        //
        /**
         * 不考虑空间开销，双指针，构建新的数组
         */
        int left = 0, right = A.length-1;
        int[] res = new int[A.length];
        int tmp = A[left]*A[left];
        boolean isLeft = true;

        for (int i=right; i>=0; i--) {
            if (left > right) {
                break;
            }
            if (isLeft) {
                int x = A[right]*A[right];
                if (x >= tmp) {
                    res[i] = x;
                    right--;
                    // tmp 不变 ， isLeft不变
                } else {
                    res[i] = tmp;
                    left++;
                    tmp = x;
                    isLeft = false;
                }
            } else {
                int x = A[left]*A[left];
                if (x >= tmp) {
                    res[i] = x;
                    left++;
                    isLeft = false;
                } else {
                    res[i] = tmp;
                    right--;
                    tmp = x;
                    isLeft = true;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        for (int n: SquareArray(nums)
             ) {
            System.out.println(n);
        }
    }
}
