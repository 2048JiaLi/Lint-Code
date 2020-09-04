package Integer.Problem188.InsertFive;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/26 16:05
 *
 * Given a number, insert a 5 at any position of the number to
 * make the number after insertion the largest
 *
 * Example
 * Example 1:
 *
 * Input:  a = 234
 * Output: 5234
 * Notice
 * |a| \leq 10^6
 * ​​
 */
public class InsertFive {
    /**
     * @param a: A number
     * @return: Returns the maximum number after insertion
     */
    public static int InsertFive(int a) {
        // write your code here

        /**
         * 注意正数与负数的区别
         */
        int offset = 10;
        int firstNum = 0, restNum = 0;

        while (a / offset != 0) {
            firstNum = a / offset;
            restNum = a % offset;

            offset *= 10;
        }

        if (a < 0) {
            if (firstNum <= -5) {
                return -5*offset + a;
            } else {
                int tmp = 0;
                offset = offset / 10;
                while (firstNum > -5 && a / offset !=0) {
                    tmp = a / offset;
                    restNum = a % offset;

                    offset = offset / 10;
                    firstNum = restNum / offset;
                }
                return tmp * offset * 100 + (-5 * offset * 10) + restNum;
            }

        } else {

            if (firstNum > 5) {
                return firstNum * (offset) + 5*(offset/10) + restNum;
            } else {
                return 5*offset + a;
            }
        }
    }

    public static void main(String[] args) {
        int a = -123456;
        System.out.println(InsertFive(a));
    }
}

