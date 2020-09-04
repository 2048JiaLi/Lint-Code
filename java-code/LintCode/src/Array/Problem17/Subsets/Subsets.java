package Array.Problem17.Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/10 14:56
 */
public class Subsets {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public static List<List<Integer>> subsets(int[] nums) {
        // write your code here
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();

        int size = 1 << nums.length;
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            List<Integer> tmp = new ArrayList<>();
            int j = i, pos = 0;
            while (j != 0) {
                if (j % 2 != 0) {
                    tmp.add(nums[pos]);
                }
                pos++;
                j = j >> 1;
            }
            /*
            for (int j = 0; j < nums.length; j++) {
                if ((i>>j) % 2 != 0) {
                    tmp.add(nums[j]);
                }
            }
            */
            resList.add(tmp);
        }
        System.out.println(System.currentTimeMillis()-start);
        return resList;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3,4,5,6,7}).toString());
    }
}
