class Solution 
{
    public void setZeroes(int[][] matrix) 
    {
        int lenI = matrix.length;
        int lenJ = matrix[0].length;

        int[] rowMask = new int[lenI];
        int[] colMask = new int[lenJ];

        // pre-processing loop
        for(int i=0; i<lenI; i++)
            for(int j=0; j<lenJ; j++)
                if (matrix[i][j] == 0)
                {
                    rowMask[i] = 1;
                    colMask[j] = 1;
                }
        
        for(int i=0; i<lenI; i++)
            for(int j=0; j<lenJ; j++)
            {
                if(rowMask[i] == 1 || colMask[j] == 1)
                    matrix[i][j] = 0;
            }
    }
}
