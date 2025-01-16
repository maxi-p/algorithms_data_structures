class Node:
    def __init__(self):
        self.next = dict()
        self.end = False

class WordDictionary:

    def __init__(self):
        self.trie = Node()

    def addWord(self, word: str) -> None:
        trie = self.trie
        for c in word:
            if c not in trie.next:
                trie.next[c] = Node()
            trie = trie.next[c]
        trie.end = True

    def search(self, word: str) -> bool:
        root = self.trie
        size = len(word)

        def dfs(trie, i):
            if i == size:
                return trie.end

            if word[i] == '.':  
                for (char, node) in trie.next.items():
                    if dfs(node, i+1):
                        return True
                return False
            if word[i] not in trie.next:
                return False
            return dfs(trie.next[word[i]], i+1)

        return dfs(root, 0)

# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)