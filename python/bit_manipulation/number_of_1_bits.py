class Solution:
    def hammingWeight(self, n: int) -> int:
        j = 1
        count = 0
        for i in range(len(bin(n))-2):
            if (n & j) >= 1:
                count += 1
            j = j << 1
        return count