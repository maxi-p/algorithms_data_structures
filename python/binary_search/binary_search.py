class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l,r = 0, len(nums) - 1
        res = -1

        while l <= r:
            m = floor((l+r) / 2)
            if nums[m] == target:
                res = m
                break
            elif nums[m] > target:
                r = m - 1
            else:
                l = m + 1

        return res
