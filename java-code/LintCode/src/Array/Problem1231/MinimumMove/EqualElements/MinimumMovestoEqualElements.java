package Array.Problem1231.MinimumMove.EqualElements;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/24 15:46
 *
 * 给定一个大小为n的非空整数数组，找出使得数组中所有元素相同的最少步数，
 * 其中一步被定义为将数组中n - 1个元素加一。
 *
 * Example
 * 输入：
 * [1,2,3]
 *
 * 输出：
 * 3
 *
 * 说明：
 * 只需要三步即可（每一步将其中两个元素加一）：
 *
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinimumMovestoEqualElements {
    /**
     * @param nums: an array
     * @return: the minimum number of moves required to make all array elements equal
     */
    public int minMoves(int[] nums) {
        // Write your code here
        /**
         * **反向思维方式**
         * 对于长度n的数组中，将n-1个元素的值加一，其实可以等价于将某个元素减一，所以需要的步数就等于
         * sum(nums) - minNum*len(nums)
         */
        int sum = 0;
        int minNum = Integer.MAX_VALUE;
        for (int num : nums) {
            sum += num;
            minNum = minNum>num? num:minNum;
        }
        return sum - minNum*nums.length;
    }
}
