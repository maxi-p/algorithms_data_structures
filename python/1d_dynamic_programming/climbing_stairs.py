class Solution:
    def climbStairs(self, n: int) -> int:
        cache = [-1 for _ in range(n)]

        def back_track(x):
            if x > n:
                return 0
            if x == n:
                return 1

            if cache[x] != -1:
                return cache[x]
            cache[x] = back_track(x+1) + back_track(x+2)
            
            return cache[x]

        return back_track(0)