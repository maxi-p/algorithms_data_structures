class Solution:
    def isPalindrome(self, s: str) -> bool:
        alpha_num = s.lower()
        new_str = ""
        
        for char in alpha_num:
            if (ord(char) >= ord('a') and ord(char) <= ord('z')) or (ord(char) >= ord('0') and ord(char) <= ord('9')):
                new_str += char
            
        if new_str == "":
            return True
        
        l, r = 0, len(new_str) - 1

        while l < r:
            if new_str[l] != new_str[r]:
                return False
            l += 1
            r -= 1
        
        return True
