class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hs = set()
        if len(s) == 0:
            return 0

        l = 0
        res = 0
        cur = 0

        for r in range(len(s)):
            while s[r] in hs:
                hs.remove(s[l])
                l += 1
                cur -= 1
            cur += 1
            hs.add(s[r])
            res = max(res, cur)
        return res
