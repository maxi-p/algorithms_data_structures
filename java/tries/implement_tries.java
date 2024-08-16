class Trie {
    private int[] chars;
    private Trie[] next;

    public Trie() {
        chars = new int[26];
        for(int i=0; i<26; i++){
            chars[i] = 0;
        }

        next = new Trie[26];
    }
    
    public void insert(String word) {
        Trie temp = this;
        int len = word.length();

        int cur;
        for(int i=0; i<len-1; i++){
            // int representation of the char
            cur = (int)word.charAt(i) - 97;

            if(temp.chars[cur] == 0){
                temp.chars[cur] = 1;
            }
            
            if(temp.next[cur] == null)
                temp.next[cur] = new Trie();
            // System.out.println("Inserted: "+word.charAt(i)+" "+temp.chars[cur]);
            temp = temp.next[cur];
        }

        cur = (int)word.charAt(len-1) - 97;
        temp.chars[cur] = 2;
        // System.out.println("Inserted: "+word.charAt(len-1)+" "+temp.chars[cur]);
    }
    
    public boolean search(String word) {
        Trie temp = this;
        int len = word.length();
        int cur;

        for(int i=0; i<len-1; i++){
            // int representation of the char
            cur = (int)word.charAt(i) - 97;
            // System.out.println(word.charAt(i)+" "+temp.chars[cur]);
            if(temp == null || temp.chars[cur] == 0){
                return false;
            }
            temp = temp.next[cur];
        }

        cur = (int)word.charAt(len-1) - 97;
        // System.out.println(word);
        // System.out.println(temp.chars[cur]);
        return temp != null && temp.chars[cur] == 2;
    }
    
    public boolean startsWith(String prefix) {
        Trie temp = this;
        int len = prefix.length();
        for(int i=0; i<len; i++){
            // int representation of the char
            int cur = (int)prefix.charAt(i) - 97;
            if(temp == null || temp.chars[cur] == 0){
                return false;
            }
            temp = temp.next[cur];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */