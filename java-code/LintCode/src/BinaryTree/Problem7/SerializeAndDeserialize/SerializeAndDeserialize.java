package BinaryTree.Problem7.SerializeAndDeserialize;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 更多详解见https://mp.weixin.qq.com/s/DVX2A1ha4xSecEXLxW_UsA
 * @author Li W
 * @version 1.8
 * @date 2020/7/1 15:58
 *
 * 这里写的只能处理 0 - 9 的字符
 */
public class SerializeAndDeserialize {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        // write your code here
        /**
         * 层次遍历，输出字符串
         */
        List<String> list = new ArrayList<>();
        preOrder(root,list);
        return list.toString();
    }

    // 前序递归
    public static List<String> preOrder(TreeNode node, List<String> list) {
        if (node == null) {
            list.add("#");
            return list;
        }
        list.add(node.val+"");
        preOrder(node.left,list);
        preOrder(node.right,list);

        return list;
    }

    // 层次遍历可以递归吗
    public static String levelOrder(TreeNode node) {
        if (node == null) {
            return "#";
        }

        Stack<TreeNode> stack = new Stack<>();
        StringBuffer str = new StringBuffer();
        //List<String> list = new ArrayList<>();

        stack.push(node);
        str.append(node.val);

        while (!stack.isEmpty()) {
            Stack<TreeNode> tmp = new Stack<>();
            for (int i = 0; i<stack.size(); i++) {
                TreeNode cur = stack.get(i);
                if (cur.left != null) {
                    tmp.push(cur.left);
                    str.append(cur.left.val);
                } else {
                    str.append("#");
                }

                if (cur.right != null) {
                    tmp.push(cur.right);
                    str.append(cur.right.val);
                } else {
                    str.append("#");
                }
            }
            stack = tmp;
        }
        return str.toString();
    }


    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);

        //System.out.println(serialize(tree));
        //System.out.println(levelOrder(tree));

        deserialize("123##4###");
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        // write your code here
        if (data.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(data.charAt(0) - '0');
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        int index = 0;
        boolean leftChild = true;

        for (int i=1; i<data.length(); i++) {
            char ch = data.charAt(i);
            if (ch != '#'){
                TreeNode tmp = new TreeNode(ch-'0');
                if (leftChild) {
                    stack.get(index).left = tmp;
                } else {
                    stack.get(index).right = tmp;
                }
                stack.add(tmp);
            }
            if (!leftChild) {
                index++;
            }
            leftChild = !leftChild;
        }
        return root;
    }
}
