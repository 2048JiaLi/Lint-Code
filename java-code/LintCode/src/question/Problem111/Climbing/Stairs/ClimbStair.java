package question.Problem111.Climbing.Stairs;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/15 16:36
 *
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example
 * Example 1:
 * 	Input:  n = 3
 * 	Output: 3
 *
 * 	Explanation:
 * 	1) 1, 1, 1
 * 	2) 1, 2
 * 	3) 2, 1
 * 	total 3.
 *
 *
 * Example 2:
 * 	Input:  n = 1
 * 	Output: 1
 *
 * 	Explanation:
 * 	only 1 way.
 */


public class ClimbStair {
    /**
     * @param n: An integer
     * @return: An integer
     */

    // 动态规划
    public static int climbStairs(int n) {
        // write your code here
        if (n == 1){return 1;}
        if (n == 2){return 2;}

        // 递归方法超时
        return climbStairs(n-1)+climbStairs(n-2); // n-1时爬1个，n-2时爬2个（n-2时爬两个1的方法就是n-1爬1个）
    }

    public static int climb(int n) {
        // write your code here
        if (n >= 0 && n <= 2){return n;}

        int v1 = 1, v2 = 2;
        for (int i=3; i<=n; i++){
            int tmp = v1 + v2;
            v1 = v2;
            v2 = tmp;
        }

        return v2;
    }

    public static void main(String[] args){
        System.out.println(climb(44));
    }
}
