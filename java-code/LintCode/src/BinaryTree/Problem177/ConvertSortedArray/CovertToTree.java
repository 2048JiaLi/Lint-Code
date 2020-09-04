package BinaryTree.Problem177.ConvertSortedArray;

import BinaryTree.TreeNode;
import LinkedList.ListNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/22 15:50
 *
 * Given a sorted (increasing order) array, Convert it to create a binary search tree with minimal height.
 *
 * Example
 * Example 1:
 *
 * Input: []
 * Output:  {}
 * Explanation: The binary search tree is null
 * Example 2:
 *
 * Input: [1,2,3,4,5,6,7]
 * Output:  {4,2,6,1,3,5,7}
 * Explanation:
 * A binary search tree with minimal height.
 *
 *          4
 *        /   \
 *       2     6
 *      / \    / \
 *     1   3  5   7
 *
 *
 * Notice
 * There may exist multiple valid solutions, return any of them.
 */
public class CovertToTree {
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public static TreeNode sortedArrayToBST(int[] A) {
        // write your code here

        int len = A.length;
        TreeNode root = null;
        root = recursion(A, 1, len, root);
        A = null;
        return root;
    }
    public static TreeNode recursion(int[] array, int lhs, int rhs, TreeNode root)
    {
        if(lhs <= rhs)
        {
            int mid = (lhs + rhs + 1) >> 1;
            root = new TreeNode(array[mid-1]);
            root.left = recursion(array, lhs, mid - 1, root.left);
            root.right = recursion(array, mid + 1, rhs, root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        sortedArrayToBST(A);
    }
}
