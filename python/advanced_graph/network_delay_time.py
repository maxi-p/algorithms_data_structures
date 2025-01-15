class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        visited = set()
        res = 0

        adj_list = [[] for _ in range(n+1)]
        for edge in times:
            # (time, node)
            adj_list[edge[0]].append((edge[2], edge[1]))

        heap = []
        # (time, node)
        heapq.heappush(heap, (0, k))
        while heap and len(visited) < n:
            time, node = heapq.heappop(heap)
            if not (node in visited):
                visited.add(node)
                res = max(res, time)
                for adj in adj_list[node]:
                    heapq.heappush(heap, (adj[0] + time, adj[1]))

        if len(visited) < n:
            return -1
        return res