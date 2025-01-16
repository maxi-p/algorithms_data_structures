from typing import List
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) <= 1:
            return 0

        cache = dict()
        size = len(prices)

        def dfs(i, bought):
            if i >= size:
                return 0

            if (i,bought) in cache:
                return cache[(i, bought)]
            
            cashed_out, held, buy, wait = 0, 0, 0, 0
            if bought != -1:
                cashed_out = prices[i] - bought + dfs(i+2, -1)
                held = dfs(i+1, bought)
            else:
                buy = dfs(i+1, prices[i])
                wait = dfs(i+1, -1)
            
            cache[(i, bought)] = max(cashed_out, held, buy, wait)
            return max(cashed_out, held, buy, wait)
        return dfs(0, -1)