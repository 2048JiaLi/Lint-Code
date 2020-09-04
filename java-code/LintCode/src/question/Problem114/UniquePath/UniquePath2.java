package question.Problem114.UniquePath;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/15 18:14
 *
 * Follow up for "Unique Paths":
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * Example
 * Example 1:
 * 	Input: [[0]]
 * 	Output: 1
 *
 *
 * Example 2:
 * 	Input:  [[0,0,0],[0,1,0],[0,0,0]]
 * 	Output: 2
 *
 * 	Explanation:
 * 	Only 2 different path.
 *
 *
 * Notice
 * m and n will be at most 100.
 */

public class UniquePath2 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if (obstacleGrid[0][0] != 0) {return 0;}
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] minSum = new int[n];

        for (int i=0; i<n ;i++){
            if (obstacleGrid[0][i] == 0){
                minSum[i] = 1;
            } else {
                break;
            }
        }

        for (int i=1; i<m; i++){
            for (int j=0; j<n; j++){
                if (j == 0){
                    if (obstacleGrid[i][j] != 0){
                        minSum[j] = 0;
                    }
                    continue;
                }

                if (obstacleGrid[i][j] == 0) {
                    minSum[j] += minSum[j - 1];
                } else {
                    minSum[j] = 0;
                }
            }
        }
        return minSum[n-1];
    }

    public static void main(String[] args){
        int[][] obstacleGrid = {
                {0}
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}
