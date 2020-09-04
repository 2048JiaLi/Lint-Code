package BinaryTree.Problem155.MinimumDepth;

import BinaryTree.TreeNode;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/13 13:40
 */
public class MinimumDepth {
    /**
     * @param root: The root of binary tree
     * @return: An integer
     */
    public static int minDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return minDepth(root.right) + 1;
        }

        if (root.right == null) {
            return minDepth(root.left) + 1;
        }

        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        return left<right?left:right;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(22);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(12);

        System.out.println(minDepth(tree));
    }
}
