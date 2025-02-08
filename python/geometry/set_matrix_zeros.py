from typing import List
class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        n, m = len(matrix), len(matrix[0])
        rows = set()
        cols = set()

        for i in range(n):
            for j in range(m):
                if matrix[i][j] == 0:
                    rows.add(i)
                    cols.add(j)
        
        for i in range(n):
            if i in rows:
                for j in range(m):
                    matrix[i][j] = 0
                
        for j in range(m):
            if j in cols:
                for i in range(n):
                    matrix[i][j] = 0