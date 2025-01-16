class Solution:
    def spiralOrderOptimal(self, matrix: List[List[int]]) -> List[int]:
        top, bottom = 0, len(matrix)
        left, right = 0, len(matrix[0])
        res = []

        while top < bottom and left < right:
            # print('top')
            for i in range(left, right):
                # print(matrix[top][i])
                res.append(matrix[top][i])
            top += 1
            if top >= bottom:
                break

            # print('right')
            for i in range(top, bottom):
                # print(matrix[i][right-1])
                res.append(matrix[i][right-1])
            right -= 1
            if left >= right:
                break

            # print('bottom')
            for i in range(right-1, left-1, -1):
                # print(matrix[bottom-1][i])
                res.append(matrix[bottom-1][i])
            bottom -= 1
            if top >= bottom:
                break

            # print('left')
            for i in range(bottom-1, top-1, -1):
                # print(matrix[i][left])
                res.append(matrix[i][left])
            left += 1
            if left >= right:
                break

        return res

    def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        RIGHT, DOWN, LEFT, UP  = 0, 1, 2, 3
        n,m = len(matrix),len(matrix[0])
        visited = [[False for _ in range(m)] for _ in range(n)]
        switch = 0
        res = []
        
        i,j = 0,0
        direction = RIGHT
        while True:
            if not visited[i][j]:
                res.append(matrix[i][j])
                visited[i][j] = True
            if switch == 2:
                break
            if direction == RIGHT:
                if j+1<m and not visited[i][j+1]:
                    j+=1
                    switch = 0
                else:
                    direction = DOWN
                    switch += 1
            elif direction == DOWN:
                if i+1<n and not visited[i+1][j]:
                    i+=1
                    switch = 0
                else:
                    direction = LEFT
                    switch += 1
            elif direction == LEFT:
                if j-1>=0 and not visited[i][j-1]:
                    j-=1
                    switch = 0
                else:
                    direction = UP
                    switch += 1
            elif direction == UP:
                if i-1>=0 and not visited[i-1][j]:
                    i-=1
                    switch = 0
                else:
                    direction = RIGHT
                    switch += 1
        return res