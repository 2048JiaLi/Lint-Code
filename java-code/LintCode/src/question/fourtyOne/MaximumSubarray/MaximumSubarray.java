package question.fourtyOne.MaximumSubarray;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/3 13:33
 */

/**
 * Given an array of integers, find a contiguous subarray which has the largest sum.
 *
 * Example1:
 *
 * Input: [−2,2,−3,4,−1,2,1,−5,3]
 * Output: 6
 * Explanation: the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * Example2:
 *
 * Input: [1,2,3,4]
 * Output: 10
 * Explanation: the contiguous subarray [1,2,3,4] has the largest sum = 10.
 */

public class MaximumSubarray {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */

    // 动态规划解法
    // dp(i) 定义为以nums[i]为结尾的最大连续子序列的数值
    //
    // 注意dp[0]=nums[0], 而 dp[i] = max(dp[i-1]+nums[i],nums[i])，
    // 其中dp[i-1]+nums[i]表示以num[i-1]为结尾的连续序列 + num[i]
    // 因dp[i] 只与dp[i-1]有关，所以可以省略数组


    public static int maxSubArray(int[] nums) {
        // write your code here
        if (nums == null){return 0;}

        int dp= nums[0], maxNum = nums[0];
        for (int i=1;i<nums.length;i++){
            dp = compare(dp+nums[i],nums[i]);
            maxNum = compare(dp,maxNum);
        }
        return maxNum;
    }

    public static int compare(int a, int b){
        if (a > b){return a;}
        else {return b;}
    }

    public static void main(String[] args){
        int[] nums = {-2,2,-3,4, -1,2,1,-5,3};
        System.out.print(maxSubArray(nums));
    }

}
