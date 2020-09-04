package question.Problem93.BinaryTree.Balance;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/12 19:37
 *
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example
 * Example  1:
 * 	Input: tree = {1,2,3}
 * 	Output: true
 *
 * 	Explanation:
 * 	This is a balanced binary tree.
 * 		  1
 * 		 / \
 * 		2  3
 *
 *
 * Example  2:
 * 	Input: tree = {3,9,20,#,#,15,7}
 * 	Output: true
 *
 * 	Explanation:
 * 	This is a balanced binary tree.
 * 		  3
 * 		 / \
 * 		9  20
 * 		  /  \
 * 		 15   7
 *
 *
 * Example  3:
 * 	Input: tree = {1,#,2,3,4}
 * 	Output: false
 *
 * 	Explanation:
 * 	This is not a balanced tree.
 * 	The height of node 1's right sub-tree is 2 but left sub-tree is 0.
 * 		  1
 * 		   \
 * 		   2
 * 		  /  \
 * 		 3   4
 */
public class BalancedTree {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public static boolean isBalanced(TreeNode root) {
        // write your code here
        if (root==null){return true;}
        if (Math.abs(getDepth(root.left) - getDepth(root.right))>1) {return false;}
        return isBalanced(root.right) && isBalanced(root.left);

    }

    // 递归方法，返回节点深度
    public static int getDepth(TreeNode root){
        if (root == null){return 0;}
        int left = getDepth(root.left);
        int right = getDepth(root.right);

        return Math.max(left,right) + 1;
    }


    // 第二种方法
    public static boolean Balanced(TreeNode root){
        if (checkDepth(root) == -1){return false;}
        else return true;
    }

    public static int checkDepth(TreeNode root){
        if (root == null){return 0;}
        int left = checkDepth(root.left);
        if (left == -1){return -1;}
        int right = checkDepth(root.right);
        if (right == -1){return -1;}

        int diff = Math.abs(left-right);
        if (diff>1){return -1;}
        else return Math.max(left,right)+1;
    }
}

class TreeNode{
    public int val;
    public TreeNode left,right;
    public TreeNode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}
