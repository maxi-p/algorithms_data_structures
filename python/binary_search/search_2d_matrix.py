from math import floor

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row,col = len(matrix), len(matrix[0])

        def get_tuple(index):
            return (int(index / col), int(index % col))

        size = row*col

        l,r = 0, size-1
        while l <= r:
            m = floor((l+r)/2)
            (i, j) = get_tuple(m)
            if matrix[i][j] < target:
                l = m+1
            elif matrix[i][j] > target:
                r = m-1
            else:
                return True
        
        return False