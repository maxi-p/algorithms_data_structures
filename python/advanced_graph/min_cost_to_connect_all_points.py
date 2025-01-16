import heapq
from typing import List
import sys
class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        size = len(points)
        adj = {}

        def calc_dist(a,b):
            return abs(points[a][0] - points[b][0]) + abs(points[a][1] - points[b][1])

        for i in range(size):
            adj[i] = []
            for j in range(size):
                if i != j:
                    dist = calc_dist(i,j)
                    adj[i].append((dist, j))

        # print(adj)

        heap = []
        visited = set()
        res = 0

        heapq.heappush(heap, (0, 0))

        while heap or len(visited) < size:
            (cost, cur) = heapq.heappop(heap)
            if cur not in visited:
                visited.add(cur)
                res += cost

                for neighbor in adj[cur]:
                    heapq.heappush(heap, neighbor)

        return res