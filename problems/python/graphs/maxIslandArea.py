class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if grid == None or len(grid) == 0:
            return 0
        n = len(grid)
        m = len(grid[0])

        visited = [[0 for i in range(m)] for j in range(n)]
        globalMax = 0

        def dfs(i, j):
            if i < 0 or j < 0 or i >= n or j >= m:
                return 0
            if grid[i][j] == 0:
                return 0
            if visited[i][j] != 0:
                return 0

            visited[i][j] = 1
            top = dfs(i-1, j)
            bottom = dfs(i+1, j)
            left = dfs(i, j-1)
            right = dfs(i, j+1)

            return 1 + top + bottom + left + right
        
        for i in range(0, n):
            for j in range(0, m):
                if grid[i][j] == 1 and visited[i][j] == 0:
                    curSize = dfs(i, j)
                    globalMax = max(curSize, globalMax)

        return globalMax
