# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        glob = 0
        def kthUtil(root: Optional[TreeNode], k:int):
            nonlocal glob
            if root == None:
                return k
            k = kthUtil(root.left, k)
            if k == 1:
                glob = root.val
            return kthUtil(root.right, k-1)
        kthUtil(root, k)
        return glob

        