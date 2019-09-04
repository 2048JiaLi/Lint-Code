'''二叉树的后序遍历'''


class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None


class Solution:
    """
    @param root: A Tree
    @return: Postorder in ArrayList which contains node values.
    """
    def postorderTraversal(self, root):
        # write your code here
        res = self.result(root)
        return list(res)
    def result(self, root):
        if root:
            yield from self.postorderTraversal(root.left)
            yield from self.postorderTraversal(root.right)
            yield root.val