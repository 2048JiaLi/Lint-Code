package Array.Problem265.MaximumNonNegativeSubarray;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/7 15:46
 *
 * Given an integer arrayA, find the contiguous array
 * (containing at least one number, and each numer is non negative),
 * which has the largest sum and return its sum
 *
 * Example
 * input:[1,2,-3,4,5,-6]
 * output:9
 * explation:
 * A[0]=1
 * A[1]=2
 * A[0]+A[1]=3
 * A[3]=4
 * A[4]=5
 * A[3]+A[4]=9
 *
 * Notice
 * return -1 if each number of A is negative
 * 1 \leq A.length \leq 10^51≤A.length≤10
 * ​5
 * ​​
 * 0 \leq |A_i| \leq 10000≤∣A
 * ​i
 * ​​ ∣≤1000
 */
public class MaximumNonNegativeSubarray {
    /**
     * @param A: an integer array
     * @return: return maxium contiguous non-negative subarray sum
     */
    public static int maxNonNegativeSubArray(int[] A) {
        // write your code here
        // 定义一个返回值res初始为-1
        int res = -1;
        // flag标记是否需要相加
        boolean flag = true;
        int tmp = -1; // 子数组的和

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                flag = false;
                res = tmp>res?tmp:res;
                tmp = -1;
            } else {
                flag = true;
            }

            if (flag) {
                if (tmp == -1) {
                    tmp = A[i];
                } else {
                    tmp += A[i];
                }
            }
        }
        return tmp>res?tmp:res;
    }

    public static void main(String[] args) {
        int[] A = {1,2};
        System.out.println(maxNonNegativeSubArray(A));
    }
}
