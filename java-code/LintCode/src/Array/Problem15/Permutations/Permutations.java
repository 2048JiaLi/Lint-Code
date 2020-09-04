package Array.Problem15.Permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/4 15:57
 *
 * Given a list of numbers, return all possible permutations.
 *
 * Example
 * Example 1:
 *
 * Input: [1]
 * Output:
 * [
 *   [1]
 * ]
 * Example 2:
 *
 * Input: [1,2,3]
 * Output:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * Challenge
 * Do it without recursion.
 *
 * Notice
 * You can assume that there is no duplicate numbers in the list.
 */
public class Permutations {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public static List<List<Integer>> permute(int[] nums) {
        // write your code here

        /**
         * 回溯法，求所有解？？
         */
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrace(lists,list,nums,0);

        return backTrace(lists,list,nums,0);
    }

    public static List<List<Integer>> backTrace(List<List<Integer>> lists, List<Integer> list, int[] nums, int pos) {
        if (pos == nums.length) {
            lists.add(list);
            return lists;
        }

        // 做选择
        for (int i=pos; i<nums.length; i++) {
            list.add(nums[i]);
            lists = backTrace(lists, list, nums, pos+1);

            // 撤销选择
            list.remove(list.size()-1);
        }
        return lists;
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}).toString());
    }
}
