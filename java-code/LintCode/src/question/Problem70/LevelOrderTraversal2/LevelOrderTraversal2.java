package question.Problem70.LevelOrderTraversal2;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/11 18:46
 */
import TreeNode.TreeNode;
import java.util.List;

import question.traversalOfbinaryTree.traversals;
public class LevelOrderTraversal2 {
    /**
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> res = traversals.levelOrder(root);

        int left=0 , right = res.size()-1;
        while (left<right){
            List<Integer> tmp = res.get(left);
            res.set(left,res.get(right));
            res.set(right,tmp);
            left++;
            right--;
        }
        return res;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);

        //root.left = new TreeNode(2);
        //root.right = new TreeNode(5);
        TreeNode node = new TreeNode(2);
        root.right = node;
        node.left = new TreeNode(3);

        List<List<Integer>> res = levelOrderBottom(root);
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }

}
