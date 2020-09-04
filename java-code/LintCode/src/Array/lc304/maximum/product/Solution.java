package Array.lc304.maximum.product;

import java.util.Arrays;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/8/13 9:59
 */
public class Solution {
    /**
     * @param nums: Unordered array
     * @return: return the largest product
     */
    public static long MaximumProduct(int[] nums) {
        // write your code here
        /*解题思想：
        * 遍历数组，找到五个数，分别为top3大，与top2小
        *
        * 最终结果为 max(top3数的乘积，最大数*top2的积)
        * */

        Arrays.sort(nums);

        return Math.max(nums[0]*nums[1]*nums[nums.length-1],nums[nums.length-3]*nums[nums.length-2]*nums[nums.length-1]);
    }

    public static void main(String[] args) {
        MaximumProduct(new int[]{3,4,1,2});
    }
}
