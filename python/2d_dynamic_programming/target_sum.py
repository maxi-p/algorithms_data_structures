class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        size = len(nums)
        cache = defaultdict(dict)

        def backtrack(index: int, target: int) -> int:
            nonlocal cache
            if index >= size:
                return 0
            if cache[(index,target)]:
                return cache[(index,target)]
            if index == size - 1:
                if nums[index] == 0 and target == 0:
                    return 2
                if nums[index] == target or -nums[index] == target:
                    return 1
                return 0
            cache[(index,target)] = backtrack(index+1, target - nums[index]) + backtrack(index+1, target + nums[index])
            return cache[(index,target)]
        
        count = backtrack(0, target)

        return count
        