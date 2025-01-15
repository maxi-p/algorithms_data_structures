class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        row = len(grid)
        col = len(grid[0])

        if row == 0:
            return 0

        count = 0
        # visited = [[False] * col] * row
        visited = [[False for i in range(col)] for j in range(row)]

        def visitIsland(i, j):
            if i >= row or i < 0 or j >= col or j < 0:
                return
            
            if grid[i][j] == '1' and visited[i][j] == False:
                visited[i][j] = True

                visitIsland(i+1, j)
                visitIsland(i-1, j)
                visitIsland(i, j+1)
                visitIsland(i, j-1)

        for i in range(row):
            for j in range(col):
                if grid[i][j] == '1' and visited[i][j] == False:
                    count += 1
                    visitIsland(i, j)

        return count
        
