class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        hash = dict()
        size = len(s)
        i = 0
        res = []
        while i < size - 9:
            cur = s[i:i+10]
            if cur in hash:
                hash[cur] += 1
            else:
                hash[cur] = 1
            i += 1
        return [key for key,value in hash.items() if value > 1]
