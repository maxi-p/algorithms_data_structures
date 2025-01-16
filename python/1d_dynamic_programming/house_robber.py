from typing import List
class Solution:
    def rob(self, nums: List[int]) -> int:
        size = len(nums)
        cache = dict()

        def dfs(i):
            if i >= size:
                return 0
            if i in cache:
                return cache[i]

            rob = nums[i] + dfs(i+2)
            skip = dfs(i+1)

            cache[i] = max(rob,skip)
            return cache[i]

        return dfs(0)