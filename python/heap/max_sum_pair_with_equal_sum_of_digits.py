import heapq
class Solution:
    def maximumSum(self, nums: List[int]) -> int:
        adj = {}
        sums = []

        for i, num in enumerate(nums):
            sums.append(0)
            total = 0
            while num > 0:
                total += num % 10
                num //= 10
            if total not in adj:
                adj[total] = []
            heapq.heappush(adj[total], -nums[i])
        
        res = -1

        for key, arr in adj.items():
            if len(arr) > 1:
                one = -heapq.heappop(arr)
                two = -heapq.heappop(arr)
                res = max(res, one + two)        
            
        return res