class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        size = len(candidates)
        res = []
        candidates = sorted(candidates)
        print(candidates)
        def dfs(i, cur, targ):
            if i == size or candidates[i] > targ:
                if targ == 0:
                    res.append(copy.deepcopy(cur))
                return
            
            cur.append(candidates[i])
            dfs(i+1, cur, targ - candidates[i])
            cur.pop()
            
            if i < size - 1:
                while i < size - 1 and candidates[i] == candidates[i+1]:
                    i += 1
            dfs(i+1, cur, targ)

        dfs(0, [], target)
        return res
        