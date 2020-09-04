package question.Problem273.TestStrategy;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/11 14:56
 */
public class TestStrategy {
    /**
     * @param p: The time you choose to do part of the problem.
     * @param part: The points you choose to do part of the problem.
     * @param f: The time you choose to do the whole problem.
     * @param full: The points you choose to do the whole problem.
     * @return: Return the maximum number of points you can get.
     */
    public static int exam(int[] p, int[] part, int[] f, int[] full) {
        // write your code here
        //return backTrace(p, part, f, full, 0, 0, 0);
        return dynamicProgram(p, part, f, full);
    }

    public static int dynamicProgram(int[] p, int[] part, int[] f, int[] full) {
        /**
         * 动态规划解法可行
         *
         * dp[i][j]定义为前i道题，在当前时间为j时的最大分数
         */
        int[] dp = new int[121];
        int questions = p.length;

        for (int i = 0; i < p.length; i++) {
            int[] tmp  = new int[121];
            for (int j = 1; j < 121; j++) {
                // 策略一
                // int skip = dp[j];

                // 策略二：
                int partly;
                if (j - p[i] < 0) {
                    partly = 0;
                } else {
                    partly = dp[j - p[i]] + part[i];
                }

                // 策略三：
                int wholely;
                if (j - f[i] < 0) {
                    wholely = 0;
                } else {
                    wholely = dp[j-f[i]] + full[i];
                }

                tmp[j] = Math.max(dp[j],Math.max(partly,wholely));
            }
            dp = tmp;
        }
        return dp[120];
    }

    public static int backTrace(int[] p, int[] part, int[] f, int[] full, int pos, int time, int score) {
        /**
         * 回溯法会超时
         *
         * ！ 而且这里代码的输出 好像不正确
         */
        if (pos == p.length || time == 120) {
            return score;
        }

        int max = score;
        for (int i=pos; i<p.length; i++) {
            int tmp = 0;
            // 对该第i道题做选择

            // 选择一：直接跳过
            tmp = backTrace(p, part, f, full, pos+1, time+0, score+0);
            max = tmp > max? tmp : max;

            // 选择二：
            if (time + p[i] <= 120) {
                tmp = backTrace(p, part, f, full, pos+1, time+p[i], score+part[i]);
                max = tmp > max? tmp : max;
            }

            // 选择三：
            if (time + f[i] <= 120) {
                tmp = backTrace(p, part, f, full, pos+1, time+f[i], score+full[i]);
                max = tmp > max? tmp : max;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /*
        int[] p = {60,60},
                part = {30,30},
                f = {100,120},
                full = {40,60};
                */

        int[] p = {47,54,106,68,9,30,94,42,104,48},
                part = {88,25,99,73,27,68,87,54,71,82},
                f = {97,60,113,74,43,72,94,106,114,100},
                full = {94,54,99,81,65,94,96,84,93,86};

        System.out.println(exam(p,part,f,full));
    }
}
