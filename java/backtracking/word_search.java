// beats 93.59% of users with Java
class Solution {
    public boolean [][] visited;
    public boolean exist(char[][] board, String word) {
        if( board.length > 0 && word.length() != 0 )
        {
            visited = new boolean[board.length][board[0].length];
            for ( int i=0; i<board.length ; i++ )
            {
                for ( int j=0; j<board[i].length ; j++ )
                {
                    if ( visited[i][j] == false && board[i][j] == word.charAt(0) )
                    {
                        visited[i][j] = true;
                        if ( 1 == word.length() )
                        {
                            return true;
                        }
                        if ( backtr(board, word, 1, i, j, visited) )
                        {
                            return true;
                        }
                        visited[i][j] = false;  
                    }
                }
            }
        }

        return false;  
    }

    public boolean backtr(char[][] board, String word, int index, int i, int j, boolean[][] visited)
    {
        if ( i-1 >= 0 && visited[i-1][j] == false && board[i-1][j] == word.charAt(index) )
        {
            visited[i-1][j] = true;
            if ( index == word.length()-1 )
            {
                return true;
            }
            if ( backtr(board, word, index+1, i-1, j, visited) == true )
            {
                return true;
            }
            visited[i-1][j] = false;
        }
        if ( i+1 < board.length && visited[i+1][j] == false && board[i+1][j] == word.charAt(index) )
        {
            visited[i+1][j] = true;
            if ( index == word.length()-1 )
            {
                return true;
            }
            if ( backtr(board, word, index+1, i+1, j, visited) == true )
            {
                return true;
            }
            visited[i+1][j] = false;
        }
        if ( j+1 < board[i].length && visited[i][j+1] == false && board[i][j+1] == word.charAt(index) )
        {
            visited[i][j+1] = true;
            if ( index == word.length()-1 )
            {
                return true;
            }
            if ( backtr(board, word, index+1, i, j+1, visited) == true )
            {
                return true;
            }
            visited[i][j+1] = false;
        }
        if ( j-1 >= 0 && visited[i][j-1] == false && board[i][j-1] == word.charAt(index) )
        {
            visited[i][j-1] = true;
            if ( index == word.length()-1 )
            {
                return true;
            }
            if ( backtr(board, word, index+1, i, j-1, visited) == true )
            {
                return true;
            }
            visited[i][j-1] = false;
        }
        return false;
    }
}
