package question.thirtyNine.RecoverRotatedSortedArray;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/3 10:15
 */
import java.util.LinkedList;
import java.util.List;
//相关题目： 题8 (本题是题8的逆向)
/**
 * Given a rotated sorted array, recover it to sorted array in-place.（Ascending）
 *
 * Example
 * Example1:
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * Example2:
 * [6,8,9,1,2] -> [1,2,6,8,9]
 */
public class RecoverRotated {
    /**
     * @param nums: An integer array
     * @return: nothing
     */
    public static void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        if (nums == null){return;}

        int minPos = 0;
        //找到第一个比后面小的数

        for (int i=1;i<nums.size();i++){
            if (nums.get(i) < nums.get(minPos)){
                minPos = i;
                break;
            }
        }


        reverse(nums,0,minPos-1);
        reverse(nums,minPos,nums.size()-1);
        reverse(nums,0,nums.size()-1);
    }

    // 翻转
    private static void reverse(List<Integer> nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums.get(i);
            nums.set(i,nums.get(j));
            nums.set(j,temp);
        }
    }

    public static void traverse(List<Integer> nums){
        for (int i:nums){
            System.out.print(i);
        }
    }

    public static void main(String[] args){
        List<Integer> nums = new LinkedList<>();
        nums.add(6);
        nums.add(8);
        nums.add(9);
        nums.add(1);
        nums.add(2);


        recoverRotatedSortedArray(nums);
        traverse(nums);

    }
}
