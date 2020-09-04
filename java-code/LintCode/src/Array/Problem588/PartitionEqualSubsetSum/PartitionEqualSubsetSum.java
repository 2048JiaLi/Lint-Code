package Array.Problem588.PartitionEqualSubsetSum;

import java.util.Arrays;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/10 16:02
 *
 * Given a non-empty array containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 * Example
 * Example 1:
 *
 * Input: nums = [1, 5, 11, 5],
 * Output: true
 * Explanation:
 * two subsets: [1, 5, 5], [11]
 * Example 2:
 *
 * Input: nums = [1, 2, 3, 9],
 * Output: false
 * Notice
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 */
public class PartitionEqualSubsetSum {

    /**
     * @param nums: a non-empty array only positive integers
     * @return: true if can partition or false
     *
     * 问题等价于，是否存在一个子数组的和为 sum(nums) / 2
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
        return backTrace(nums,0,0,sum/2);
    }

    public static boolean backTrace(int[] nums, int pos, int tmpSum, int sum) {
        /**
         * 回溯法Time Limit Exceeded，不适合，但是结果是对的
         */

        // 回溯法，找到是否存在可行解
        if (tmpSum == sum) {
            return true;
        }

        // 做选择
        for (int i = pos; i < nums.length; i++) {
            if (tmpSum > sum) {
                break;
            }
            tmpSum += nums[i];
            if (backTrace(nums, i+1, tmpSum, sum)){
                return true;
            }
            tmpSum -= nums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,4,5,6,1,2,4,1,3,4,1,2,4,5,1,91,4,5,6,1,2,4,1,3,4,1,2,4,5,1}));
    }
}
