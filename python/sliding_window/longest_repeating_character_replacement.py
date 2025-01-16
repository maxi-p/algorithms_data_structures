class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        if len(s) == 0: return 0 
        l = 0
        freq = {}
        max_freq = 1
        res = 1

        for r in range(len(s)):
            if s[r] in freq:
                freq[s[r]] += 1
                max_freq = max(max_freq, freq[s[r]])
            else:
                freq[s[r]] = 1
            
            cur_len = r - l + 1
            while cur_len - max_freq > k:
                freq[s[l]] -= 1
                l += 1
                cur_len = r - l + 1

            res = max(cur_len, res)
        return res