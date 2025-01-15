class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, r = 0, 1

        size = len(prices)
        res = 0

        while r < size:
            res = max(res, prices[r] - prices[l])
            if prices[r] < prices[l]:
                l = r
                r += 1
            else:
                r += 1

        return res