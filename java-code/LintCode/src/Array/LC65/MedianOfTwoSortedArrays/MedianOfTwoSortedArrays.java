package Array.LC65.MedianOfTwoSortedArrays;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/14 16:53
 *
 * 在两个有序数组中，找到中位数
 *          * 令len = A.length + B.length
 *          * 题目等价于
 *          * 1. 当len % 2 != 0时，在A，B数组中找到第 k = len/2大的数（最中间的一个数）
 *          * 2. 当len % 2 == 0时，第 k=len/2的数，和k-1的数的 1/2倍为中位数
 *          *
 *          * 最终可等价为在两个有序数组中，找第k = len/2大的数
 */
public class MedianOfTwoSortedArrays {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        // 如果是奇数
        if ((m + n) % 2 == 1) {
            return getKth(A, 0, A.length - 1, B, 0, B.length - 1, (m + n) / 2  + 1);
        }
        // 如果是偶数
        int left = getKth(A, 0, A.length - 1, B, 0, B.length - 1, (m + n) / 2);
        int right = getKth(A, 0, A.length - 1, B, 0, B.length - 1, (m + n) / 2 + 1);
        return (left + right) / 2.0;
    }

    private int getKth(int[] A, int start1, int end1, int[] B, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        // 让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) {
            return getKth(B, start2, end2, A, start1, end1, k);
        }
        // A数组排除完毕
        if (len1 == 0) {
            return B[start2 + k - 1];
        }
        // 已经找到第k小的数
        if (k == 1) {
            return Math.min(A[start1], B[start2]);
        }
        // 开始二分
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (A[i] > B[j]) {
            return getKth(A, start1, end1, B, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(A, i + 1, end1, B, start2, end2, k - (i - start1 + 1));
        }
    }

}
