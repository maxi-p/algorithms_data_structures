class WordDictionary 
{
    private boolean isWord;
    private WordDictionary[] next;
    public WordDictionary() 
    {
        next = new WordDictionary[26];
    }
    
    public void addWord(String word) 
    {
        WordDictionary dict = this;
        int len = word.length();
        int i = 0;
        while (!word.substring(i,len).equals(""))
        {
            char cur = word.charAt(i);

            if (dict.next[(int)cur-(int)'a'] == null)
            {
                dict.next[(int)cur-(int)'a'] = new WordDictionary();
            }

            dict = dict.next[(int)cur-(int)'a'];
            i++;
        }

        dict.isWord = true;    
    }
    
    public boolean search(String word) 
    {
        if (word.equals(""))
        {
            return isWord;
        }

        char cur = word.charAt(0);
        if (cur == '.') // wildcard
        {
            for (int i=0; i<26; i++)
            {
                if (next[i] != null && next[i].search(word.substring(1, word.length())))
                {
                    return true;
                }
            }
            return false;
        }
        else
        {
            if (next[(int)cur-(int)'a'] == null)
            {
                return false;
            }
            return next[(int)cur-(int)'a'].search(word.substring(1, word.length()));
        }
    }
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
