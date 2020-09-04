package question.fifty.ProductOfArray;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/4 14:43
 */
/**
 * Given an integers array A.
 *
 * Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B WITHOUT divide operation.Output B
 *
 * Example
 * Example 1
 *
 * Input: A = [1, 2, 3]
 * Output: [6, 3, 2]
 * Explanation：B[0] = A[1] * A[2] = 6; B[1] = A[0] * A[2] = 3; B[2] = A[0] * A[1] = 2
 * Example 2
 *
 * Input: A = [2, 4, 6]
 * Output: [24, 12, 8]
 */

import java.util.ArrayList;
import java.util.List;
public class ProductOfArray {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public static List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> list = new ArrayList<>();
        for (int i=0;i<nums.size();i++ ){
            if (i==0){
                list.add(1L);
            }else {
                list.add(list.get(i-1)*nums.get(i-1));
            }
        }

        long tmp = 1L;
        for (int j=nums.size()-1;j>=0;j--){
            if (j==nums.size()-1){
                tmp = 1L;
            }else {
                tmp = nums.get(j+1)*tmp;
            }
            list.set(j,tmp*list.get(j));
        }
        return list;
    }

    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        nums.add(2);nums.add(4);nums.add(6);

        List<Long> list = productExcludeItself(nums);
        for (long value : list){
            System.out.print(value+" ");
        }
    }
}
