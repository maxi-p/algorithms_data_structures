class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l, r = 0, len(numbers)-1
        
        while l<r:
            cur = numbers[l] + numbers[r]
            if cur > target:
                while cur > target and l<r:
                    r -= 1
                    cur = numbers[l] + numbers[r]
            elif cur < target:
                while cur < target and l<r:
                    l += 1
                    cur = numbers[l] + numbers[r]
            else:
                break
                
        return [l+1, r+1]
