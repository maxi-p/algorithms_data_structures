class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        high = piles[0]
        low = 1
        res = high

        def canFinish(speed, h):
            for pile in piles:
                if pile <= speed:
                    h -= 1
                else:
                    hours = math.ceil(pile/speed)
                    h -= hours
                if h < 0:
                    return False
            return True


        for pile in piles:
            high = max(high, pile)

        while high >= low:
            mid = int((high + low)/2)

            if canFinish(mid, h):
                res = mid
                high = mid - 1
            else:
                low = mid + 1
        
        return res
        