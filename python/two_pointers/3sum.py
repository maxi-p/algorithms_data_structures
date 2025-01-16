class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        size = len(nums)
        nums = sorted(nums)
        print(nums)
        
        def two_sum(target, i):
            l, r = i, size-1
            while l < r:
                cur = nums[l] + nums[r]
                if cur > target:
                    r -= 1
                    while l < r and nums[r] == nums[r+1]:
                        r -= 1
                elif cur < target:
                    l += 1
                    while l < r and nums[l] == nums[l-1]:
                        l += 1
                else:
                    res.append([-target, nums[l], nums[r]])
                    l += 1
                    while l < r and nums[l] == nums[l-1]:
                        l += 1

        i = 0
        while i < size-1: 
            two_sum(-nums[i], i+1)
            i += 1
            while i < size-1 and nums[i] == nums[i-1]:
                i += 1

        return res
        