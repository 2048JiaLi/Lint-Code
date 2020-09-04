package BinaryTree.lc376.path.sum;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/30 14:06
 *
 * Given a binary tree, find all paths that sum of the nodes in the path equals to a given number target.
 *
 * A valid path is from root node to any of the leaf nodes.
 *
 * Example
 * Example 1:
 *
 * Input:
 * {1,2,4,2,3}
 * 5
 * Output: [[1, 2, 2],[1, 4]]
 * Explanation:
 * The tree is look like this:
 * 	     1
 * 	    / \
 * 	   2   4
 * 	  / \
 * 	 2   3
 * For sum = 5 , it is obviously 1 + 2 + 2 = 1 + 4 = 5
 * Example 2:
 *
 * Input:
 * {1,2,4,2,3}
 * 3
 * Output: []
 * Explanation:
 * The tree is look like this:
 * 	     1
 * 	    / \
 * 	   2   4
 * 	  / \
 * 	 2   3
 * Notice we need to find all paths from root node to leaf nodes.
 * 1 + 2 + 2 = 5, 1 + 2 + 3 = 6, 1 + 4 = 5
 * There is no one satisfying it.
 */
public class BinaryTreePathSum {
    /**
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public static List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        helper(root,res,new ArrayList<>(),target);
        return res;
    }

    /**
     *
     * @param node
     * @param res
     * @param path：需要是根节点至叶子的路径
     * @param remaining：与目标值的剩余
     */
    private static void helper(TreeNode node, List<List<Integer>> res, List<Integer> path, int remaining) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        remaining -= node.val;
        if (node.left == null && node.right == null) {
            if (remaining == 0) {
                // 这里不能直接将tmp添加，因为在该引用的改变也会对res产生影响
                List<Integer> copytmp = new ArrayList<>();
                copytmp.addAll(path);
                res.add(copytmp);
            }
        } else {
            if (node.left != null) {
                helper(node.left,res,path,remaining);
                path.remove(path.size()-1);
            }
            if (node.right != null) {
                helper(node.right,res,path,remaining);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(4);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(3);
        System.out.println(binaryTreePathSum(tree, 5));
    }
}
