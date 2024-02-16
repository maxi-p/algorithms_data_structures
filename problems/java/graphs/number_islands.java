class Solution {
    int row;
    int col;
    int [][] visited;
    char[][] arr = null;
    public int numIslands(char[][] grid) {
        arr = grid;
        int islands = 0;
        row = grid.length;
        col = grid[0].length;
        visited = new int[row][col];
        
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                if(visited[i][j] == 0){
                    if(grid[i][j] == '1'){
                        dfs(i,j);
                        islands += 1;
                    }
                    visited[i][j] = 1;
                }
                // System.out.print(grid[i][j]+" ");
            }
        }

        return islands;
    }

    public void dfs(int i, int j){
        if(visited[i][j] == 1){
            return;
        }
        visited[i][j] = 1;
            // top
            int newI = i - 1;
            if(newI >= 0 && visited[newI][j] == 0 && arr[newI][j] == '1'){
                dfs(newI, j);
            }

            // bottom
            newI = i + 1;
            if(newI < row && visited[newI][j] == 0 && arr[newI][j] == '1'){
                dfs(newI, j);
            }
            
            // left
            int newJ = j - 1;
            if(newJ >= 0 && visited[i][newJ] == 0 && arr[i][newJ] == '1'){
                dfs(i,newJ);
            }
            
            // right
            newJ = j + 1;
            if(newJ < col && visited[i][newJ] == 0 && arr[i][newJ] == '1'){
                dfs(i, newJ);
            }
        }

/////////////////////////////////////////////////////////////////

    // int row;
    // int col;
    // int [][] visited;
    // public int numIslands(char[][] grid) {
    //     int islands = 0;
    //     row = grid.length;
    //     col = grid[0].length;
    //     visited = new int[row][col];
        
    //     for(int i = 0; i<row; i++){
    //         for(int j = 0; j<col; j++){
    //             if(visited[i][j] == 0){
    //                 if(grid[i][j] == '1'){
    //                     bfs(i,j, grid, visited);
    //                     islands += 1;
    //                 }
    //                 visited[i][j] = 1;
    //             }
    //             // System.out.print(grid[i][j]+" ");
    //         }
    //     }

    //     return islands;
    // }

    // public void bfs(int i, int j, char [][] grid, int [][] visited){
    //     List<Integer> q = new ArrayList<>();
    //     q.add(i*col + j);
    //     visited[i][j] = 1;

    //     while(q.isEmpty() == false){
    //         //last element removal
    //         int cur = q.get(0);
    //         q.remove(0);

    //         int curI = cur/col;
    //         int curJ = cur%col;


    //         // top
    //         int newI = curI - 1;
    //         if(newI >= 0 && visited[newI][curJ] == 0 && grid[newI][curJ] == '1'){
    //             q.add(newI*col+curJ);
    //             visited[newI][curJ] = 1;
    //         }

    //         // bottom
    //         newI = curI + 1;
    //         if(newI < row && visited[newI][curJ] == 0 && grid[newI][curJ] == '1'){
    //             q.add(newI*col+curJ);
    //             visited[newI][curJ] = 1;
    //         }
            
    //         // left
    //         int newJ = curJ - 1;
    //         if(newJ >= 0 && visited[curI][newJ] == 0 && grid[curI][newJ] == '1'){
    //             q.add(curI*col+newJ);
    //             visited[curI][newJ] = 1;
    //         }
            
    //         // right
    //         newJ = curJ + 1;
    //         if(newJ < col && visited[curI][newJ] == 0 && grid[curI][newJ] == '1'){
    //             q.add(curI*col+newJ);
    //             visited[curI][newJ] = 1;
    //         }
    //     }
    // }

//////////////////////////////////////////////////////////////////////////////////////////////////

    // int row;
    // int col;
    // int [][] visited;
    // public int numIslands(char[][] grid) {
    //     int islands = 0;
    //     row = grid.length;
    //     col = grid[0].length;
    //     visited = new int[row][col];
        
    //     for(int i = 0; i<row; i++){
    //         for(int j = 0; j<col; j++){
    //             if(visited[i][j] == 0){
    //                 if(grid[i][j] == '1'){
    //                     bfs(i,j, grid, visited);
    //                     islands += 1;
    //                 }
    //                 visited[i][j] = 1;
    //             }
    //             // System.out.print(grid[i][j]+" ");
    //         }
    //     }

    //     return islands;
    // }

    // public void bfs(int i, int j, char [][] grid, int [][] visited){
    //     List<List<Integer>> q = new ArrayList<>();
    //     q.add(Arrays.asList(i,j));

    //     while(q.isEmpty() == false){
    //         //last element removal
    //         List<Integer> cur = q.get(q.size()-1);
    //         q.remove(q.size()-1);

    //         int curI = cur.get(0);
    //         int curJ = cur.get(1);
    //         visited[curI][curJ] = 1;

    //         // top
    //         addMove(curI - 1, curJ, q, visited, grid);
    //         // bottom
    //         addMove(curI + 1, curJ, q, visited, grid);
    //         // left
    //         addMove(curI, curJ - 1, q, visited, grid);
    //         // right
    //         addMove(curI, curJ + 1, q, visited, grid);
    //     }
    // }

    // public void addMove(int i, int j, List<List<Integer>> q, int[][] visited, char [][] grid){
    //     List<Integer> node = Arrays.asList(i,j);
    //     if(i >= 0 && j >= 0 && i < row && j < col && visited[i][j] == 0 && grid[i][j] == '1'){
    //         q.add(node);
    //     }
    // }
    
 //////////////////////////////////////////////////////////////////////////////////////////////////   

    // int row;
    // int col;
    // HashSet<List<Integer>> visited = new HashSet<>();
    // int islands = 0;
    // char[][] arr;
    // public int numIslands(char[][] grid) {
    //     arr = grid;
    //     row = grid.length;
    //     col = grid[0].length;
        
    //     for(int i = 0; i<row; i++){
    //         for(int j = 0; j<col; j++){
    //             if(visited.contains(Arrays.asList(i,j)) == false){
    //                 if(grid[i][j] == '1'){
    //                     bfs(i,j);
    //                     islands += 1;
    //                 }
    //                 visited.add(Arrays.asList(i,j));
    //             }
    //             // System.out.print(grid[i][j]+" ");
    //         }
    //     }

    //     return islands;
    // }

    // public void bfs(int i, int j){
    //     List<List<Integer>> q = new ArrayList<>();
    //     List<Integer> node = Arrays.asList(i,j);
    //     visited.add(node);
    //     q.add(node);

    //     while(q.isEmpty() == false){
    //         //last element removal
    //         List<Integer> cur = q.get(q.size()-1);
    //         q.remove(q.size()-1);
    //         visited.add(cur);
    //         int curI = cur.get(0);
    //         int curJ = cur.get(1);

    //         // top
    //         addMove(curI - 1, curJ, q);
    //         // bottom
    //         addMove(curI + 1, curJ, q);
    //         // left
    //         addMove(curI, curJ - 1, q);
    //         // right
    //         addMove(curI, curJ + 1, q);
    //     }
    // }

    // public void addMove(int i, int j, List<List<Integer>> q){
    //     List<Integer> node = Arrays.asList(i,j);
    //     if(i >= 0 && j >= 0 && i < row && j < col && visited.contains(node) == false && arr[i][j] == '1'){
    //         q.add(node);
    //     }
    // }
}