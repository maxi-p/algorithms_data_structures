# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        res = 0

        def dfs(node):
            nonlocal res
            if not node or (not node.left and not node.right):
                return 0

            left = dfs(node.left)
            right = dfs(node.right)
            print(left)
            print(right)

            if node.left:
                span_left = left + 1
            else:
                span_left = left
            if node.right:
                span_right = right + 1
            else:
                span_right = right
            res = max(res, span_left + span_right)
            
            return 1 + max(left, right)
        
        dfs(root)
        return res
        