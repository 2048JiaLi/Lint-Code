package question.fourteen;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/1 19:27
 */


public class FirstPosOfTarge {
    /**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */

    // 二分查找：在有序数组中查找给定值
    // 注意当有多个返回值时，应该返回下标最小的
    public static int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums==null){return -1;}

        int left=0, right=nums.length-1;
        while (left<=right){
            int mid = (right+left)/2;
            if (nums[mid] == target){
                while (mid>=0 && nums[mid] == target){
                    mid -- ;
                }
                return mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else {
                left = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 3, 4, 5, 10};
        int target = 3;
        System.out.println(binarySearch(nums,target));
    }
}
