class Solution:
    def solve(self, board: List[List[str]]) -> None:
        if board is None or len(board) == 0 or len(board[0]) == 0:
            return

        n = len(board)
        m = len(board[0])
        visited = [[0 for i in range(m)] for j in range(n)]
        cache = [[1 for i in range(m)] for j in range(n)]
        
        def dfs(i, j):
            if i<0 or j<0 or i>=n or j>=m:
                return False
            if board[i][j] == 'X':
                return True
            if visited[i][j] == 1:
                if cache[i][j] == 1:
                    return True
                else:
                    return False

            visited[i][j] = 1
            if dfs(i+1,j) and dfs(i,j+1) and dfs(i-1,j) and dfs(i,j-1):
                return True
            else:
                cache[i][j] = 0
        
        def capture(i, j):
            if i<0 or j<0 or i>=n or j>=m:
                return
            if board[i][j] == 'X':
                return
            if visitedSnapshot[i][j] == 1:
                return

            visitedSnapshot[i][j] = 1
            board[i][j] = 'X'

            capture(i+1,j)
            capture(i,j+1)
            capture(i-1,j)
            capture(i,j-1)

        for i in range(len(board)):
            for j in range(len(board[0])):
                if visited[i][j] == 0 and board[i][j] == 'O':
                    visitedSnapshot = copy.deepcopy(visited)
                    if dfs(i, j):
                        capture(i,j)
