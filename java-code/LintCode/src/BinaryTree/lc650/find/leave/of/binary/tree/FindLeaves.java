package BinaryTree.lc650.find.leave.of.binary.tree;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/28 15:28
 *
 * Given a binary tree, collect a tree's nodes as if you were doing this:
 * Collect and remove all leaves, repeat until the tree is empty.
 *
 * Example
 * Example1
 * Input: {1,2,3,4,5}
 * Output: [[4, 5, 3], [2], [1]].
 * Explanation:
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * Example2
 * Input: {1,2,3,4}
 * Output: [[4, 3], [2], [1]].
 * Explanation:
 *
 *     1
 *    / \
 *   2   3
 *  /
 * 4
 */
public class FindLeaves {
    /*
     * @param root: the root of binary tree
     * @return: collect and remove all leaves
     */
    public static List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {return res;}

        // 循环遍历，每次遍历删除叶子节点
        while (root != null) {
            List<Integer> tmp = new ArrayList<>();
            // 得到当前树的所有叶子节点
            root = DFS(root, tmp);
            res.add(tmp);
        }
        return res;
    }

    /**
     * 递归遍历叶子节点
     * @param node
     * @param res
     * @return
     */
    public static TreeNode DFS(TreeNode node, List<Integer> res) {
        if (node == null) {return null;}
        // 是叶子节点
        if (node.left == null && node.right == null) {
            res.add(node.val);
            return null;
        }
        node.left = DFS(node.left, res);
        node.right = DFS(node.right, res);
        return node;
    }

    public static void main(String[] args) {

    }
}
