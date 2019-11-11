class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

class Solution1:        # 最基本的递归方法， 根据节点左右孩子的最大深度判断
    """
    @param root: The root of binary tree.
    @return: True if this Binary tree is Balanced, or false.
    """
    def isBalanced(self, root):
        # write your code here
        if root is None:
            return True
        if self.isBalanced(root.left) == False:
            return False
        if self.isBalanced(root.right) == False:
            return False
        if abs(self.getdepth(root.left)-self.getdepth(root.right))>1:
            return False

        return True

    def getdepth(self, node, comp=lambda x,y: x if x>=y else y):
        if node is None:
            return 0
        return comp(self.getdepth(node.left),self.getdepth(node.right)) + 1

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)


res = Solution1()
print(res.isBalanced(root))


        