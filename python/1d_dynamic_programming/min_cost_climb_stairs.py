class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        size = len(cost)
        cache = dict()
        cache = [-1 for _ in range(size)]
        def dfs(i):
            if i >= size:
                return 0
            if cache[i] != -1:
                return cache[i]

            cache[i] = cost[i] + min(dfs(i+1), dfs(i+2))
            return cache[i]
        
        return min(dfs(0), dfs(1))