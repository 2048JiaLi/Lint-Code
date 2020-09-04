package Array.lc1645.least.subsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/8/6 15:18
 *
 * Description
 * 给一个由 n 个整数组成的数组。
 * 将它拆分为多个严格递减的子序列。输出通过拆分可以获得的最小子序列数。
 */
public class LeastSubsequences {
    /**
     * @param arrayIn: The original array.
     * @return: Count the minimum number of subarrays.
     */
    public int LeastSub(List<Integer> arrayIn) {
        // Write your code here.
        /**
         * 二分查找的应用
         *
         * 每走到一个数arrayi，找到之前已经分出来的subsequences的所有末尾中、
         * 比arrayi大的其中最小的那一个，并把arrayi append 到其之后，
         * 如果找不到，那么新开一个 subsequence，arrayi 即为新的 subsequence
         *
         * 这里只subsequences只保留最小的元素
         */
        List<Integer> res = new ArrayList<>();
        for (Integer integer : arrayIn) {
            // 对res元素二分查找
//            int index = binaryserach(); // 不想写
//
//            if (index == res.size()) {
//                // 没有找到大于该值的最小位置
//                res.add(integer);
//            } else {
//                res.set(index,integer);
//            }
        }
        return res.size();
    }
}
