package Array.Problem5.KthElement;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/1 14:27
 *
 * Find K-th largest element in an array.
 *
 * Example
 * Example 1:
 *
 * Input:
 * n = 1, nums = [1,3,4,2]
 * Output:
 * 4
 * Example 2:
 *
 * Input:
 * n = 3, nums = [9,3,2,4,8]
 * Output:
 * 4
 * Challenge
 * O(n) time, O(1) extra memory.
 *
 * Notice
 * You can swap elements in the array
 */
public class KthLargestElement {
    /**
     * @param n: An integer
     * @param nums: An array
     * @return: the Kth largest element
     */
    public static int kthLargestElement(int n, int[] nums) {
        // write your code here

        /**
         * 快排的分治思想：注意是降序, 可以默认n< nums.length
         *
         * 若当前位置为k，即可返回
         */
        return kth(nums, 0, nums.length-1, n);
    }

    public static int kth(int[] nums, int left, int right, int k) {
        //if (left > right) {return -1;}
        if (left == right) {return nums[right];}

        int pos = partition(nums,left,right);
        int tmp = pos - left + 1;
        if (tmp == k) {
            return nums[pos];
        } else if (tmp > k) {
            return kth(nums,left,pos-1,k);
        } else {
            return kth(nums,pos+1,right,k-tmp);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        //int pos = start;
        int curNum = nums[start];

        while (start < end){
            // 从右开始向左找第一个比curNum大的
            while (nums[end] < curNum && start < end ){
                end--;
            }
            nums[start] = nums[end];
            if (start == end) {
                break;
            }
            // 从左向右找第一比curNum小的，放在右边
            while (nums[start] >= curNum && start < end) {
                start++;
            }
            nums[end] = nums[start];
        }
        nums[end] = curNum;
        return end;
    }

    public static void main(String[] args) {
        int[] nums = {9,3,2,4,8};
        System.out.println(kthLargestElement(5,nums));
    }
}
