package question.traversalOfbinaryTree;

/**
 * @author Li W
 * @version 1.0
 * @date 2020/6/6 15:19
 */

import TreeNode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class traversals {
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

    //中序遍历 --- 非递归
    public static List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode cur = root;

        while (cur!=null || !st.empty()){
            while (cur!=null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    //层次遍历
    public static List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        if (root == null){return new ArrayList<>();}
        List<List<Integer>> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while (!st.empty()){
            List<Integer> tmp = new ArrayList<>();
            Stack<TreeNode> cur = new Stack<TreeNode>();
            while (!st.empty()){
                TreeNode node = st.firstElement();
                st.remove(0);
                tmp.add(node.val);
                if (node.left!=null){
                    cur.push(node.left);
                }
                if (node.right!=null){
                    cur.push(node.right);
                }
            }
            st = cur;
            res.add(tmp);
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

        //List<Integer> res = preorderTraversal(root);
        //List<Integer> res = inorderTraversal(root);
        List<List<Integer>> res = levelOrder(root);
        for (int i=0;i<res.size();i++){
            System.out.println(res.get(i));
        }
    }
}
