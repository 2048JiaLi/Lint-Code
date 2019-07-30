"""
69. 二叉树的层次遍历
给出一棵二叉树，返回其节点值的层次遍历（逐层从左往右访问）

样例
样例 1:

输入：{1,2,3}
输出：[[1],[2,3]]
解释：
   1
  / \
 2   3
它将被序列化为{1,2,3}
层次遍历
样例 2:

输入：{1,#,2,3}
输出：[[1],[2],[3]]
解释：
1
 \
  2
 /
3
它将被序列化为{1,#,2,3}
层次遍历

挑战
挑战1：只使用一个队列去实现它

挑战2：用BFS算法来做

注意事项
首个数据为根节点，后面接着是其左儿子和右儿子节点值，"#"表示不存在该子节点。
节点数量不超过20。
"""

"""
Definition of TreeNode:
class TreeNode:
    def __init__(self, val):
        self.val = val
        self.left, self.right = None, None
"""

class Solution:
    """
    @param root: A Tree
    @return: Level order a list of lists of integer
    """
    def levelOrder(self, root):
        # write your code here
        res = []
        while(root.val!='#'):
            tmp = []
            self.levelOrder(root.left)
            self.levelOrder(root.right)

    def DFS(self, v):
        if v.val!='#':
            self.DFS(v.left)
            self.DFS(v.right)
            return v.val

            