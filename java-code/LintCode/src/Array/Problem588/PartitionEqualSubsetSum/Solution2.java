package Array.Problem588.PartitionEqualSubsetSum;

import java.util.Arrays;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/10 16:44
 */
public class Solution2 {
    /**
     * @param nums: a non-empty array only positive integers
     * @return: true if can partition or false
     *
     * dp数组，背包问题
     */
    public static boolean canPartition(int[] nums) {
        // write your code here

        if (nums.length == 0) {return true;}
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum&1) == 1) {
            // 为奇数，不然不可能存在，子数组为总和的1/2
            return false;
        }
        sum = sum >> 1;
        // dp[i]表示是否有这样一种可行方案使得元素和为i
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int x : nums) {
            for(int i = sum; i >= x; i--) {
                dp[i] = dp[i] || dp[i - x];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,4,5,6,1,2,4,1,3,4,1,2,4,5,1,91,4,5,6,1,2,4,1,3,4,1,2,4,5,1}));
    }
}
