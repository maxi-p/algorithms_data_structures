class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        set1 = set()
        res = 0
        for num in nums:
            set1.add(num)
        for num in nums:
            if not (num-1 in set1):
                firstNum = num
                num = num+1
                while num in set1:
                    set1.remove(num)
                    num += 1
                res = max(res, num-firstNum)
        return res


        