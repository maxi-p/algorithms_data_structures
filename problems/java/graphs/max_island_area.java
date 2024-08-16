class Solution {
    public int globalMax = 0;
    public int n, m, islandCount;

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null)
            return 0;
        islandCount = 1;
        n = grid.length;
        m = grid[0].length;
        int [][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] == 0) {
                    int currentSize = dfs(grid, i, j, visited);
                    islandCount++;
                    globalMax = Math.max(globalMax, currentSize);
                }
            }
        }
        return globalMax;
    }

    public int dfs(int[][] grid, int i, int j, int[][] visited) {
        if (i < 0 || j < 0 || i >= n || j >= m)
            return 0;
        if (grid[i][j] == 0)
            return 0;
        if (visited[i][j] != 0)
            return 0;
        visited[i][j] = islandCount;
        int top = dfs(grid, i - 1, j, visited);
        int bottom = dfs(grid, i + 1, j, visited);
        int left = dfs(grid, i, j - 1, visited);
        int right = dfs(grid, i, j + 1, visited);
        return 1 + top + bottom + right + left;
    }
}
