package BinaryTree.Problem11.SearchRange;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/3 15:40
 *
 * Given a binary search tree and a range [k1, k2],
 * return node values within a given range in ascending order.
 *
 * Example
 * Example 1:
 *
 * Input：{5},6,10
 * Output：[]
 *         5
 * it will be serialized {5}
 * No number between 6 and 10
 * Example 2:
 *
 * Input：{20,8,22,4,12},10,22
 * Output：[12,20,22]
 * Explanation：
 *         20
 *        /  \
 *       8   22
 *      / \
 *     4   12
 * it will be serialized {20,8,22,4,12}
 * [12,20,22] between 10 and 22
 */
public class SearchRange {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public static List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (root == null) {return list;}
        return inorder(root,list,k1,k2);
    }

    /**
     * 找比k1小的
     */
    public static List<Integer> inorder(TreeNode root, List<Integer> list, int k1, int k2) {
        if (root == null) {return list;}

        if (root.val > k1) {
            list = inorder(root.left,list,k1,k2);
        }

        if (root.val >= k1 && root.val <= k2){
            list.add(root.val);
        }

        if (root.val < k2) {
            list = inorder(root.right,list,k1,k2);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(20);
        tree.left = new TreeNode(8);
        tree.right = new TreeNode(22);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(12);

        System.out.println(searchRange(tree,10,22).toString());
        //searchRange(tree,10,22);
    }
}
