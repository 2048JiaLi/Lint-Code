package Array.Problem31.PartitionArray;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/8 19:19
 *
 * Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:
 *
 * All elements < k are moved to the left
 * All elements >= k are moved to the right
 * Return the partitioning index, i.e the first index i nums[i] >= k.
 *
 * Example
 * Example 1:
 *
 * Input:
 * [],9
 * Output:
 * 0
 *
 * Example 2:
 *
 * Input:
 * [3,2,2,1],2
 * Output:1
 * Explanation:
 * the real array is[1,2,2,3].So return 1
 * Challenge
 * Can you partition the array in-place and in O(n)?
 *
 * Notice
 * You should do really partition in array nums instead of just counting the numbers of integers smaller than k.
 *
 * If all elements in nums are smaller than k, then return nums.length
 */
public class PartitionArray {
    /**
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public static int partitionArray(int[] nums, int k) {
        /**
         * 找数组中第一个大于k的元素做一次快速排序的分组
         */
        // write your code here
        int left = 0, right = nums.length-1;
        while (left<nums.length) {
            if (nums[left] < k) {
                left++;
            } else {
                break;
            }
        }
        if (left == nums.length) {
            return left;
        }

        int flag = nums[left];
        while (left < right) {

            while (left < right && nums[right]>=k) {
                right--;
            }
            if (left >= right) {break;}
            nums[left] = nums[right];

            while (left < right && nums[left] < k) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[right] = flag;
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {2,2,2,1};
        System.out.println(partitionArray(nums,4));
    }
}
