package question.Problem100.RemoveDuplicates;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/14 10:40
 *
 * Given a sorted array, 'remove' the duplicates in place such that each element appear only once and return the 'new' length.
 *
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * Example
 * Example 1:
 *
 * Input:  []
 * Output: 0
 * Example 2:
 *
 * Input:  [1,1,2]
 * Output: 2
 * Explanation:  uniqued array: [1,2]
 */
public class RemoveDuplicates {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public static int removeDuplicates(int[] nums) {
        // write your code here
        if (nums.length == 0){return 0;}
        int pos = 0;
        for (int i=0;i<nums.length;i++){
            while (i<nums.length && nums[pos] == nums[i] ){
                i++;
            }
            if (i >= nums.length){break;}
            nums[pos+1] = nums[i];
            pos += 1;
        }
        int newLength = pos+1;

        while (pos+1<nums.length){  // 题目中这一部分不需要
            nums[pos+1] = 0;
            pos += 1;
        }
        return newLength;
    }

    public static void main(String[] args){
        int[] nums = {1};
        System.out.println(removeDuplicates(nums));
    }
}
