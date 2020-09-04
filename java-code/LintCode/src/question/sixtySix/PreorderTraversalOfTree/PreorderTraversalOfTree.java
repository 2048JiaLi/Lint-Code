package question.sixtySix.PreorderTraversalOfTree;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/5 16:31
 */
import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
public class PreorderTraversalOfTree {
    /**
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    //二叉树先序遍历
    public static List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        preorder(root,res);
        return res;
    }

    public static void preorder(TreeNode root, List res){
        if (root == null){return;}

        res.add(root.val);
        preorder(root.left,res);
        preorder(root.right,res);
    }

}
