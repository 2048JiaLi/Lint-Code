package question.Problem138.SubarraySum;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/16 16:05
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class SubarraySum {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */

    // 暴力解法 -- 太慢了
    public static List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new LinkedList<Integer>();

        for (int i=0; i<nums.length; i++) {
            int tmp = 0;

            for (int j=i; j<nums.length; j++) {
                tmp += nums[j];

                if (tmp == 0) {
                    res.add(i);
                    res.add(j);
                    break;
                }
            }

            if (!res.isEmpty()) {
                break;
            }
        }
        return res;
    }

    public static List<Integer> subSum(int[] nums) {
        List<Integer> res = new LinkedList<Integer>();

        // 记录当前位置的累加和
        HashMap<Integer,Integer> hash = new HashMap<>();

        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];

            // 若sum = 0，表示从0至该位置的子数组和为0
            if (sum == 0) {
                res.add(0);
                res.add(i);
                return res;
            } else {
                // 若sum包含在字典中，表示0至当前位置的和 = 0至hash(sum)位置的和， 即 hash(sum)+1位置至 当前位置和为0
                if (hash.containsKey(sum)) {
                    res.add(hash.get(sum)+1);
                    res.add(i);
                    return res;
                } else {
                    hash.put(sum,i);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1};
        System.out.println(subSum(nums));
    }
}
