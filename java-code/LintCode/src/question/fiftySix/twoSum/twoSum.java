package question.fiftySix.twoSum;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/5 15:28
 */

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
 *
 * Example
 * Example1:
 * numbers=[2, 7, 11, 15], target=9
 * return [0, 1]
 * Example2:
 * numbers=[15, 2, 7, 11], target=9
 * return [1, 2]
 */
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */

    //构造一个字典
    public static int[] twoSum(int[] numbers, int target) {
        // write your code here
        Map<Integer, Integer> map = new HashMap();
        for (int i=0; i<numbers.length; i++) {
            //int tmp = target - numbers[i];
            if (map.containsKey(numbers[i])) {
                return new int[]{map.get(numbers[i]), i};
            } else {
                map.put(target - numbers[i], i);
            }
        }

        /*
        HashMap<Integer,Integer> dic = new HashMap<>();
        for (int i=0;i<numbers.length;i++){
            Integer tmp = dic.get(numbers[i]);
            if (tmp!=null){
                return new int[] {tmp,i};
            }
            dic.put(target-numbers[i],i);
        }
         */
        return null;
    }


    public static void main(String[] args){
        int[] numbers = {11,7,2,15};
        int[] res = twoSum(numbers,9);
        for (int i:res){
            System.out.println(i);
        }
    }
}
