package question.fourtySix.MajorityElement;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/3 15:18
 */
import java.util.ArrayList;
import java.util.List;
public class MajorityElement {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */

    // 摩尔选票法
    public static int majorityNumber(List<Integer> nums) {
        // write your code here
        int count = 0;
        int num = nums.get(0);
        for (int i:nums){
            if (i == num){
                count++;
            } else {
                if (count == 0){
                    num = i;
                    count = 1;
                } else{
                    count--;
                }
            }
        }
        return num;
    }

    public static void main(String[] args){
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(1);nums.add(1);nums.add(2);nums.add(2);nums.add(2);
        for (int i:nums){
            System.out.println(i);
        }

        System.out.println(majorityNumber(nums));
    }
}
