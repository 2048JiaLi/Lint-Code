
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None

class Solution:
    """
    @param root: The root of binary tree.
    @return: An integer
    """
    def maxDepth(self, root):       
        '''
        层次遍历
        '''
        # write your code here
        Depth = 0
        stact = [root]
        if root:
            while stact:
                for i in range(len(stact)):
                    cur = stact.pop(0)
                    if cur.left:
                        stact.append(cur.left)
                    if cur.right:
                        stact.append(cur.right)
                Depth += 1
        return Depth

    def maxDepth2(self, root, comp=lambda x,y: x if x>y else y):
        '''
        递归
        '''
        if root is None:
            return 0
        return comp(self.maxDepth2(root.left),self.maxDepth2(root.right)) + 1
        


if __name__ == '__main__':
    root = TreeNode(1)
    root.left = TreeNode(2)
    root.right = TreeNode(3)
    tmp = root.right
    tmp.left = TreeNode(4)
    tmp.right = TreeNode(5)

    tmp = Solution()
    res = tmp.maxDepth2(root)
    print(res)
