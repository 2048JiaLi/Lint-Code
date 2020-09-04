package question.Problem114.UniquePath;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/15 16:58
 */
public class UniquePath {
    /**
     * @param m: positive integer (1 <= m <= 100)
     * @param n: positive integer (1 <= n <= 100)
     * @return: An integer
     */

    // 动态规划，  dp[i][j] = dp[i][j-1] + dp[i-1][j]
    public static int uniquePaths(int m, int n) {
        // write your code here
        if (m == 0 || n == 0) {return 1;}
        int[] minSum = new int[n];
        minSum[0] = 1;

        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                if (i == 0){
                    minSum[j] = 1;
                    continue;
                }

                minSum[j] += minSum[j-1];
            }
        }
        return minSum[n-1];
    }

    public static void main(String[] args){

        System.out.println(uniquePaths(3,1));
    }

}
