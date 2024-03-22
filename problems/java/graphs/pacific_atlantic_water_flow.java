class Solution {
    public static int ROWS;
    public static int COLS;
    public static int [][] arr;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        arr = heights;
        ROWS = heights.length;
        COLS = heights[0].length;
        int [][] visitedAtlantic = new int[ROWS][COLS];
        int [][] visitedPacific = new int[ROWS][COLS];
        int [][] pacific;
        int [][] atlantic;
        pacific = new int[ROWS][COLS];
        atlantic = new int[ROWS][COLS];
        for(int c=0;c<COLS;c++){
            dfs(0,c,heights[0][c], pacific, visitedPacific);
            dfs(ROWS-1,c,heights[ROWS-1][c], atlantic, visitedAtlantic);
        }
        for(int r=0;r<ROWS; r++){
            dfs(r,0,heights[r][0], pacific, visitedPacific);
            dfs(r,COLS-1,heights[r][COLS-1], atlantic, visitedAtlantic);
        }

        for(int i=0;i<ROWS;i++){
            for(int j=0; j<COLS; j++){
                if(atlantic[i][j] == 1 && pacific[i][j] == 1)
                    res.add(Arrays.asList(i,j));
            }
        }
        return res;
    }

    public static void dfs(int r, int c, int prevValue, int[][] set, int [][]visited){
        if(r>=0 && c>=0 && r<ROWS && c<COLS && visited[r][c] == 0 && arr[r][c] >= prevValue){
            visited[r][c] = 1;
            set[r][c] = 1;
            int val = arr[r][c];
            dfs(r+1,c,val,set, visited);
            dfs(r-1,c,val,set, visited);
            dfs(r,c+1,val,set, visited);
            dfs(r,c-1,val,set, visited);
        }
    }

    // public static int [][] dp;
    // public static int [][] visited;
    // public static int row, col;
    // public static int [][] arr;
    // public List<List<Integer>> pacificAtlantic(int[][] heights) {
    //     row = heights.length;
    //     col = heights[0].length;
    //     List<List<Integer>> res = new ArrayList<>();;
    //     dp = new int[row][col];
    //     for(int i=0;i<row; i++){
    //         for(int j = 0; j < col; j++){
    //             dp[i][j] = -1;
    //         }
    //     }

    //     visited = new int[row][col];
    //     arr = heights;
    //     for(int i=0; i<row; i++){
    //         for(int j=0;j<col;j++){
    //             int cur = getRes(i,j);
    //             if(cur == 3){
    //                 res.add(Arrays.asList(i,j));
    //             }
    //         }
    //     }

    //     return res;

    // }

    // only atlantic = 2
    // only pacific = 1
    // both = 3
    // neither = 0
    // not done = -1
    // public static int getRes(int i, int j){
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     visited[i][j] = 1;
        
    //     int pacific = 0;
    //     int atlantic = 0;
    //     int down = 0;
    //     int left = 0;
    //     int up = 0;
    //     int right = 0;
    //     if(i+1 < row){
    //         if(arr[i+1][j] <= arr[i][j]){
    //             down = getRes(i+1,j);
    //             if(down == 2)
    //                 atlantic = 1;
    //             if(down == 1)
    //                 pacific = 1;
    //         }

    //     }
    //     else
    //         atlantic = 1;
            
    //     if(j-1 >= 0){
    //         if(arr[i][j-1] <= arr[i][j]){
    //             left = getRes(i,j-1);
    //             if(left == 2)
    //                 atlantic = 1;
    //             if(left == 1)
    //                 pacific = 1;
    //         }
    //     }
    //     else
    //         pacific = 1;

    //     if(i-1 >= 0){
    //         if(arr[i-1][j] <= arr[i][j]){
    //             up = getRes(i-1,j);
    //             if(up == 2)
    //                 atlantic = 1;
    //             if(up == 1)
    //                 pacific = 1;
    //         }
    //     }
    //     else
    //         pacific = 1;

    //     if(j+1 < col){
    //         if(arr[i][j+1] <= arr[i][j]){
    //             right = getRes(i-1,j);
    //             if(right == 2)
    //                 atlantic = 1;
    //             if(right == 1)
    //                 pacific = 1;
    //         }
    //     }
    //     else
    //         atlantic = 2;
        
    //     if(up == 3 || down == 3 || left == 3 || right == 3){
    //         dp[i][j] = 3;
    //         return 3;
    //     }
    //     if(atlantic == 1 && pacific == 1){
    //         dp[i][j] = 3;
    //         return 3;
    //     }
    //     if(atlantic == 1){
    //         dp[i][j] = 2;
    //         return 2;
    //     }
    //     if(pacific == 1){
    //         dp[i][j] = 1;
    //         return 1;
    //     }
    //     else{
    //         dp[i][j] = 0;
    //         return 0;
    //     }


    // }


}