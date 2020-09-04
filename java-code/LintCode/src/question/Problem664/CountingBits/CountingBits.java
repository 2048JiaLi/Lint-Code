package question.Problem664.CountingBits;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/9 18:46
 *
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 *
 * Example
 * Example1
 *
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Explanation:
 * The binary representation of 0~5 is:
 * 000
 * 001
 * 010
 * 011
 * 100
 * 101
 * the count of "1" in each number is: 0,1,1,2,1,2
 * Example2
 *
 * Input: 3
 * Output: [0,1,1,2]
 */
public class CountingBits {
    /**
     * @param num: a non negative integer number
     * @return: an array represent the number of 1's in their binary
     */

    // 利用 n&(n-1)性质， 题142
    public static int[] countBits(int num) {
        // write your code here
        int[] res = new int[num+1];
        res[0] = 0;
        for (int i=1;i<res.length;i++){  // 在数组res中存放结果，若 i&(i-1)==0成立，则res[i]=1;
            int tmp = i&(i-1);           // 否则 res[i] = 1 + res[i&(i-1)]
            if (tmp == 0){
                res[i] = 1;
            } else {
                res[i] = 1+res[tmp];
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[] res = countBits(7);
        for (int i:res){
            System.out.print(i+"\t");
        }
    }
}
