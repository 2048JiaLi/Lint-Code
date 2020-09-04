package BinaryTree.Problem242.ConvertBinaryTreeToLinkedListsbyDepth;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Li W
 * @version 1.8
 * @date 2020/7/12 14:25
 *
 * Given a binary tree, design an algorithm which creates a linked list of
 * all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
 *
 * Example
 * Example 1:
 *
 * Input: {1,2,3,4}
 * Output: [1->null,2->3->null,4->null]
 * Explanation:
 *         1
 *        / \
 *       2   3
 *      /
 *     4
 * Example 2:
 *
 * Input: {1,#,2,3}
 * Output: [1->null,2->null,3->null]
 * Explanation:
 *     1
 *      \
 *       2
 *      /
 *     3
 */
public class Convert {
    /**
     * 层次遍历二叉树，每层节点以链表的形式输出
     *
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public static List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        // 输出结果
        List<ListNode> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // 层次遍历栈
        List<TreeNode> stack = new ArrayList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            // 该层节点的链表形式
            list.add(new ListNode(-1));
            ListNode level = list.get(list.size()-1);
            List<TreeNode> tmp = new ArrayList<>();

            // 该层节点的遍历
            while (!stack.isEmpty()) {
                // 出栈
                TreeNode node = stack.get(0);
                stack.remove(0);
                level.next = new ListNode(node.val);
                level = level.next;
                if (node.left != null) {
                    tmp.add(node.left);
                }
                if (node.right != null) {
                    tmp.add(node.right);
                }
            }

            // 下一层
            stack = tmp;
            list.set(list.size()-1,list.get(list.size()-1).next);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        System.out.println(binaryTreeToLists(tree).toString());
    }

    private static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            ListNode node = next;
            String res = ""+val;
            while (node!=null) {
                res += "->"+node.val;
                node = node.next;
            }

            return res;
        }
    }
}
