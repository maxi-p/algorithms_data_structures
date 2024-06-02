class Solution 
{
    class Trie
    {
        public int isWord;
        public Trie[] next;

        public Trie()
        {
            isWord = 0;
            next = new Trie[26];
        }
    }

    public int              sizeI;
    public int              sizeJ;
    public HashSet<String>  res;
    public Trie             rootTrie;
    
    public List<String> findWords(char[][] board, String[] words) 
    {
        res     = new HashSet<>();
        sizeI   = board.length;
        sizeJ   = board[0].length;

        Trie trie = new Trie();
         rootTrie = trie;

        for(String cur : words)
            insert(trie,cur);
        
        for(int i=0; i<sizeI; i++)
            for(int j=0; j<sizeJ; j++)
            {
                System.out.println("DFS of "+board[i][j]);
                boolean[][] visited = new boolean[sizeI][sizeJ];
                dfs(i, j, board, visited, trie, "");
            }

        List<String> strRes = new ArrayList<>();
        for(String cur : res)
            strRes.add(cur);

        return strRes;
    }

    public void dfs(int i, int j, char[][] board, boolean[][] visited, Trie trie, String cur)
    {
        if (i<0 || i>=sizeI || j<0 || j>=sizeJ || visited[i][j])
            return;
        
        int index       = (int)board[i][j] -(int)'a';

        if(trie.next[index]!=null)
        {
            cur = cur + board[i][j];
            if(trie.next[index].isWord == 1)
            {
                res.add(cur);
                deleteExists(trie, cur);
            }

            visited[i][j]   = true;
            dfs(i+1, j, board, visited, trie.next[index], cur);
            dfs(i, j+1, board, visited, trie.next[index], cur);
            dfs(i-1, j, board, visited, trie.next[index], cur);
            dfs(i, j-1, board, visited, trie.next[index], cur);
            visited[i][j]   = false;
        }
    }
    
    public void insert(Trie root, String word)
    {
        insertRecursive(root, word, 0);
    }

    public void insertRecursive(Trie node, String word, int i)
    {
        if (i == word.length())
        {
            node.isWord = 1;
            return;
        }
        int nextIndex  = (int)word.charAt(i) - (int)'a';
        if (node.next[nextIndex] == null)
            node.next[nextIndex] = new Trie();
        
        insertRecursive(node.next[nextIndex], word, i+1);
    }

    public boolean search(Trie root, String word)
    {
        return searchRecursive(root, word, 0);
    }

    public boolean searchRecursive(Trie node, String word, int i)
    {
        if (i == word.length())
            return node.isWord > 0;
            
        int nextIndex  = (int)word.charAt(i) - (int)'a';
        if (node.next[nextIndex] != null)
            return searchRecursive(node.next[nextIndex], word, i+1);
        
        return false;
    }

    public void deleteExists(Trie root, String word)
    {
        for(int i=0; i<26; i++)
            if(root.next[i] != null)
            {
                root.isWord = 0;
                return;
            }
        
        root = null;        
    }
}
