class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        l, r = 0, len(matrix)-1

        while l < r:
            for i in range(r-l):
                start, end = l, r

                temp = matrix[start][start+i]

                matrix[start][start+i] = matrix[end-i][start]
                matrix[end-i][start] = matrix[end][end-i]
                matrix[end][end-i] = matrix[start+i][end]
                matrix[start+i][end] = temp
            l += 1
            r -= 1