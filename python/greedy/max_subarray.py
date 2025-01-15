class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0

        l, cur, res = 0, 0, float('-inf')

        for r in range(len(nums)):
            if cur < 0 and nums[r] >= cur:
                l = r
                cur = 0
            cur += nums[r]
            res = max(res, cur)

        return res