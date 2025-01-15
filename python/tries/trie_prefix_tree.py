class Node:
    def __init__(self):
        self.next = [None] * 26
        self.end = False

class Trie:
    def __init__(self):
        self.trie = Node()

    def insert(self, word: str) -> None:
        pointer = self.trie
        
        for char in word:
            index = ord(char) - 97
            if not pointer.next[index]:
                pointer.next[index] = Node()
            pointer = pointer.next[index]
        
        pointer.end = True
        return

    def search(self, word: str) -> bool:
        pointer = self.trie
        for char in word:
            index = ord(char) - 97
            if not pointer.next[index]:
                return False
            pointer = pointer.next[index]
        
        if pointer.end:
            return True
        else:
            return False

    def startsWith(self, prefix: str) -> bool:
        pointer = self.trie
        for char in prefix:
            index = ord(char) - 97
            if not pointer.next[index]:
                return False
            pointer = pointer.next[index]
        
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)