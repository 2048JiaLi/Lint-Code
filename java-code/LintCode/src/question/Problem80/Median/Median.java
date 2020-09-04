package question.Problem80.Median;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/10 19:36
 *
 * Given a unsorted array with integers, find the median of it.
 *
 * A median is the middle number of the array after it is sorted.
 *
 * If there are even numbers in the array, return the N/2-th number after sorted.
 *
 * Example
 * Example 1:
 *
 * Input：[4, 5, 1, 2, 3]
 * Output：3
 * Explanation:
 * After sorting，[1,2,3,4,5]，the middle number is 3
 * Example 2:
 *
 * Input：[7, 9, 4, 5]
 * Output：5
 * Explanation:
 * After sorting，[4,5,7,9]，the second(4/2) number is 5
 * Challenge
 * O(n) time.
 */
public class Median {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public static int median(int[] nums) {
        // write your code here
        int k = nums.length / 2;
        if (nums.length % 2==0){
            k -= 1;
        }

        // 找第k小的数
        return Klargest(nums,0,nums.length-1,k+1)[k];
    }

    // 这里应该是第k小的数
    private static int[] Klargest(int[] nums, int startpos, int endpos, int k){
        if (startpos >= endpos){return nums;}

        int pos = partitionAsce(nums,startpos,endpos);
        int tmp = pos-startpos+1;
        if (tmp == k) {return nums;}
        else if (pos-startpos+1 > k){
            return Klargest(nums,startpos,pos-1,k);
        } else {
            return Klargest(nums,pos+1,endpos,k-(pos-startpos+1));
        }
    }

    // 快速排序分治思想
    private static int partitionAsce(int[] nums, int startpos, int endpos){
        int tmp = nums[startpos];
        while (startpos < endpos){
            while (nums[endpos] >= tmp && startpos<endpos){
                endpos--;
            }
            nums[startpos] = nums[endpos];

            while (nums[startpos] < tmp && startpos<endpos){
                startpos++;
            }
            nums[endpos] = nums[startpos];
        }
        nums[startpos] = tmp;
        return startpos;
    }

    public static void main(String[] args){
        int[] nums = {1,0,1};
        System.out.print(median(nums));
    }
}
