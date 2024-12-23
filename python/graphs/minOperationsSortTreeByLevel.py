# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def minimumOperations(self, root: Optional[TreeNode]) -> int:
        arrays = []
        queue = []
        level, count = 0, 0

        queue.append(root)
        while queue:
            size = len(queue)
            arrays.append([])
            for i in range(size):
                cur = queue.pop(0)
                arrays[level].append(cur.val)
                if (cur.left):
                    queue.append(cur.left)
                if (cur.right):
                    queue.append(cur.right)
            level += 1
        
        for row in arrays:
            cache = {}
            for i, x in enumerate(row):
                cache[x] = i
            sorted_array = sorted(row)
            pointer = 0
            size = len(row)
            while pointer < size - 1:
                if row[pointer] != sorted_array[pointer]:
                    # swap
                    index = cache[sorted_array[pointer]]
                    row[index] = row[pointer]
                    cache[row[pointer]] = index
                    count += 1
                pointer += 1

        return count        