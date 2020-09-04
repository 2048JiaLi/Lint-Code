package Array.LC883.max.consecutive.ones2;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/23 17:49
 *
 * Given a binary array, find the maximum number of consecutive 1s in this array
 * if you can flip at most one 0.
 *
 * Example
 * Example 1:
 * 	Input:  nums = [1,0,1,1,0]
 * 	Output:  4
 *
 * 	Explanation:
 * 	Flip the first zero will get the the maximum number of consecutive 1s.
 * 	After flipping, the maximum number of consecutive 1s is 4.
 *
 * Example 2:
 * 	Input: nums = [1,0,1,0,1]
 * 	Output:  3
 *
 * 	Explanation:
 * 	Flip each zero will get the the maximum number of consecutive 1s.
 * 	After flipping, the maximum number of consecutive 1s is 3.
 *
 * Notice
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000.
 */
public class MaxConsecutiveOnes {
    /**
     * @param nums: a list of integer
     * @return: return a integer, denote  the maximum number of consecutive 1s
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        /**
         * 滑动窗口
         */
        // write your code here
        int left, right;
        left = right = 0;

        int res = 0;
        int flag = -1;    // 标记窗口中0的位置，-1表示没有

        while (right < nums.length) {
            // right右移
            if (nums[right] == 0) {
                res = res>1? res:1;
                if (flag == -1) { // 窗口中没有0
                    // 直接右移就可以
                } else {
                    res = (right-left)>res? right-left : res;
                    left = flag+1;
                }
                flag = right;
            }
            right++;
        }
        return (right-left)>res? right-left : res;
    }

    public static void main(String[] args) {
        System.out.println(findMaxConsecutiveOnes(new int[]{0,0,1,0,1}));
    }
}
