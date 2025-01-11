class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        hash = dict()
        size = len(s)
        i = 0
        res = []
        while i < size - 9:
            cur = s[i:i+10]
            print(len(cur))
            if cur in hash:
                hash[cur] += 1
                if hash[cur] == 2:
                    res.append(cur)     
            else:
                hash[cur] = 1
            i += 1
        return res
