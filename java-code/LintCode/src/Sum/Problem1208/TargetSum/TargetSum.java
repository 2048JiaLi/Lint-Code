package Sum.Problem1208.TargetSum;

import java.io.InputStream;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/30 15:47
 */
public class TargetSum {
    //private static int result = 0;
    /**
     * @param nums: the given array
     * @param s: the given target
     * @return: the number of ways to assign symbols to make sum of integers equal to target S
     */
    public static int findTargetSumWays(int[] nums, int s) {
        // Write your code here
        if (nums == null) {return 0;}
        return backTrace(nums,0,0,s);
    }

    /**
     * 回溯法找全部解的开销是很大的
     * @param nums
     * @param result 返回的结果
     * @param pos
     * @param rest 目标剩余
     * @return
     */
    public static int backTrace(int[] nums, int result, int pos, int rest) {
        if (pos == nums.length) {
            if (rest == 0) {
                result++;
            }
            return result;
        }

        // 可以再对重叠问题进行优化，备忘录方法记录
        result = backTrace(nums,result,pos+1,rest-nums[pos]);
        result = backTrace(nums,result,pos+1,rest+nums[pos]);

        /*
        // 选择1：做加法 --> 目标值做减法（rest=0时为满足条件）
        rest -= nums[pos];
        result = backTrace(nums,result,pos+1,rest);
        // 撤销选择
        rest += nums[pos];

        // 选择2：做减法
        rest += nums[pos];
        result = backTrace(nums,result,pos+1,rest);
        // rest -= nums[pos]; // 因为不是写在for循环的撤销，所以这一步是多余的
        */

        return result;
    }

    /**
     * 动态规划
     */
    public static int subset(int[] nums, int capacity) {
        /*
        int[][] dp = new int[nums.length+1][capacity+1];

        // base case ?  容量为0时，所有物品都不放, 即此时，dp数组值为1，代表唯一的一种选择
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j >= nums[i-1]) {
                    // 两种选择的结果之和
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    // 背包的空间不足，只能选择不装物品 i
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[nums.length][capacity];
        */

        // 优化
        int n = nums.length;
        int[] dp = new int[capacity + 1];
        // base case
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            // j 要从后往前遍历
            for (int j = capacity; j >= 0; j--) {
                // 状态转移方程
                if (j >= nums[i-1]) {
                    dp[j] = dp[j] + dp[j-nums[i-1]];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[capacity];
    }

    public static int findTargetSumWays2(int[] nums, int s) {
        // Write your code here
        int sum = 0;
        for (int n : nums) sum += n;

        if (sum < s || ((sum+s)&1) != 0) {
            return 0;
        }
        return subset(nums, (sum + s) / 2);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(findTargetSumWays2(nums,3));

    }
}
