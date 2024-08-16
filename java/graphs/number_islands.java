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

}