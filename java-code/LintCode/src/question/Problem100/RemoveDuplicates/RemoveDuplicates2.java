package question.Problem100.RemoveDuplicates;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/15 15:21
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Example
 * Example 1:
 * 	Input:  [[1,3,1],[1,5,1],[4,2,1]]
 * 	Output: 7
 *
 * 	Explanation:
 * 	Path is: 1 -> 3 -> 1 -> 1 -> 1
 *
 *
 * Example 2:
 * 	Input:  [[1,3,2]]
 * 	Output: 6
 *
 * 	Explanation:
 * 	Path is: 1 -> 3 -> 2
 *
 * Notice
 * You can only go right or down in the path..
 */
public class RemoveDuplicates2 {
    /**
     * @param grid: a list of lists of integers
     * @return: An integer, minimizes the sum of all numbers along its path
     */

    // 最短路径，动态规划
    public static int minPathSum(int[][] grid) {
        // write your code here
        if (grid.length == 0) {return 0;}
        int m = grid.length, n = grid[0].length;
        int[] minSum = grid[0];

        for (int i=0; i<m; i++){
            int j = 0;
            if (i == 0){
                while (j < n-1){
                    minSum[j+1] += minSum[j];
                    j += 1;
                }
                continue;
            }

            for (j=0; j<minSum.length; j++){
                if (j==0){
                    minSum[j] += grid[i][j];
                } else {
                    int tmp = Math.min(minSum[j-1],minSum[j]);
                    minSum[j] = grid[i][j] + tmp;
                }
            }
        }
        return minSum[n-1];
    }

    public static void main(String[] args){
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        System.out.println(minPathSum(grid));
    }
}
