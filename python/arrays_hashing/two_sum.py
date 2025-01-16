class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hm = {}
        for index, num in enumerate(nums):
            if num in hm:
                return [index, hm[num]]
            else:
                hm[target-num] = index
        return []

        