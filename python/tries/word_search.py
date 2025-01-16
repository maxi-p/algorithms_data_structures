class TrieNode:
    def __init__(self):
        self.next = {}
        self.end = False

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = TrieNode()
        for word in words:
            node = trie
            for char in word:
                if not char in node.next:
                    node.next[char] = TrieNode()
                node = node.next[char]
            node.end = True
        
        n, m = len(board), len(board[0])
        visited = set()
        res = set()
        def dfs(x, y, node, word):
            if x < n and y < m and x >= 0 and y >= 0 and (x, y) not in visited and board[x][y] in node.next:
                visited.add((x,y))
                node = node.next[board[x][y]]
                curWord = word+board[x][y]

                if node.end:
                    res.add(curWord)
                
                dfs(x+1, y, node, curWord)
                dfs(x-1, y, node, curWord)
                dfs(x, y+1, node, curWord)
                dfs(x, y-1, node, curWord)

                visited.remove((x,y))

        for i in range(n):
            for j in range(m):
                visited = set()
                node = trie
                dfs(i, j, node, '')

        res = list(res)
        return res