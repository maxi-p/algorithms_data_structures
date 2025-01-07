import sys
class Solution:
    def minCostConnectPoints(self, points: List[List[int]]) -> int:
        # 1 create adjacency list
        size = len(points)
        adj = [[] for i in range(size)]

        visited = set()
        for i in range(size):
            for j in range(size):
                if i != j and not (j in visited):
                    cost = abs(points[i][0] - points[j][0]) + abs(points[i][1] - points[j][1])
                    # adj[x] = [points, cost]
                    adj[i].append([j, cost])
                    adj[j].append([i, cost])
            visited.add(i)
        
        # 2 run prims algorithm on it
        visited = set()
        heap = []
        heapq.heappush(heap, (0, 0))
        res = 0

        while heap and len(visited) < size: 
            cost, cur = heapq.heappop(heap)
            if not cur in visited:
                visited.add(cur)
                res += cost
                for neighbor in adj[cur]:
                    heapq.heappush(heap, (neighbor[1], neighbor[0]))
            
        return res