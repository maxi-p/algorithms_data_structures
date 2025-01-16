class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        hm = {}
        for c in s:
            if c in hm:
                hm[c] += 1
            else:
                hm[c] = 1
        
        for c in t:
            if c in hm:
                hm[c] -= 1
            else:
                return False
        
        for (key, count) in hm.items():
            if count != 0:
                return False
        return True