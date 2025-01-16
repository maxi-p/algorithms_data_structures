import copy
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        temp = []

        def back_track(i, cur, cur_sum):
            if cur_sum == target:
                cp = copy.deepcopy(cur)
                res.append(cp)
                return
            if cur_sum > target or i >= len(candidates):
                return
            
            cur.append(candidates[i])
            back_track(i, cur, cur_sum+candidates[i])
            cur.pop()
            back_track(i+1, cur, cur_sum)

        back_track(0, temp, 0)

        return res