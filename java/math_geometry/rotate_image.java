class Solution 
{
    public void rotate(int[][] matrix) 
    {
        int size        = matrix.length;
        int [][] tmp    = new int [size][size];

        for(int i=0; i<size; i++)
            for(int j=0; j<size; j++)
                tmp[i][j] = matrix[i][j];
        
        for(int y=0; y<size; y++)
            for(int x=0; x<size; x++)
                matrix[y][x] = tmp[size-x-1][y];
    }
}
