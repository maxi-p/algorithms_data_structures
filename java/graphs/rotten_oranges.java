class Solution {
    public HashSet<Integer> rottens;
    public ArrayList<Integer> toAdd;
    public ArrayList<Integer> toRemove;
    public int clock = -1;
    public int n, m;

    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return -1;

        n = grid.length;
        m = grid[0].length;
        rottens = new HashSet<>();
        toAdd = new ArrayList<>();
        toRemove = new ArrayList<>();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 2){
                    rottens.add(i * m + j);
                }
                
        if (rottens.size() == 0) {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    if (grid[i][j] == 1)
                        return -1;
            return 0;
        }

        while (rottens.size() > 0) {
            clock += 1;
            for (Integer cur : rottens) {
                int expanded = expand(cur, grid);
                if (expanded == 0)
                    toRemove.add(cur);
            }
            while (toAdd.size() > 0) {
                rottens.add(toAdd.get(0));
                toAdd.remove(0);
            }
            while (toRemove.size() > 0) {
                rottens.remove(toRemove.get(0));
                toRemove.remove(0);
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                System.out.println(grid[i][j]);

        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (grid[i][j] == 1)
                    return -1;
        return clock;
    }

    public int expand(int cur, int[][] grid) {
        int i = cur / m;
        int j = cur % m;
        int expanded = 0;

        if (i - 1 >= 0 && grid[i - 1][j] == 1) {
            expanded += 1;
            grid[i - 1][j] = 2;
            toAdd.add((i - 1) * m + j);
        }
        if (i + 1 < n && grid[i + 1][j] == 1) {
            expanded += 1;
            grid[i + 1][j] = 2;
            toAdd.add((i + 1) * m + j);
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1) {
            expanded += 1;
            grid[i][j - 1] = 2;
            toAdd.add(i * m + j - 1);
        }
        if (j + 1 < m && grid[i][j + 1] == 1) {
            expanded += 1;
            grid[i][j + 1] = 2;
            toAdd.add(i * m + j + 1);
        }
        return expanded;
    }
}
