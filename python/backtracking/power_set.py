import copy

class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = []
        cur = []

        def backtrack(i, cur):
            nonlocal res
            if i == len(nums):
                res.append(copy.deepcopy(cur))
                return
            
            backtrack(i+1, cur)
            cur.append(nums[i])
            backtrack(i+1, cur)
            cur.pop()
            
        
        backtrack(0, cur)

        return res