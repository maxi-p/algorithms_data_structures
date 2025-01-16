class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        size1, size2 = len(text1), len(text2)
        cache = [[-1 for _ in range(size2)] for _ in range(size1)]
        
        def lcs(i, j):
            if i >= size1 or j >= size2:
                return 0
            if cache[i][j] != -1:
                return cache[i][j]
            
            one = lcs(i+1, j+1)
            if text1[i] == text2[j]:
                one += 1
            two = lcs(i+1, j)
            tree = lcs(i, j+1)

            cache[i][j] = max(one, two, tree)
            return cache[i][j]
        
        return lcs(0,0)
    
    def longestCommonSubsequenceTabular(self, text1: str, text2: str) -> int:
        n, m = len(text1), len(text2)
        cache = [[0 for _ in range(m+1)] for _ in range(n+1)]

        for i in range(n-1, -1, -1):
            for j in range(m-1, -1, -1):
                one = cache[i+1][j+1]
                two = cache[i][j+1]
                three = cache[i+1][j]
                if text1[i] == text2[j]:
                    one += 1
                cache[i][j] = max(one, two, three)
        
        return cache[0][0]
            
        
