package question.Problem85.InsertNode.BinarySearchTree;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/11 20:05
 *
 * Given a binary search tree and a new tree node, insert the node into the tree. You should keep the tree still be a valid binary search tree.
 *
 * Example
 * Example 1:
 * 	Input:  tree = {}, node = 1
 * 	Output:  1
 *
 * 	Explanation:
 * 	Insert node 1 into the empty tree, so there is only one node on the tree.
 *
 * Example 2:
 * 	Input: tree = {2,1,4,3}, node = 6
 * 	Output: {2,1,4,3,6}
 *
 * 	Explanation:
 * 	Like this:
 *
 *
 *
 * 	  2             2
 * 	 / \           / \
 * 	1   4   -->   1   4
 * 	   /             / \
 * 	  3             3   6
 *
 * Challenge
 * Can you do it without recursion?
 */
public class InsertNode {
    /*
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        TreeNode cur = root;
        TreeNode parent = null;
        while (cur!=null){
            parent = cur;
            if (cur.val > node.val){
                cur = cur.left;
            } else {
                cur = cur.right;
            }

        }

        if (parent.val > node.val){
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }

    public TreeNode insertNodeRecursive(TreeNode root, TreeNode node){
        if (root == null){return root;}

        if (root.val > node.val){
            root.left = insertNodeRecursive(root,node);
        } else {
            root.right = insertNodeRecursive(root,node);
        }
        return root;
    }
}

class TreeNode {
    public int val;
    public TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}
