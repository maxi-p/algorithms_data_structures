class Solution 
{
    public boolean      done;
    public int          sizeY;
    public int          sizeX;
    public boolean[][]  visited;

    public List<Integer> spiralOrder(int[][] matrix) 
    {
        if (matrix.length == 0)
            return new ArrayList<Integer>();

        sizeY   = matrix.length-1;
        sizeX   = matrix[0].length-1;
        visited = new boolean[sizeY+2][sizeX+2];
        
        // 0 right, 1 down, 2 left, 3 up
        int             state   = 0;
        int             x       = 0;
        int             y       = 0;
        List<Integer>   res     = new ArrayList<>();

        while(true)
        {
            res.add(matrix[y][x]);
            visited[y][x] = true;

            switch(state) 
            {
                case 0: // right
                    if(x==sizeX || visited[y][x+1])
                    {
                        state++;
                        y++;
                        checkDone(x,y);
                    }
                    else
                        x++;
                    break;
                case 1: // down
                    if(y==sizeY || visited[y+1][x])
                    {
                        state++;
                        x--;
                        checkDone(x,y);
                    }
                    else
                        y++;
                    break;
                case 2: // left
                    if(x==0 || visited[y][x-1])
                    {
                        state++;
                        y--;
                        checkDone(x,y);
                    }
                    else
                        x--;
                    break;
                case 3: // up
                    if(y==0 || visited[y-1][x])
                    {
                        state = 0;
                        x++;
                        checkDone(x,y);
                    }
                    else
                        y--;
                    break;
                default:
                    return res;
            }
            if (done)
            {
                return res;
            }
        }  
    }

    public void checkDone(int x, int y)
    {
        if (x<0 || y<0 || x>sizeX || y>sizeY || visited[y][x])
            done = true;
    }
}
