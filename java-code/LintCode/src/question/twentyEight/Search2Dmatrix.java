package question.twentyEight;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/2 13:46
 */

/**写出一个高效的算法来搜索 m × n矩阵中的值。
 *
 *这个矩阵具有以下特性：
 *每行中的整数从左到右是排序的。
 *每行的第一个数大于上一行的最后一个整数。
 */

import question.fourteen.FirstPosOfTarge;

public class Search2Dmatrix {
    /**
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    // 有序的二维矩阵  ---  两次二分查找
    public static boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        int low = 0, high = matrix.length-1;
        int pos = 0;
        while (low <= high){
            if (matrix[low][0] <= target && matrix[high][0] >= target){
                pos = (low+high)/2;
                if (matrix[pos][0] > target){
                    high = pos-1;
                } else if (matrix[pos][0] < target){
                    low = pos+1;
                } else {
                    return true;
                }
            } else if (matrix[low][0] > target){
                pos = low-1;
                if (pos < 0){return false;}
                break;
            } else if (matrix[high][0] < target){
                pos = high;
                break;
            }
        }

        return FirstPosOfTarge.binarySearch(matrix[pos],target)!=-1? true:false;
    }


    public static void main(String[] args){
        int[][] nums = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };

        int[] target = {1,3,5,7,10,11,16,20,23,30,34,50,51,21,8,0};
        for (int num:target){
            System.out.print(num);
            System.out.println(searchMatrix(nums,num));
        }

    }
}
