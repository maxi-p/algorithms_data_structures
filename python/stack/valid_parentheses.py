class Solution:
    def isValid(self, s: str) -> bool:
        stack = []

        for char in s:
            if char == '(' or char == '{' or char == '[':
                stack.append(char)
            else:
                if char == ')':
                    if len(stack) == 0:
                        return False
                    peek = stack[len(stack)-1]
                    if peek == '(':
                        stack.pop(-1)
                    else:
                        return False
                elif char == '}':
                    if len(stack) == 0:
                        return False
                    peek = stack[len(stack)-1]
                    if peek == '{':
                        stack.pop(-1)
                    else:
                        return False
                else: # case ']'
                    if len(stack) == 0:
                        return False
                    peek = stack[len(stack)-1]
                    if peek == '[':
                        stack.pop(-1)
                    else:
                        return False
        if len(stack) > 0:
            return False

        return True
                    

        