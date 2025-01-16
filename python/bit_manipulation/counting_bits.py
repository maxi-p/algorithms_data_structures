class Solution:
    def countBits(self, n: int) -> List[int]:
        res = []
        for i in range(n+1):
            bit = 1
            cur_count = 0
            for j in range(len(bin(i))-2):
                if i & bit:
                    cur_count += 1
                bit = bit << 1
            res.append(cur_count)

        return res