class Solution:
    def jump(self, nums: List[int]) -> int:
        size = len(nums)
        cache = {}

        def dfs(i):
            if i >= size - 1:
                return 0
            if i in cache:
                return cache[i]

            min_jump = 10000001

            for j in range(nums[i], 0, -1):
                min_jump = min(min_jump, 1 + dfs(i+j))
            cache[i] = min_jump
            return min_jump

        return dfs(0)
            
