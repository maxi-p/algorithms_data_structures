class Solution:
    def canJump(self, nums: List[int]) -> bool:
        size = len(nums)
        cache = [-1 for _ in range(size)]
        
        def dfs(i):
            if i >= size -1:
                return True
            if cache[i] != -1:
                return True if cache[i] == 1 else False
            
            for j in range(nums[i], 0, -1):
                if dfs(i+j):
                    cache[i] = True
                    return True

            cache[i] = False
            return False


        return dfs(0)
