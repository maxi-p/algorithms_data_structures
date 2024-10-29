class Solution {
    int inf = -2;
    public void islandsAndTreasure(int[][] grid) {
        List<int[]> queue = new ArrayList<>();
        
        int[][] visited = new int[grid.length][grid[0].length];
        for (int i=0; i<grid.length; i++) {
            Arrays.fill(visited[i], 0);
        }

        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 0){
                    int [] goal = new int[2];
                    goal[0] = i;
                    goal[1] = j;
                    queue.add(goal);
                    visited[i][j] = 1;
                }
            }
        }

        // queue [[0,0]]
        // cur = [3,2]
        // val = 4
        //
        // [ 3,-1, 0,-2]
        // [ 2, 2, 1,-1]
        // [ 1,-1, 2,-1]
        // [ 0,-1, 3, 4]

        // visited
        // [ 1, 0, 1, 0]
        // [ 1, 1, 1, 0]
        // [ 1, 0, 1, 0]
        // [ 1, 0, 1, 1]

        while (queue.size() > 0) {
            int [] cur = queue.get(0);
            queue.remove(0);
            int i = cur[0], j = cur[1];

            int thisLvl = grid[i][j] + 1;
            if (i-1 >=0 && grid[i-1][j] != -1 && visited[i-1][j] != 1){
                grid[i-1][j] = thisLvl;
                visited[i-1][j] = 1;
                int[] newNode = new int[2];
                newNode[0] = i-1;
                newNode[1] = j;
                queue.add(newNode);
            }
            if (i+1 < grid.length && grid[i+1][j] != -1 && visited[i+1][j] != 1){
                grid[i+1][j] = thisLvl;
                visited[i+1][j] = 1;
                int[] newNode = new int[2];
                newNode[0] = i+1;
                newNode[1] = j;
                queue.add(newNode);
            }
            if (j-1 >=0 && grid[i][j-1] != -1 && visited[i][j-1] != 1){
                grid[i][j-1] = thisLvl;
                visited[i][j-1] = 1;
                int[] newNode = new int[2];
                newNode[0] = i;
                newNode[1] = j-1;
                queue.add(newNode);
            }
            if (j+1 < grid[0].length && grid[i][j+1] != -1 && visited[i][j+1] != 1){
                grid[i][j+1] = thisLvl;
                visited[i][j+1] = 1;
                int[] newNode = new int[2];
                newNode[0] = i;
                newNode[1] = j+1;
                queue.add(newNode);
            }
        }
    }
}
