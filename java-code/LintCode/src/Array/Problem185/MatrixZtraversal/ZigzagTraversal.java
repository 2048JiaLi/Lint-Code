package Array.Problem185.MatrixZtraversal;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/23 15:28
 *
 * Given a matrix of m x n elements (m rows, n columns),
 * return all elements of the matrix in ZigZag-order.
 *
 * Example
 * Example 1:
 * 	Input: [[1]]
 * 	Output:  [1]
 *
 * Example 2:
 * 	Input:
 * 	[
 *     [1, 2,  3,  4],
 *     [5, 6,  7,  8],
 *     [9,10, 11, 12]
 *   ]
 *
 * 	Output:  [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
 */
public class ZigzagTraversal {
    /**
     * @param matrix: An array of integers
     * @return: An array of integers
     */
    public static int[] printZMatrix(int[][] matrix) {
        // write your code here
        int m = matrix.length, n = matrix[0].length;
        if (m == 1){
            return matrix[0];
        }
        if (n == 1) {
            int[] res = new int[m];
            for (int i = 0; i<m; i++) {
                res[i] = matrix[i][0];
            }
            return res;
        }

        int[] res = new int[m*n];

        int i = 0, j = 0;
        int pos = 0;
        State next = State.right;
        while (i < m && j < n) {
            res[pos++] = matrix[i][j];

            // 决定下一个位置
            if (next == State.right) {
                j++;

                next = i==m-1? State.right_up : State.left_down;
                continue;
            }

            if (next == State.down) {
                i++;

                next = j==n-1? State.left_down : State.right_up;
                continue;
            }

            if (next == State.right_up) {
                i--;
                j++;

                if (j == n-1){
                    next = State.down;
                } else if (i == 0){
                    next = State.right;
                }
                continue;
            }

            if (next == State.left_down) {
                i++;
                j--;

                if (i == m-1) {
                    next = State.right;
                } else if (j == 0){
                    next = State.down;
                }
                continue;
            }

        }
        return res;
    }



    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {1, 2, 4},
                {1, 2, 5},
                {1, 2, 7},
                {1, 3, 4}
        };

        int[][] x = {
                {1},
                {2},
                {3}
        };

        int[] res = printZMatrix(x);


        for (int num : res
             ) {
            System.out.print(num+"\t");
        }

    }
}

enum State {
    right, left_down, down, right_up

}