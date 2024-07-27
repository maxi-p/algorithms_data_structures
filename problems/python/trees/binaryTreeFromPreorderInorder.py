# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        hash = {}
        for index in range(len(inorder)):
            hash[inorder[index]] = index
        def util(start: int, end: int, startInorder: int, endInorder: int):
            root = TreeNode(preorder[start])
            if start == end:
                return root
            
            index = hash[root.val]
			
            if index != startInorder:
                root.left = util(start+1, start+(index-startInorder), startInorder, index-1)
            if index != endInorder:
                root.right = util(start+(index-startInorder)+1, end, index+1, endInorder)
            return root
        return util(0, len(preorder)-1, 0, len(inorder)-1)
