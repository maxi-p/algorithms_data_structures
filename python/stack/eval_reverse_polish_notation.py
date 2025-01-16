class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        nums = []
        operators = { '*', '+', '-', '/'}

        for token in tokens:
            if token in operators:
                a = nums.pop()
                b = nums.pop()
                if token == '*':
                    c = a * b
                if token == '/':
                    c = b / a
                if token == '+':
                    c = b + a
                if token == '-':
                    c = b - a
                nums.append(int(c))
            else:
                nums.append(int(token))

        return nums[0]
        