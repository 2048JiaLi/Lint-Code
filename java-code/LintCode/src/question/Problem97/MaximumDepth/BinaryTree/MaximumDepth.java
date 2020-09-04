package question.Problem97.MaximumDepth.BinaryTree;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/13 14:10
 */

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumDepth {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     *
     * Given a binary tree, find its maximum depth.
     *
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     *
     * Example
     * Example 1:
     *
     * Input: tree = {}
     * Output: 0
     * Explanation: The height of empty tree is 0.
     * Example 2:
     *
     * Input: tree = {1,2,3,#,#,4,5}
     * Output: 3
     * Explanation: Like this:
     *    1
     *   / \
     *  2   3
     *     / \
     *    4   5
     * it will be serialized {1,2,3,#,#,4,5}
     */

    //递归
    public static int maxDepth(TreeNode root) {
        // write your code here
        if (root == null){return 0;}
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return left>right?left:right;
    }


    public static int BFSdepth(TreeNode root){
        if (root == null){return 0;}
        int depth = 0;

        List<TreeNode> nodelist = new ArrayList<TreeNode>();
        nodelist.add(root);
        while (!nodelist.isEmpty()){
            int length = nodelist.size();
            for (int i=0;i<length;i++){
                TreeNode node = nodelist.get(0);
                nodelist.remove(0);
                if (node.left != null){
                    nodelist.add(node.left);
                }
                if (node.right != null){
                    nodelist.add(node.right);
                }
            }
            depth += 1;
        }
        return depth;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(BFSdepth(root));
    }

}
