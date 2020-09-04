package BinaryTree.Problem175.InvertTree;

import BinaryTree.TreeNode;
import LinkedList.ListNode;

import java.util.Stack;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/6/22 14:18
 *
 * 翻转一棵二叉树。左右子树交换。
 * Invert a binary tree.Left and right subtrees exchange.
 *
 * Example
 * Example 1:
 *
 * Input: {1,3,#}
 * Output: {1,#,3}
 * Explanation:
 * 	  1    1
 * 	 /  =>  \
 * 	3        3
 * Example 2:
 *
 * Input: {1,2,3,#,#,4}
 * Output: {1,3,2,#,4}
 * Explanation:
 *
 *       1         1
 *      / \       / \
 *     2   3  => 3   2
 *        /       \
 *       4         4
 * Challenge
 * Do it in recursion is acceptable, can you do it without recursion?
 */
public class InvertTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public static void invertBinaryTree(TreeNode root) {
        // write your code here
        /**
         * 递归解法
         */

        if (root == null) {
            return;
        }

        if (root.left != null || root.right != null) {
            invertBinaryTree(root.left);
            invertBinaryTree(root.right);

            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
        }

    }

    public static void LevelinvertBinaryTree(TreeNode root) {
        /**
         * 非递归
         */
        Stack<TreeNode> nodelist = new Stack<>();
        nodelist.push(root);

        while (!nodelist.isEmpty()) {
            TreeNode curnode = nodelist.pop();

            if (curnode.left != null) {
                nodelist.push(curnode.left);
            }

            if (curnode.right != null) {
                nodelist.push(curnode.right);
            }

            TreeNode tmp = curnode.left;
            curnode.left = curnode.right;
            curnode.right = tmp;
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);

        //invertBinaryTree(tree);
        LevelinvertBinaryTree(tree);


    }
}
