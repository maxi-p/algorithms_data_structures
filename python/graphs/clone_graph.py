"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

from typing import Optional
class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if not node:
            return None

        visited = set()
        hs = {}

        def dfs(root):
            visited.add(root)
            hs[root] = Node(root.val)
            for neigh in root.neighbors:
                if neigh not in visited:
                    dfs(neigh)
        
        dfs(node)
        
        for orig, copy in hs.items():
            for neigh in orig.neighbors:
                copy.neighbors.append(hs[neigh])

        return hs[node]
        